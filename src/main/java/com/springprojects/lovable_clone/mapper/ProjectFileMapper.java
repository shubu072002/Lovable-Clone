package com.springprojects.lovable_clone.mapper;

import com.springprojects.lovable_clone.Entity.ProjectFile;
import com.springprojects.lovable_clone.dto.file.FileNode;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectFileMapper {

    List<FileNode> toListOfFileNode(List<ProjectFile> projectFileList);

}
