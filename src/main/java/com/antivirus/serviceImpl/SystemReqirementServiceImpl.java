package com.antivirus.serviceImpl;

import com.antivirus.dao.SystemRequirementsDao;
import com.antivirus.entity.SystemRequirements;
import com.antivirus.service.SystemRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class SystemReqirementServiceImpl implements SystemRequirementService{

    @Autowired
    private SystemRequirementsDao systemRequirementsDao;


    @Override
    public void save(SystemRequirements systemRequirements) {
        systemRequirementsDao.save(systemRequirements);
    }

    @Override
    public List<SystemRequirements> findAll() {
        return systemRequirementsDao.findAll();
    }

    @Override
    public SystemRequirements findOne(int id) {
        return systemRequirementsDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        systemRequirementsDao.delete(id);
    }

    @Override
    public void update(SystemRequirements systemRequirements) {
        systemRequirementsDao.save(systemRequirements);
    }

    @Override
    public SystemRequirements systemRequirementsWithProducts(int id) {
        return systemRequirementsDao.systemRequirementsWithProducts(id);
    }
}
