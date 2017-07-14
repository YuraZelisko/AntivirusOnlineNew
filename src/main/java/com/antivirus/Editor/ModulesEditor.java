package com.antivirus.Editor;

import com.antivirus.entity.ModulesIncluded;

import java.beans.PropertyEditorSupport;

/**
 * Created by User on 7/12/2017.
 */
public class ModulesEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String idModuleFromJSP) throws IllegalArgumentException {

        ModulesIncluded modulesIncluded = new ModulesIncluded();
        modulesIncluded.setId(Integer.valueOf(idModuleFromJSP));

        setValue(modulesIncluded);

    }
}

