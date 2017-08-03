package com.antivirus.validator;

/**
 * Created by USER on 29.05.2017.
 */
public interface Validator {
    void  validate(Object o) throws Exception;
    void validateUpd (Object o) throws Exception;
}
