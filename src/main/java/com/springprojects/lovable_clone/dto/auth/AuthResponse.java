package com.springprojects.lovable_clone.dto.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
        ) {

}
