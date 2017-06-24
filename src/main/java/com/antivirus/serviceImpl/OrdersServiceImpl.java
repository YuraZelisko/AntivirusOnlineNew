package com.antivirus.serviceImpl;

import com.antivirus.dao.OrdersDao;
import com.antivirus.entity.Orders;
import com.antivirus.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public void save(Orders orders) {
        ordersDao.save(orders);
    }

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    @Override
    public Orders findOne(int id) {
        return ordersDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        ordersDao.delete(id);
    }

    @Override
    public void update(Orders orders) {
        ordersDao.save(orders);
    }
}
