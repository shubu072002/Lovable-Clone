package com.springprojects.lovable_clone.mapper;

import com.springprojects.lovable_clone.Entity.Plan;
import com.springprojects.lovable_clone.Entity.Subscription;
import com.springprojects.lovable_clone.dto.subscription.PlanResponse;
import com.springprojects.lovable_clone.dto.subscription.SubscriptionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse toSubscriptionResponse(Subscription subscription);

    PlanResponse toPlanResponse(Plan plan);
}
