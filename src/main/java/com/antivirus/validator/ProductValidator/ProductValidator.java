package com.antivirus.validator.ProductValidator;

import com.antivirus.dao.ProductDao;
import com.antivirus.entity.Product;
import com.antivirus.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator implements Validator{
    @Autowired
    private ProductDao productDao;

    @Override
    public void validate(Object o) throws Exception {
        Product product=(Product)o;
        if (product.getName().isEmpty()){
            throw new ProductException(ProductValidationMessages.NAME_IS_EMPTY);
        }else if (productDao.findByName(product.getName()) != null){
            throw new ProductException(ProductValidationMessages.NAME_ALREADY_EXIST);
        }else if (product.getDescription().isEmpty()){
            throw new ProductException(ProductValidationMessages.DESCRIPTION_IS_EMPTY);
        }else if (product.getPrice()<=0){
            throw new ProductException(ProductValidationMessages.INCORRECT_PRICE);
        }else if (product.getQuantityPC()<=0){
            throw new ProductException(ProductValidationMessages.INCORRECT_QUANTITY);
        }else if (product.getLicenceDurationYears()<=0){
            throw new ProductException(ProductValidationMessages.INCORRECT_LICENCE);
        }
    }

    @Override
    public void validateUpd(Object o) throws Exception {
        Product product=(Product)o;
        if (product.getName().isEmpty()){
            throw new ProductException(ProductValidationMessages.NAME_IS_EMPTY);
        }else if (product.getDescription().isEmpty()){
            throw new ProductException(ProductValidationMessages.DESCRIPTION_IS_EMPTY);
        }else if (product.getPrice()<=0){
            throw new ProductException(ProductValidationMessages.INCORRECT_PRICE);
        }else if (product.getQuantityPC()<=0){
            throw new ProductException(ProductValidationMessages.INCORRECT_QUANTITY);
        }else if (product.getLicenceDurationYears()<=0){
            throw new ProductException(ProductValidationMessages.INCORRECT_LICENCE);
        }
    }

}
