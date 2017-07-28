package com.antivirus.validator.DeliveryValidator;

import com.antivirus.dao.DeliveryTypeDao;
import com.antivirus.entity.DeliveryType;
import com.antivirus.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeliveryValidator implements Validator{
    @Autowired
    DeliveryTypeDao deliveryTypeDao;

    @Override
    public void validate(Object o) throws Exception {
        DeliveryType deliveryType =(DeliveryType) o;

        if (deliveryType.getDeliveryServiceName().isEmpty()){
            throw new DeliveryException(DeliveryValidationMessages.DELIVERY_NAME_EMPTY);
        }else if (deliveryTypeDao.findByDeliveryServiceName(deliveryType.getDeliveryServiceName())!=null){
            throw new DeliveryException(DeliveryValidationMessages.DELIVERY_NAME_EXIST);
        }else  if (deliveryType.getCost() <=0){
            throw new DeliveryException(DeliveryValidationMessages.DELIVERY_COST_EXCEPTION);
        }else if (deliveryType.getDaysToArrive()<=0){
            throw new DeliveryException(DeliveryValidationMessages.DELIVERY_DAYS_EXCEPTION);
        }
    }
}
