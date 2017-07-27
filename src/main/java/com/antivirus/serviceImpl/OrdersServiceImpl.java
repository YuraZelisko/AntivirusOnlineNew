package com.antivirus.serviceImpl;

import com.antivirus.dao.OrdersDao;
import com.antivirus.dao.ProductDao;
import com.antivirus.dao.UserDao;
import com.antivirus.entity.Orders;
import com.antivirus.entity.Product;
import com.antivirus.entity.User;
import com.antivirus.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

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


    @Override
    public void addToBasket(Principal principal, int id) {
        User user = userDao.findUserWithProducts(Integer.parseInt(principal.getName()));
        Product product= productDao.getOne(id);
        user.getProducts().add(product);
        userDao.save(user);

    }

    @Override
    public void deleteFromBasket(int userId, int productId) {
        User user = userDao.findUserWithProducts(userId);
        Product product = productDao.productWithUsers(productId);
        user.getProducts().remove(product);
        userDao.save(user);
    }

    @Override
    public void buy(int userId) {
        Orders orders= new Orders(LocalDateTime.now());
        ordersDao.saveAndFlush(orders);
        User user = userDao.findUserWithProducts(userId);
        orders.setUser(user);
        for (Product product: user.getProducts())
        {
            orders.getProducts().add(product);
            ordersDao.save(orders);
        }

        user.getProducts().clear();
        userDao.save(user);

    }

    @Override
    public void getTotalPrice(int id) {
       Orders orders = ordersDao.findOne(id);
        int price = 0 ;
        for (Product product: orders.getProducts())
        {
            price += product.getPrice() * product.getProductQuantity();
            orders.setTotalPrice(price);
        }
    }

    @Override
    public List<Orders> ordersWithProducts() {
        return ordersDao.ordersWithProducts();
    }
}
