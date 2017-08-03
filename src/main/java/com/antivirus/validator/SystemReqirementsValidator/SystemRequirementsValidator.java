package com.antivirus.validator.SystemReqirementsValidator;

import com.antivirus.dao.SystemRequirementsDao;
import com.antivirus.entity.SystemRequirements;
import com.antivirus.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SystemRequirementsValidator implements Validator{

    @Autowired
    private SystemRequirementsDao systemRequirementsDao;

    @Override
    public void validate(Object o) throws Exception {

        SystemRequirements systemRequirements = (SystemRequirements) o;
        if (systemRequirements.getOSname().isEmpty()) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.EMPTY_OSNAME_FIELD);
        }
        else if (systemRequirementsDao.findByOSname(systemRequirements.getOSname()) != null) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.OSNAME_ALREADY_EXIST);
        }
        else if (systemRequirements.getBitSystem().equals(null)) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.CHOOSE_BIT_DEPTH);
        }
        else if (systemRequirements.getSpaceAmount() <=0) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.INCORRECT_AMOUNT_FIELD);
        }
        else if (systemRequirements.getRAM() <=0) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.INCORRECT_RAM_FIELD);
        }
        else if (systemRequirements.getOSlanguage().isEmpty()) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.EMPTY_OSLANGUAGE_FIELD);
        }

    }

    @Override
    public void validateUpd(Object o) throws Exception {
        SystemRequirements systemRequirements = (SystemRequirements) o;
        if (systemRequirements.getOSname().isEmpty()) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.EMPTY_OSNAME_FIELD);
        }
//        else if (!systemRequirements.getBitSystem().equals("x32") ||!systemRequirements.getBitSystem().equals("x64")) {
//            throw new SystemRequirementsException(SystemRequirementsValidationMessages.CHOOSE_BIT_DEPTH);
//        }
        else if (systemRequirements.getSpaceAmount() <=0) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.INCORRECT_AMOUNT_FIELD);
        }
        else if (systemRequirements.getRAM() <=0) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.INCORRECT_RAM_FIELD);
        }
        else if (systemRequirements.getOSlanguage().isEmpty()) {
            throw new SystemRequirementsException(SystemRequirementsValidationMessages.EMPTY_OSLANGUAGE_FIELD);
        }

    }
}