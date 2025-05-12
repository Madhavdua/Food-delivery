package com.example.zomato.controller;
// crud for customer data like name password or list of order etc

import com.example.zomato.dto.CustomerDto;
import com.example.zomato.entity.Customer;
import com.example.zomato.entity.OrderHistory;
import com.example.zomato.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController{
    @Autowired
    CustomerService customerService;

    @GetMapping("/allOrders")
    public List<OrderHistory> getAllOrders(HttpSession session){
        int customerId=(Integer)session.getAttribute("customerId");
        return customerService.giveOrderHistoryList(customerId);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginCustomer(@RequestBody CustomerDto creds, HttpSession session){
        Customer customer=customerService.loginCustomer(creds);
        if(customer==null)return ResponseEntity.status(403).body("Invalid Password");
        session.setAttribute("customerId",customer.getCustomerId());
        return ResponseEntity.ok("Welcome " + customer.getCustomerName());
    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResponseEntity.ok("Logged out");
    }
}
