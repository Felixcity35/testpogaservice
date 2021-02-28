package com.poga.radio.service;

import com.poga.radio.domain.Checkout;

import java.util.List;


public interface CheckoutService {

    boolean deleteCheckout(Integer userId);
    boolean addCheckout(Checkout checkout);
    List<Checkout> getAllCheckout();
}
