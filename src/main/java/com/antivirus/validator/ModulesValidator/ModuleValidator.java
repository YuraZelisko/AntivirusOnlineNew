package com.antivirus.validator.ModulesValidator;

import com.antivirus.dao.ModulesIncludedDao;
import com.antivirus.entity.ModulesIncluded;
import com.antivirus.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ModuleValidator implements Validator{
    @Autowired
    private ModulesIncludedDao modulesIncludedDao;

    @Override
    public void validate(Object o) throws Exception {
        ModulesIncluded modulesIncluded = (ModulesIncluded) o;

        if (modulesIncluded.getName().isEmpty()){
            throw new ModuleException(ModuleValidationMessages.NAME_FIELD_IS_EMPTY);
        }else if (modulesIncludedDao.findByName(modulesIncluded.getName())!=null){
            throw new ModuleException(ModuleValidationMessages.NAME_ALREADY_EXIST);
        }else if (modulesIncluded.getDescription().isEmpty()){
            throw new ModuleException(ModuleValidationMessages.DESCRIPTION_FIELD_IS_EMPTY);
        }else if (modulesIncludedDao.findByDescription(modulesIncluded.getDescription())!=null){
            throw new ModuleException(ModuleValidationMessages.DESCRIPTION_ALREADY_EXIST);
        }

    }
    public void validateUpd(Object o) throws Exception {
        ModulesIncluded modulesIncluded = (ModulesIncluded) o;

        if (modulesIncluded.getName().isEmpty()){
            throw new ModuleException(ModuleValidationMessages.NAME_FIELD_IS_EMPTY);
        }else if (modulesIncluded.getDescription().isEmpty()){
            throw new ModuleException(ModuleValidationMessages.DESCRIPTION_FIELD_IS_EMPTY);
//        }else if (modulesIncludedDao.findByDescription(modulesIncluded.getDescription())!=null){
//            throw new ModuleException(ModuleValidationMessages.DESCRIPTION_ALREADY_EXIST);
        }

    }
}
