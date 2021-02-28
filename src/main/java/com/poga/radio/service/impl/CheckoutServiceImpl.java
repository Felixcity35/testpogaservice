package com.poga.radio.service.impl;

import com.poga.radio.dao.CheckoutMapper;
import com.poga.radio.domain.Checkout;
import com.poga.radio.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    CheckoutMapper checkoutMapper ;

    @Override
    public boolean deleteCheckout(Integer userId) {
        return checkoutMapper.deleteCheckout(userId)>0;
    }

    @Override
    public boolean addCheckout(Checkout checkout) {
        return checkoutMapper.insert(checkout) > 0;
    }

    @Override
    public List<Checkout> getAllCheckout() {

        return checkoutMapper.getAllCheckout();
    }
}
