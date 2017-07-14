package com.antivirus.Editor;

import com.antivirus.entity.Product;

import java.beans.PropertyEditorSupport;

/**
 * Created by User on 7/12/2017.
 */
public class ProductEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String idProductFromJSP) throws IllegalArgumentException {

            Product product = new Product();
            product.setId(Integer.valueOf(idProductFromJSP));

            setValue(product);

        }
    }
