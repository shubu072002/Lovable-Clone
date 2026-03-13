package com.springprojects.lovable_clone.Controller;

import com.springprojects.lovable_clone.Service.ProjectService;
import com.springprojects.lovable_clone.dto.project.ProjectRequest;
import com.springprojects.lovable_clone.dto.project.ProjectResponse;
import com.springprojects.lovable_clone.dto.project.projectSummaryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<projectSummaryResponse>> getMyProjects(){
        return ResponseEntity.ok(projectService.getUserProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse>  getProjectById(@PathVariable Long id){
        return ResponseEntity.ok(projectService.getuserProjectById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody @Valid ProjectRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id,
                                                         @RequestBody @Valid ProjectRequest request){
        return ResponseEntity.ok(projectService.updateProject(id, request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        projectService.softDelete(id);
        return ResponseEntity.noContent().build();
    }



}
