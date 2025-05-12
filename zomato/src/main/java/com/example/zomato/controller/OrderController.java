package com.example.zomato.controller;
// crud for cart and order

import com.example.zomato.dto.Cart;
import com.example.zomato.entity.Food;
import com.example.zomato.service.CartService;
import com.example.zomato.service.FoodService;
import com.example.zomato.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController{
    @Autowired
    CartService cartService;
    @Autowired
    FoodService foodService;
    @Autowired
    OrderService orderService;

    @PostMapping("/addItem/{foodId}")
    public String addItemToCart(@PathVariable int foodId) {
        Food f = foodService.getFoodById(foodId);
        if (f == null) return "Food not found";
        else if(!f.isActive())return "Food is currently not available to be added.";
        return cartService.addFoodItem(f);
    }

    @GetMapping("/showCart")
    public Cart showCart() {
        return Cart.getInstance();
    }

    @DeleteMapping("/removeItem/{foodId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable int foodId) {
        Food f = foodService.getFoodById(foodId);
        if (f == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food not found");
        }
        String result = cartService.removeFoodItem(f);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeOrder(HttpSession session){
        int customerId=(Integer) session.getAttribute("customerId");

        if(Cart.getInstance().getFoodList().isEmpty()){
            return ResponseEntity.status(400).body("Cart is empty");
        }
        String res= orderService.placeOrder(customerId);
        if(res==null)return ResponseEntity.status(403).body("Can't fetch user");
        return ResponseEntity.ok(res);
    }

}
