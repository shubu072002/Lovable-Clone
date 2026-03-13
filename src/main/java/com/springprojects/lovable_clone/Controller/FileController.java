package com.springprojects.lovable_clone.Controller;

import com.springprojects.lovable_clone.Service.ProjectFileService;
import com.springprojects.lovable_clone.dto.file.FileContentResponse;
import com.springprojects.lovable_clone.dto.file.FileNode;
import com.springprojects.lovable_clone.dto.project.FileTreeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/files")
public class FileController {

    private final ProjectFileService fileService;

    @GetMapping
    public ResponseEntity<FileTreeResponse> getFileTree(@PathVariable Long projectId){
        Long userId=1L;
        return  ResponseEntity.ok(fileService.getFileTree(projectId));
    }

    @GetMapping("/*path")
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId,
                                                       @PathVariable String path){
    Long userId=1L;
    return ResponseEntity.ok(fileService.getFileContent(projectId, path));
    }

}
