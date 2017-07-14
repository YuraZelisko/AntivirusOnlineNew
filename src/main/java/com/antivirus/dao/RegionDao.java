package com.antivirus.dao;

import com.antivirus.entity.DeliveryType;
import com.antivirus.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface RegionDao extends JpaRepository<Region, Integer> {

    @Query ("select distinct r from Region  r left  join  fetch  r.deliveryTypes")
    List<Region> regionWithDeliveries();
}
