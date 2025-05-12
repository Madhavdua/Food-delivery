package com.example.zomato.controller;

import com.example.zomato.entity.Category;
import com.example.zomato.entity.Food;
import com.example.zomato.repo.FoodRepo;
import com.example.zomato.service.CartService;
import com.example.zomato.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//for food crud
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodRepo foodRepo;

    @Autowired
    CartService cs;
    @Autowired
    FoodService foodService;


    @GetMapping("/categories")
    public List<String> getCategories() {
        // Convert enum values to list of strings
        return Arrays.stream(Category.values())
                .map(Enum::name)  // Get the string representation of the enum
                .collect(Collectors.toList());  // Collect to a list
    }

    @GetMapping("/getAll")
    public List<Food> getFood(
            @RequestParam(value = "category", required = false) String categoryName,
            @RequestParam(value = "restaurantId", required = false) Integer restaurantId
    ) {
        return foodService.getAll(categoryName, restaurantId);
    }

    @PutMapping("/notAvailable")
    public String notAvailableNow(@RequestBody int foodId) {
        return foodService.makeNotAvailable(foodId);
    }

    @PutMapping("/nowAvailable")
    public String isAvailableNow(@RequestBody int foodId) {
        return foodService.makeAvailable(foodId);
    }

}
