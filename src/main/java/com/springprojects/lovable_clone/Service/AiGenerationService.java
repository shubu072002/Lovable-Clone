package com.springprojects.lovable_clone.Service;

import com.springprojects.lovable_clone.dto.chat.StreamResponse;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface AiGenerationService {
    Flux<StreamResponse> streamResponse(String UserMessage, Long projectId);
}
