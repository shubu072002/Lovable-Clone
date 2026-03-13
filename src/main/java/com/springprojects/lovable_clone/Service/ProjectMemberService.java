package com.springprojects.lovable_clone.Service;

import com.springprojects.lovable_clone.dto.member.InviteMemberRequest;
import com.springprojects.lovable_clone.dto.member.MemberResponse;
import com.springprojects.lovable_clone.dto.member.UpdateMemberRoleRequest;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request);

    void removeProjectMember(Long projectId, Long memberId);
}
