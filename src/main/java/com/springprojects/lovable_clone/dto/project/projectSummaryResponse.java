package com.springprojects.lovable_clone.dto.project;

import java.time.Instant;

public record projectSummaryResponse(
        Long id,
        String name,
        Instant createdAt,
        Instant updatedAt
) {
}
