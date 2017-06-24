package com.antivirus.dao;

import com.antivirus.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 6/19/2017.
 */
public interface CityDao extends JpaRepository<City, Integer> {
}