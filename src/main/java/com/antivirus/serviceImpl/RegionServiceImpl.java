package com.antivirus.serviceImpl;

import com.antivirus.dao.RegionDao;
import com.antivirus.entity.Region;
import com.antivirus.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class RegionServiceImpl implements RegionService{
    @Autowired
    private RegionDao regionDao;

    @Override

    public void save(Region region, MultipartFile image){

        regionDao.saveAndFlush(region);

        String path = System.getProperty("catalina.home") + "/resources/"
                + region.getName() + "/" + image.getOriginalFilename();

        region.setPathImage("resources/" + region.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        regionDao.save(region);
    }

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public Region findOne(int id) {
        return regionDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        regionDao.delete(id);
    }

    @Override
    public void update(Region region) {
        regionDao.save(region);
    }
}
