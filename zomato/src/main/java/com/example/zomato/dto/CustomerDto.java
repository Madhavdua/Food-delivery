package com.example.zomato.dto;

public class CustomerDto {
    private String customerName;
    private String customerPassword;

    public CustomerDto() {
    }


    public CustomerDto(String customerName, String customerPassword) {
        this.customerName = customerName;
        this.customerPassword = customerPassword;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
}
