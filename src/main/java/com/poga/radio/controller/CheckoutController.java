package com.poga.radio.controller;

import com.alibaba.fastjson.JSONObject;
import com.poga.radio.domain.Checkout;
import com.poga.radio.service.impl.CheckoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Controller
public class CheckoutController {

    @Autowired
    CheckoutServiceImpl checkoutService ;

    @ResponseBody
    @RequestMapping(value = "/cart/add", method = RequestMethod.POST)
    public Object addCheckout(HttpServletRequest req) {
        JSONObject checkoutJson = new JSONObject();
        String song_id = req.getParameter("songId").trim();
        String singer_id = req.getParameter("singerId").trim();
        String user_id = req.getParameter("userId").trim();
        String song_price = req.getParameter("songPrice").trim();
        String song_name = req.getParameter("songName").trim();
        String song_pic = req.getParameter("songPic").trim();
        String introduction = req.getParameter("introduction").trim();
        String song_url = req.getParameter("songUrl").trim();

        Checkout checkout = new Checkout();
        checkout.setSongId(Integer.parseInt(song_id));
        checkout.setSingerId(Integer.parseInt(singer_id));
        checkout.setUserId(Integer.parseInt(user_id));
        checkout.setSongPrice(Integer.parseInt(song_price));
        checkout.setSongName(song_name);
        checkout.setSongPic(song_pic);
        checkout.setIntroduction(introduction);
        checkout.setSongUrl(song_url);

        boolean res = checkoutService.addCheckout(checkout);

        if (res) {
            checkoutJson.put("code", 1);
            checkoutJson.put("msg", "success");

        } else {
            checkoutJson.put("code", 0);
            checkoutJson.put("msg", "failed");
        }
        return checkoutJson;
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public Object getAllCheckout()
    {
        return checkoutService.getAllCheckout() ;
    }
}
