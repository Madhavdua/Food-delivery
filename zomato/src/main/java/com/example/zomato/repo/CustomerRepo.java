package com.example.zomato.repo;

import com.example.zomato.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByCustomerNameAndCustomerPassword(String name, String password);
    Optional<Customer> findByCustomerNameIgnoreCase(String customerName);

}
