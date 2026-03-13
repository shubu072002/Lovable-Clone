package com.springprojects.lovable_clone.Service.impl;

import com.springprojects.lovable_clone.Service.UsageService;
import com.springprojects.lovable_clone.dto.usage.PlanLimitsResponse;
import com.springprojects.lovable_clone.dto.usage.UsageTodayResponse;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsage(Long userId) {
        return null;
    }

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimits(Long userId) {
        return null;
    }
}
