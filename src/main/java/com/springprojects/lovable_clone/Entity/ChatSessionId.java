package com.springprojects.lovable_clone.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Embeddable
public class ChatSessionId implements Serializable {
    Long projectId;
    Long userId;
}
