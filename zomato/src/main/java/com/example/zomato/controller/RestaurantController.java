package com.example.zomato.controller;


import com.example.zomato.dto.RestaurantDto;
import com.example.zomato.entity.Restaurant;
import com.example.zomato.repo.RestaurantRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//basic crud like adding a new restrau etc
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantRepo restaurantRepo;

    @PostMapping("/add")
    public String addRestaurant(@RequestBody RestaurantDto res){
        Restaurant duplicate=restaurantRepo.findByName(res.getName());
        if(duplicate!=null){
            return "Duplicate entry found";
        }
        Restaurant r=new Restaurant();
        r.setName(res.getName());
        restaurantRepo.save(r);
        return r.getName()+ " saved successfully";
    }
    @GetMapping("/getAll")
    public List<Restaurant> getAllRestaurant(){
        return restaurantRepo.findAll();
    }
    @PutMapping("/update/{restaurantId}")
    public ResponseEntity<String> updateRestaurant(@RequestBody RestaurantDto restaurant,@PathVariable int restaurantId) {
        Restaurant r=restaurantRepo.findById(restaurantId).orElse(null);
        if(r==null)return ResponseEntity.status(404).body("No such restaurant found to be updated.");
        String oldName=r.getName();
        r.setName(restaurant.getName());
        restaurantRepo.save(r);
        return ResponseEntity.ok(oldName+ " updated successfully!");
    }

}
