package com.antivirus.Editor;

import com.antivirus.entity.User;

import java.beans.PropertyEditorSupport;

/**
 * Created by USER on 31.05.2017.
 */
public class UserEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String idUserFromJSP) throws IllegalArgumentException {

            User user = new User();
            user.setId(Integer.valueOf(idUserFromJSP));

            setValue(user);

        }
    }


