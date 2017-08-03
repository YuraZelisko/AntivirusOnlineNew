package com.antivirus.service;

import com.antivirus.entity.ModulesIncluded;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by User on 5/25/2017.
 */
public interface ModulesIncludedService {

    void save(ModulesIncluded modulesIncluded) throws Exception;
    List<ModulesIncluded> findAll();
    ModulesIncluded findOne(int id);
    void delete(int id);
    void update(ModulesIncluded modulesIncluded) throws Exception;

    Page<ModulesIncluded> findAllPages(Pageable pageable);
}
