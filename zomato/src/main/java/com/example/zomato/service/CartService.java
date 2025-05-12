package com.example.zomato.service;

import com.example.zomato.dto.Cart;
import com.example.zomato.entity.Food;
import org.springframework.stereotype.Service;

@Service
public class CartService {


    public boolean containsFood(Food f){
        Cart c=Cart.getInstance();
        for(Food it:c.getFoodList()){
            if(it.getId()==f.getId())return true;
        }
        return false;
    }
    public String addFoodItem(Food f){
        Cart c=Cart.getInstance();
        if(containsFood(f))return "Duplicate food items not allowed";
        // add to foodList
        c.getFoodList().add(f);
        // add total
        int total=c.getTotal()+f.getPrice();
        c.setTotal(total);
        //calc discount
        c.setDiscount(total);
        //set final price to be paid
        c.setToPay();

        return f.getName()+ " saved to cart!";
    }
    public boolean removeFromList(Food f){
        Cart c=Cart.getInstance();
        for(int i=0; i<c.getFoodList().size(); i++){
            if(c.getFoodList().get(i).getId()==f.getId()){
                c.getFoodList().remove(i);
                return true;
            }
        }
        return false;
    }
    public String removeFoodItem(Food f){
        boolean removed=this.removeFromList(f);
        Cart c=Cart.getInstance();
        if(removed){
            //reduce total
            int amt=c.getTotal()-f.getPrice();
            c.setTotal(amt);
            //set discount
            c.setDiscount(amt);
            // set final to be paid
            c.setToPay();
            return f.getName()+" item removed to cart!";
        }
        return "No such item in the cart.";
    }

}
