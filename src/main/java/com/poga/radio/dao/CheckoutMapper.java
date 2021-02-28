package com.poga.radio.dao;

import com.poga.radio.domain.Checkout;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutMapper {

    int deleteCheckout(Integer id);
    int insert(Checkout checkout);
    List<Checkout> getAllCheckout();


}
