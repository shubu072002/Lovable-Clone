package com.springprojects.lovable_clone.Service;

import com.springprojects.lovable_clone.dto.auth.AuthResponse;
import com.springprojects.lovable_clone.dto.auth.LoginRequest;
import com.springprojects.lovable_clone.dto.auth.SignupRequest;
import com.springprojects.lovable_clone.dto.auth.UserProfileResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {


     AuthResponse login(LoginRequest loginRequest);

      AuthResponse signup(SignupRequest request);
}
