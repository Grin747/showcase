package com.example.showcase.services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {
    private static HashMap<String, Integer> cart;

    public CartService() {
        cart = new HashMap<>();
        cart.put("pokek", 2);
    }

    public Map<String, Integer> getCart() {
        return cart;
    }
}
