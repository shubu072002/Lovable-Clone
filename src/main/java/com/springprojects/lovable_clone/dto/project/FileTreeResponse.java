package com.springprojects.lovable_clone.dto.project;

import com.springprojects.lovable_clone.dto.file.FileNode;

import java.util.List;

public record FileTreeResponse(
        List<FileNode> files
) {
}