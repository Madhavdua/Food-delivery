package com.example.zomato.repo;

import com.example.zomato.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
    public Restaurant findByName(String name);
}
