package com.springprojects.lovable_clone.dto.member;

import com.springprojects.lovable_clone.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(
        @NotNull
        ProjectRole role) {
}
