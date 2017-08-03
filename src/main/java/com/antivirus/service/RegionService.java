package com.antivirus.service;

import com.antivirus.dto.RegionDTO;
import com.antivirus.entity.DeliveryType;
import com.antivirus.entity.Region;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface RegionService {

    void save(Region region, MultipartFile image) throws Exception;
    List<Region> findAll();
    Region findOne(int id);
    void delete(int id);
    void update(Region region) ;
    void update(Region region, MultipartFile image) ;
    List<Region> regionWithDeliveries();
}
