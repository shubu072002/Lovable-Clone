package com.springprojects.lovable_clone.Service.impl;

import com.springprojects.lovable_clone.dto.subscription.CheckoutRequest;
import com.springprojects.lovable_clone.dto.subscription.CheckoutResponse;
import com.springprojects.lovable_clone.dto.subscription.PortalResponse;
import com.stripe.model.StripeObject;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface PaymentProcessor {

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);

    PortalResponse openCustomerPortal();

    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);

}
