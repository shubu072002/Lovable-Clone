package com.springprojects.lovable_clone.Service.impl;

import com.springprojects.lovable_clone.Service.UserService;
import com.springprojects.lovable_clone.dto.auth.UserProfileResponse;
import com.springprojects.lovable_clone.error.ResourceNotFoundException;
import com.springprojects.lovable_clone.repositories.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    UserRepository userRepository;


    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("username :",username));
    }
}
