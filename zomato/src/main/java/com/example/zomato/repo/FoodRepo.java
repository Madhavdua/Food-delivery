package com.example.zomato.repo;

import com.example.zomato.entity.Category;
import com.example.zomato.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepo extends JpaRepository<Food,Integer> {
    List<Food> findByCategory(Category category);
    List<Food> findByRestaurantId(Integer restaurant);
    List<Food> findByCategoryAndRestaurantId(Category category,Integer restaurantId);

}
