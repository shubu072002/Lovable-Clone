package com.springprojects.lovable_clone.Service;

import com.springprojects.lovable_clone.dto.usage.PlanLimitsResponse;
import com.springprojects.lovable_clone.dto.usage.UsageTodayResponse;
import org.jspecify.annotations.Nullable;

public interface UsageService {
     UsageTodayResponse getTodayUsage(Long userId);

     UsageTodayResponse getTodayUsageOfUser(Long userId);

     PlanLimitsResponse getCurrentSubscriptionLimits(Long userId);
}
