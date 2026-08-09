package com.fooddelivery.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RestaurantController {

    @GetMapping("/api/restaurants")
    public List<Map<String, Object>> restaurants() {

        return List.of(

            Map.of(
                "id", 1,
                "name", "Pizza Palace",
                "location", "Pune"
            ),

            Map.of(
                "id", 2,
                "name", "Burger House",
                "location", "Mumbai"
            ),

            Map.of(
                "id", 3,
                "name", "Biryani Hub",
                "location", "Pune"
            )
        );
    }
}
