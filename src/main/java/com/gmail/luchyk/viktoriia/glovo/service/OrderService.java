package com.gmail.luchyk.viktoriia.glovo.service;

import com.gmail.luchyk.viktoriia.glovo.dto.Address;
import com.gmail.luchyk.viktoriia.glovo.dto.Customer;
import com.gmail.luchyk.viktoriia.glovo.dto.Order;
import com.gmail.luchyk.viktoriia.glovo.dto.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final Map<Integer, Order> orders = new HashMap<>();

    public Order get(int id) {
        return orders.get(id);
    }

    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public Order update(int id, Order order) {
        Order changed = orders.get(id);
        changed.setProducts(order.getProducts());
        changed.setCustomer(order.getCustomer());
        changed.setAddress(order.getAddress());
        return changed;
    }

    public Order update(int id, String productName, Product updated) {
        Order changed = orders.get(id);
        List<Product> products = changed.getProducts();
        for (Product product : products) {
            if (productName.equals(product.getName())) {
                product.setName(updated.getName());
                product.setCost(updated.getCost());
            }
        }
        return changed;
    }

    public Order updateCustomer(int id, Customer customer) {
        Order changed = orders.get(id);
        changed.setCustomer(customer);
        return changed;
    }

    public Order update(int id, Address address) {
        Order changed = orders.get(id);
        changed.setAddress(address);
        return changed;
    }

    public Order patch(int id, Product product) {
        Order changed = orders.get(id);
        changed.getProducts().add(product);
        return changed;
    }

    public Order delete(int id, String productName) {
        Order changed = orders.get(id);
        List<Product> products = changed.getProducts();
        for (Product product : products) {
            if (productName.equals(product.getName())) {
                products.remove(product);
                break;
            }
        }
        changed.setProducts(products);
        return changed;
    }

    public void delete(int id) {
        orders.remove(id);
    }
}