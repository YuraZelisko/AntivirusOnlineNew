package com.antivirus.dao;

import com.antivirus.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by User on 5/25/2017.
 */
public interface OrdersDao extends JpaRepository<Orders, Integer> {

    @Query("select distinct o from Orders  o left join fetch o.products where o.id=:id")
    Orders ordersWithProducts(@Param("id") int id);
}
