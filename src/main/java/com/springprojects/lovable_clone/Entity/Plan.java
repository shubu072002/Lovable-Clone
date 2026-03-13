package com.springprojects.lovable_clone.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(unique = true)
    String stripePriceId;

    Integer maxProjects;
    Integer MaxTokensPerDay;
    Integer MaxPreviews;// max number of previews allowed per plan
    Boolean unlimitedAi;//Unlimited access to llm , ignore maxTokensPerDay if true

    Boolean active;


}
