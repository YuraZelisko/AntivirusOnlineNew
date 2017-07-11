package com.antivirus.dao;

import com.antivirus.entity.ModulesIncluded;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by User on 5/25/2017.
 */
public interface ModulesIncludedDao extends JpaRepository<ModulesIncluded, Integer> {

    @Query("select m from ModulesIncluded m left join fetch m.products where m.id=:id")
    ModulesIncluded modulesIncludedWithProducts(@Param("id") int id);
}
