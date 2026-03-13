package com.springprojects.lovable_clone.dto.file;


public record FileNode(
        String path
) {
    @Override
    public String toString() {
        return path;
    }
}
