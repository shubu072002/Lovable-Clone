package com.springprojects.lovable_clone.Controller;

import com.springprojects.lovable_clone.Service.UserService;
import com.springprojects.lovable_clone.dto.auth.UserProfileResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {

    UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
