package com.antivirus.dao;

import com.antivirus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByName(String name);
    User findByEmail(String email);

//    @Query("select u from User u left join fetch u.products where u.id=:id")
//    User findUserWithProducts(@Param("id") int id);
//
//    @Query("select u from User u left join fetch u.orders o left join fetch o.products where u.id=:id")
//    User findUserWithOrders(@Param("id") int id);
    @Query("select  u from  User u left  join  fetch  u.products where u.id=:id")
    User findUserWithProducts(@Param("id") int id);
    @Query ("select u from  User u where u.uuid=:uuid")
    User findByUuid(@Param("uuid") String uuid);
}
