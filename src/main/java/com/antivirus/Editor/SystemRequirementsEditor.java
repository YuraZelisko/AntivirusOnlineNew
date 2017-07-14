package com.antivirus.Editor;



import com.antivirus.entity.SystemRequirements;

import java.beans.PropertyEditorSupport;

/**
 * Created by User on 7/12/2017.
 */
public class SystemRequirementsEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String idSystemFromJSP) throws IllegalArgumentException {

            SystemRequirements systemRequirements = new SystemRequirements();
            systemRequirements.setId(Integer.valueOf(idSystemFromJSP));

            setValue(systemRequirements);

        }
    }


