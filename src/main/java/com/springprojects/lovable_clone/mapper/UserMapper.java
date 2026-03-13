package com.springprojects.lovable_clone.mapper;

import com.springprojects.lovable_clone.Entity.User;
import com.springprojects.lovable_clone.dto.auth.AuthResponse;
import com.springprojects.lovable_clone.dto.auth.SignupRequest;
import com.springprojects.lovable_clone.dto.auth.UserProfileResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

     User toEntity(SignupRequest signupRequest);

     UserProfileResponse toUserProfileResponseFromUser(User user);
}
