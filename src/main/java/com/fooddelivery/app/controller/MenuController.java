package com.fooddelivery.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    @GetMapping("/api/menu")
    public List<Map<String, Object>> menu() {

        return List.of(

            Map.of(
                "id", 1,
                "name", "Margherita Pizza",
                "price", 299
            ),

            Map.of(
                "id", 2,
                "name", "Veg Burger",
                "price", 199
            ),

            Map.of(
                "id", 3,
                "name", "Chicken Biryani",
                "price", 349
            )
        );
    }
}
