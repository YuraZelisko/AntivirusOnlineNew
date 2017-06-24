package com.antivirus.serviceImpl;

import com.antivirus.dao.ModulesIncludedDao;
import com.antivirus.entity.ModulesIncluded;
import com.antivirus.service.ModulesIncludedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class ModulesIncludedServiceImpl implements ModulesIncludedService{

    @Autowired
    private ModulesIncludedDao modulesIncludedDao;

    @Override
    public void save(ModulesIncluded modulesIncluded) {
        modulesIncludedDao.save(modulesIncluded);
    }

    @Override
    public List<ModulesIncluded> findAll() {
        return modulesIncludedDao.findAll();
    }

    @Override
    public ModulesIncluded findOne(int id) {
        return modulesIncludedDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        modulesIncludedDao.delete(id);
    }

    @Override
    public void update(ModulesIncluded modulesIncluded) {
        modulesIncludedDao.save(modulesIncluded);
    }

    @Override
    public Page<ModulesIncluded> findAllPages(Pageable pageable) {
        return modulesIncludedDao.findAll(pageable);
    }
}
