package com.springprojects.lovable_clone.dto.usage;

public record UsageTodayResponse(
        Integer tokensUsed,
        Integer tokenLimit,
        Integer previewsRunning,
        Integer previewsLimit
) {
}
