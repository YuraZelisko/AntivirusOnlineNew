package com.antivirus.dao;

import com.antivirus.entity.SystemRequirements;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by User on 5/25/2017.
 */
public interface SystemRequirementsDao extends JpaRepository<SystemRequirements, Integer> {
}
