package com.antivirus.serviceImpl;

import com.antivirus.dao.SystemRequirementsDao;
import com.antivirus.entity.SystemRequirements;
import com.antivirus.service.SystemRequirementService;
import com.antivirus.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
@Service
public class SystemReqirementServiceImpl implements SystemRequirementService{

    @Autowired
    private SystemRequirementsDao systemRequirementsDao;

    @Autowired
    @Qualifier("systemRequirementsValidator")
    private Validator validator;


    @Override
    public void save(SystemRequirements systemRequirements) throws Exception {

        validator.validate(systemRequirements);
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
    public void update(SystemRequirements systemRequirements) throws Exception {
        validator.validateUpd(systemRequirements);
        systemRequirementsDao.save(systemRequirements);
    }

    @Override
    public SystemRequirements systemRequirementsWithProducts(int id) {
        return systemRequirementsDao.systemRequirementsWithProducts(id);
    }
}
