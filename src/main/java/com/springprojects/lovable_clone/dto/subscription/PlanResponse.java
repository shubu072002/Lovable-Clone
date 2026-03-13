package com.springprojects.lovable_clone.dto.subscription;

public record PlanResponse(
        Long id,
        String name,
        Integer maxProjects,
        Integer MaxTokensPerDay,
        Boolean unlimitedAi,
        String  price
) {
}
