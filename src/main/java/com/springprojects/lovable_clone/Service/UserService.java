package com.springprojects.lovable_clone.Service;

import com.springprojects.lovable_clone.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     UserProfileResponse getProfile(Long userId);
}
