package com.example.zomato.repo;

import com.example.zomato.entity.Customer;
import com.example.zomato.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Integer> {
        public List<OrderHistory> findByCustomerCustomerId(int customerId);
}
