package com.springprojects.lovable_clone.Service;

import com.springprojects.lovable_clone.dto.file.FileContentResponse;
import com.springprojects.lovable_clone.dto.file.FileNode;
import com.springprojects.lovable_clone.dto.project.FileTreeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectFileService {
    FileTreeResponse getFileTree(Long projectId);

    FileContentResponse getFileContent(Long projectId, String path);

    void saveFile(Long projectId, String filePath, String fileContent);

}
