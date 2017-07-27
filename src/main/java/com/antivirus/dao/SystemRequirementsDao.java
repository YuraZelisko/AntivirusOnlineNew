package com.antivirus.dao;

import com.antivirus.entity.SystemRequirements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by User on 5/25/2017.
 */
public interface SystemRequirementsDao extends JpaRepository<SystemRequirements, Integer> {

    @Query("select distinct s from SystemRequirements s left join fetch s.products where s.id=:id")
    SystemRequirements systemRequirementsWithProducts(@Param("id") int id);

    @Query("select s from SystemRequirements s where s.OSname=:OSname")
    SystemRequirements findByOSname(@Param("OSname") String OSname);

    @Query("select s from SystemRequirements s where s.OSlanguage=:OSlanguage")
    SystemRequirements findByOSlanguage(@Param("OSlanguage") String OSlanguage);
//        SystemRequirements findByOSname(String OSname);
//        SystemRequirements findByOSlanguage(String OSlanguage);

}
