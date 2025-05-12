package com.example.zomato.service;

import com.example.zomato.dto.CustomerDto;
import com.example.zomato.entity.Customer;
import com.example.zomato.entity.OrderHistory;
import com.example.zomato.repo.CustomerRepo;
import com.example.zomato.repo.OrderHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    OrderHistoryRepo orderHistoryRepo;
    @Autowired
    CustomerRepo customerRepo;

    public List<OrderHistory> giveOrderHistoryList(int custId){
        return orderHistoryRepo.findByCustomerCustomerId(custId);
    }
    public Customer loginCustomer(CustomerDto cred){
        Optional<Customer> c= customerRepo.findByCustomerNameIgnoreCase(cred.getCustomerName());
        Customer customer=null;
        if(c.isPresent()){
           customer=c.get();
            return Objects.equals(customer.getCustomerPassword(), cred.getCustomerPassword())?customer:null;
        }
        customer=new Customer();
        customer.setCustomerName(cred.getCustomerName());
        customer.setCustomerPassword(cred.getCustomerPassword());
        customerRepo.save(customer);
        return customer;
    }
}
