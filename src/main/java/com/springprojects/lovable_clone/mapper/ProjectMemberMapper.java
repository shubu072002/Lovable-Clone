package com.springprojects.lovable_clone.mapper;

import com.springprojects.lovable_clone.Entity.ProjectMember;
import com.springprojects.lovable_clone.Entity.User;
import com.springprojects.lovable_clone.dto.member.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "name", source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);

}
