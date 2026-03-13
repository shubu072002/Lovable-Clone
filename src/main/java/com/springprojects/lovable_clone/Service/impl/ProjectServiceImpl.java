package com.springprojects.lovable_clone.Service.impl;

import com.springprojects.lovable_clone.Entity.Project;
import com.springprojects.lovable_clone.Entity.ProjectMember;
import com.springprojects.lovable_clone.Entity.ProjectMemberId;
import com.springprojects.lovable_clone.Entity.User;
import com.springprojects.lovable_clone.Service.ProjectService;
import com.springprojects.lovable_clone.Service.ProjectTemplateService;
import com.springprojects.lovable_clone.Service.SubscriptionService;
import com.springprojects.lovable_clone.dto.project.ProjectRequest;
import com.springprojects.lovable_clone.dto.project.ProjectResponse;
import com.springprojects.lovable_clone.dto.project.projectSummaryResponse;
import com.springprojects.lovable_clone.enums.ProjectRole;
import com.springprojects.lovable_clone.error.BadRequestException;
import com.springprojects.lovable_clone.error.ResourceNotFoundException;
import com.springprojects.lovable_clone.mapper.ProjectMapper;
import com.springprojects.lovable_clone.repositories.ProjectMemberRepository;
import com.springprojects.lovable_clone.repositories.ProjectRepository;
import com.springprojects.lovable_clone.repositories.UserRepository;
import com.springprojects.lovable_clone.security.AuthUtil;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;
    SubscriptionService subscriptionService;
    ProjectTemplateService projectTemplateService;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        if(!subscriptionService.canCreateNewProject()){
            throw new BadRequestException("User cannot create a New project with current Plan, Upgrade plan now.");
        }

        Long userId = authUtil.getCurrentUserId();
//        User owner = userRepository.findById(userId).orElseThrow(
//                ()-> new ResourceNotFoundException("User", userId.toString()));
        User owner = userRepository.getReferenceById(userId);
        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project=projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(projectMember);

        projectTemplateService.initializeProjectFromTemplate(project.getId());

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<projectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getuserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
    Project project = getAccessibleProjectById(projectId,userId);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    //INTERNAL FUNCTION
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId)
                .orElseThrow(()-> new ResourceNotFoundException("project",projectId.toString()));
    }
}
