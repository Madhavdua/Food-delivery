package com.example.zomato.service;

import com.example.zomato.entity.Category;
import com.example.zomato.entity.Food;
import com.example.zomato.repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.hibernate.event.spi.EventType.values;

@Service
public class FoodService {
    @Autowired
    FoodRepo foodRepo;

    public Category getCorrectCategory(String category) {
        if (category == null) return null;
        for (Category c : Category.values()) {
            if (c.name().equalsIgnoreCase(category) ||
                    c.name().toLowerCase().contains(category.toLowerCase())) {
                return c;
            }
        }
        return null;
    }

    public List<Food> getAll(String categoryStr, Integer restaurantId) {
        Category category = getCorrectCategory(categoryStr);
        if (category != null && restaurantId != null) {
            return foodRepo.findByCategoryAndRestaurantId(category, restaurantId);
        } else if (category != null) {
            return foodRepo.findByCategory(category);
        } else if (restaurantId != null) {
            return foodRepo.findByRestaurantId(restaurantId);
        } else {
            return foodRepo.findAll();
        }
    }

    public Food getFoodById(int id) {
        return foodRepo.findById(id).orElse(null);
    }

    public String makeNotAvailable(int id) {
        Food f = foodRepo.findById(id).orElse(null);
        if (f == null) return "Food not found";
        f.setActive(false);
        return f.getName() + " is now unavailable";
    }

    public String makeAvailable(int id) {
        Food f = foodRepo.findById(id).orElse(null);
        if (f == null) return "Food not found";
        f.setActive(true);
        return f.getName() + " is now available";
    }
}
