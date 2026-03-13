package com.springprojects.lovable_clone.Controller;

import com.springprojects.lovable_clone.Service.AuthService;
import com.springprojects.lovable_clone.Service.UsageService;
import com.springprojects.lovable_clone.dto.auth.AuthResponse;
import com.springprojects.lovable_clone.dto.auth.LoginRequest;
import com.springprojects.lovable_clone.dto.auth.SignupRequest;
import com.springprojects.lovable_clone.dto.auth.UserProfileResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

     AuthService authService;
     UsageService usageService;

     @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request){
        return ResponseEntity.ok(authService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
         return ResponseEntity.ok(authService.login(loginRequest));
    }

}
