package com.antivirus.dao;

import com.antivirus.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by User on 5/25/2017.
 */
public interface RegionDao extends JpaRepository<Region, Integer> {

    @Query ("select  r from Region  r left  join  fetch  r.deliveryTypes")
    Region regionWithDeliveries(@Param("id") int id);
}
