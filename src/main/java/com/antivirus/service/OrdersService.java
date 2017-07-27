package com.antivirus.service;

import com.antivirus.entity.Orders;

import java.security.Principal;
import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface OrdersService {

    void save(Orders orders);
    List<Orders> findAll();
    Orders findOne(int id);
    void delete(int id);
    void update(Orders orders);
    void addToBasket(Principal principal, int id);
    void deleteFromBasket(int userId, int productId);
    void buy(int userId);
    public void getTotalPrice(int id);
    List<Orders> ordersWithProducts();
}
