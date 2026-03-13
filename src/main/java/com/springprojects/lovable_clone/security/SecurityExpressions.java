package com.springprojects.lovable_clone.security;

import com.springprojects.lovable_clone.Entity.User;
import com.springprojects.lovable_clone.enums.ProjectPermission;
import com.springprojects.lovable_clone.enums.ProjectRole;
import com.springprojects.lovable_clone.repositories.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.RecursiveTask;

import static com.springprojects.lovable_clone.enums.ProjectRole.*;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final AuthUtil authUtil;
    private final ProjectMemberRepository projectMemberRepository;

    private boolean hasPermissions(Long projectId, ProjectPermission projectPermission){
        Long userId = authUtil.getCurrentUserId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId, userId)
                .map(role-> role.getPermissions().contains(projectPermission))
                .orElse(false);
    }


    public boolean canViewProject(Long projectId){
       return hasPermissions(projectId,ProjectPermission.VIEW);
    }


    public boolean canEditProject(Long projectId){
        return hasPermissions(projectId, ProjectPermission.EDIT);
    }

    public boolean canDeleteProject(Long projectId){
        return hasPermissions(projectId, ProjectPermission.DELETE);
    }

    public boolean canViewMembers(Long projectId){
        return hasPermissions(projectId, ProjectPermission.VIEW_MEMBERS);
    }

    public boolean canManageMembers(Long projectId){
        return hasPermissions(projectId, ProjectPermission.MANAGE_MEMBERS);
    }

}
