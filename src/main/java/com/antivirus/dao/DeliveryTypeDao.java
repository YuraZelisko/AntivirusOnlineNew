package com.antivirus.dao;

import com.antivirus.entity.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface DeliveryTypeDao extends JpaRepository<DeliveryType, Integer> {

    @Query("select d from DeliveryType d left join fetch d.region")
    List<DeliveryType> deliveryWithRegion();
}
