package com.antivirus.service;

import com.antivirus.entity.Orders;

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
}
