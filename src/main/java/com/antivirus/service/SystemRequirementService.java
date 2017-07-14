package com.antivirus.service;

import com.antivirus.entity.SystemRequirements;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface SystemRequirementService {

    void save(SystemRequirements systemRequirements);
    List<SystemRequirements> findAll();
    SystemRequirements findOne(int id);
    void delete(int id);
    void update(SystemRequirements systemRequirements);
    SystemRequirements systemRequirementsWithProducts(int id);
}
