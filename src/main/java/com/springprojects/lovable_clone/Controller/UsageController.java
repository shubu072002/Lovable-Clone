package com.springprojects.lovable_clone.Controller;

import com.springprojects.lovable_clone.Service.UsageService;
import com.springprojects.lovable_clone.dto.usage.PlanLimitsResponse;
import com.springprojects.lovable_clone.dto.usage.UsageTodayResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
public class UsageController {

    private final UsageService usageService;

    @GetMapping("/today")
    public ResponseEntity<UsageTodayResponse> getTodayUsage(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }

    @GetMapping("/limits")
    public ResponseEntity<PlanLimitsResponse>  getPlanLimits(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimits(userId));
    }
}
