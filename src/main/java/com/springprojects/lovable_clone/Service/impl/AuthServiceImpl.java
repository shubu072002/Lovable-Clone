package com.springprojects.lovable_clone.Service.impl;

import com.springprojects.lovable_clone.Entity.User;
import com.springprojects.lovable_clone.Service.AuthService;
import com.springprojects.lovable_clone.dto.auth.AuthResponse;
import com.springprojects.lovable_clone.dto.auth.LoginRequest;
import com.springprojects.lovable_clone.dto.auth.SignupRequest;
import com.springprojects.lovable_clone.dto.auth.UserProfileResponse;
import com.springprojects.lovable_clone.error.BadRequestException;
import com.springprojects.lovable_clone.mapper.UserMapper;
import com.springprojects.lovable_clone.repositories.UserRepository;
import com.springprojects.lovable_clone.security.AuthUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        User user=(User) authentication.getPrincipal();

        String token = authUtil.generateAccessToken(user);

        return new AuthResponse(token, userMapper.toUserProfileResponseFromUser(user));

    }

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username())
                .ifPresent(user ->{
                    throw new BadRequestException("User already exists with username: "+ request.username());
                });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user= userRepository.save(user);

        String token = authUtil.generateAccessToken(user);
        return new AuthResponse(token, userMapper.toUserProfileResponseFromUser(user));
    }
}
