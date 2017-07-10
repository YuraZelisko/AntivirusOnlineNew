package com.antivirus.serviceImpl;

import com.antivirus.dao.OrdersDao;
import com.antivirus.dao.UserDao;
import com.antivirus.entity.Orders;
import com.antivirus.entity.Role;
import com.antivirus.entity.User;
import com.antivirus.service.UserService;
import com.antivirus.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    @Qualifier("userValidator")
    private Validator validator;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public void save(User user) throws Exception {

        System.out.println("validator = " + validator);

        validator.validate(user);
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }



    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    public void delete(int id) {


        User user = userDao.findUserWithOrders(id);
        for (Orders o : user.getOrders()){
            o.setUser(null);
            ordersDao.saveAndFlush(o);
        }

        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userDao.findByName(s);
    }

    @Override
    public User findByUuid(String uuid) {
        return userDao.findByUuid(uuid);
    }

    @Override
    public Page<User> findAllPages(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public User findUserWithOrders(int id) {
        return userDao.findUserWithOrders(id);
    }

    @Override
    public User findUserWithProducts(int id) {
        return userDao.findUserWithProducts(id);
    }

    @Override
    public void update(User user, String newPassword) {

        if (newPassword.isEmpty()){
            user.setPassword(newPassword);
        }
        else{
            user.setPassword(encoder.encode(user.getPassword()));
        }
    }
}
