package com.antivirus.validator.RegionValidator;

import com.antivirus.dao.RegionDao;
import com.antivirus.entity.Region;
import com.antivirus.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RegionValidator implements Validator{

    @Autowired
    RegionDao regionDao;

    @Override
    public void validate(Object o) throws Exception {
        Region region = (Region) o;

        if(region.getName().isEmpty()){
            throw  new RegionException(RegionValidationMessages.EMPTY_REGIONNAME_FIELD);
        } else if (regionDao.findByName(region.getName()) != null){
            throw  new RegionException(RegionValidationMessages.REGIONNAME_ALREADY_EXISTS);
        }
    }
}
