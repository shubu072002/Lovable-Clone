package com.springprojects.lovable_clone.Service.impl;

import com.springprojects.lovable_clone.Service.PlanService;
import com.springprojects.lovable_clone.dto.subscription.PlanResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlan() {
        return List.of();
    }
}
