package com.antivirus.serviceImpl;

import com.antivirus.dao.DeliveryTypeDao;
import com.antivirus.entity.DeliveryType;
import com.antivirus.service.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class DeliveryTypeServiceImpl implements DeliveryTypeService {

    @Autowired
    private DeliveryTypeDao deliveryTypeDao;

    @Override
    public void save(DeliveryType deliveryType) {
        deliveryTypeDao.save(deliveryType);

    }

    @Override
    public List<DeliveryType> findAll() {
        return deliveryTypeDao.findAll();
    }

    @Override
    public DeliveryType findOne(int id) {
        return deliveryTypeDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        deliveryTypeDao.delete(id);

    }

    @Override
    public void update(DeliveryType deliveryType) {
        deliveryTypeDao.save(deliveryType);

    }
}
