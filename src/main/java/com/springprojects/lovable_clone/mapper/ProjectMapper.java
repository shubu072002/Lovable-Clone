package com.springprojects.lovable_clone.mapper;

import com.springprojects.lovable_clone.Entity.Project;
import com.springprojects.lovable_clone.dto.project.ProjectResponse;
import com.springprojects.lovable_clone.dto.project.projectSummaryResponse;
import jakarta.persistence.Table;
import org.mapstruct.Mapper;

import javax.xml.transform.Source;
import java.lang.annotation.Target;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    List<projectSummaryResponse> toListOfProjectSummaryResponse(List<Project> projects);
}
