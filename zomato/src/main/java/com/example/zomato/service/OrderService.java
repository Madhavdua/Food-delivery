package com.example.zomato.service;

import com.example.zomato.dto.Cart;
import com.example.zomato.entity.Customer;
import com.example.zomato.entity.OrderHistory;
import com.example.zomato.repo.CustomerRepo;
import com.example.zomato.repo.OrderHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderHistoryRepo orderHistoryRepo;
    @Autowired
    CustomerRepo customerRepo;

    public String placeOrder(int customerId) {
        OrderHistory oh = new OrderHistory();
// customer id =1 untill it become to fetch from saved memory
        Customer c = customerRepo.findById(customerId).orElse(null);
        if (c == null) return null;
        oh.setCustomer(c);
        Cart ct = Cart.getInstance();
        //cartId is the orderId
        oh.setFoodList(ct.getFoodList());
        int size=ct.getFoodList().size();
        orderHistoryRepo.save(oh);
        int totalBill = ct.getToPay();
        ct.clearCart();
        return "Your order containing "+size+" items has been placed. Bill Amount: " + totalBill;
    }


}
