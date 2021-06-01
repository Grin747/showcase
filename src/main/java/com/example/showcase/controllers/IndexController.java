package com.example.showcase.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    private static final Map<String, Integer> store = new HashMap<>();
    private static final Map<String, Integer> cart = new HashMap<>();

    @GetMapping
    public String index(Model model){

        model.addAttribute("store", store.entrySet());
        model.addAttribute("cart", cart.entrySet());
        return "index";
    }

    @PostMapping
    public String addToCart(@ModelAttribute("product") String name, @ModelAttribute("count") int count) {

        store.put(name, store.get(name) - count);

        if (cart.containsKey(name)) cart.put(name, cart.get(name) + count);
        else cart.put(name, count);

        return "redirect:/";
    }

    @PostMapping("/add")
    public String addToStore(@ModelAttribute("product") String name, @ModelAttribute("count") int count) {

        if (store.containsKey(name)) store.put(name, store.get(name) + count);
        else store.put(name, count);

        return "redirect:/";
    }

    @PostMapping("/buy")
    public String buy() {

        cart.clear();
        return "redirect:/";
    }
}
