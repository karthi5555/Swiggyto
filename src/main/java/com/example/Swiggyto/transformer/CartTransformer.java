package com.example.Swiggyto.transformer;

import com.example.Swiggyto.dto.responseDTO.CartResponse;
import com.example.Swiggyto.model.Cart;

import java.util.ArrayList;

public class CartTransformer {

    public static CartResponse CartToCartResponse(Cart cart){
        return CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();
    }
}