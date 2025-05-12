package com.example.zomato.dto;

import com.example.zomato.entity.Food;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    static Cart cartInstance;
    static {
        cartInstance=null;
    }
    private List<Food> foodList;
    int total,discount,toPay;
    Coupon c;
    public static Cart getInstance(){
        if(cartInstance==null){
            cartInstance=new Cart();
        }
        return cartInstance;
    }

    private Cart() {
        this.foodList=new ArrayList<>();
        this.total=0;
        this.discount=0;
        this.toPay=0;
        c=new Coupon();
    }

    public int getTotal() {
        return total;
    }


    public void setTotal(int total) {
        this.total = total;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int amt) {
        this.discount = c.getDiscount(amt);
    }

    public int getToPay() {
        return toPay;
    }
    public void setToPay(){
        this.toPay=Math.max(0,total-discount);
    }

    public void clearCart(){
        this.foodList=new ArrayList<>();
    }
    public List<Food> getFoodList() {
        return foodList;
    }




}
