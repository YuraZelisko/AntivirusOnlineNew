package com.antivirus.service;

import com.antivirus.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface UserService {

    void save(User user) throws Exception;
    List<User> findAll();
    User findOne(int id);
    void delete(int id);

    void update(User user);

    User findByUuid(String uuid);

    Page<User> findAllPages(Pageable pageable);

    User findUserWithOrders(int id);

    User findUserWithProducts(int id);

    void update(User user, String newPassword);
}
