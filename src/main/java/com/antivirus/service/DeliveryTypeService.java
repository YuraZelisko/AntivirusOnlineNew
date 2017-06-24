package com.antivirus.service;

import com.antivirus.entity.DeliveryType;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface DeliveryTypeService {

    void save(DeliveryType deliveryType);
    List<DeliveryType> findAll();
    DeliveryType findOne(int id);
    void delete(int id);
    void update(DeliveryType deliveryType);
}
