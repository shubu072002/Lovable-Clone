package com.springprojects.lovable_clone.Service;

import com.springprojects.lovable_clone.dto.project.ProjectRequest;
import com.springprojects.lovable_clone.dto.project.ProjectResponse;
import com.springprojects.lovable_clone.dto.project.projectSummaryResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    List<projectSummaryResponse> getUserProjects();

     ProjectResponse getuserProjectById(Long id);

     ProjectResponse createProject(ProjectRequest request);

     ProjectResponse updateProject(Long id, ProjectRequest request);

    void softDelete(Long id);

}
