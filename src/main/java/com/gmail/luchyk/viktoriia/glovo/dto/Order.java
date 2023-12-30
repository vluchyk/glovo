package com.gmail.luchyk.viktoriia.glovo.dto;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private int id;
    private List<Product> products;
    private Customer customer;
    private Address address;
}
