/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import dao.ServiceDao;
import dto.ValidateError;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ServiceValidation implements ValiditionBase{
    private String name;
    private String details;
    private float minimumWeight;
    private float maximumWeight;
    private float price;

    public ServiceValidation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public float getMinimumWeight() {
        return minimumWeight;
    }

    public void setMinimumWeight(float minimumWeight) {
        this.minimumWeight = minimumWeight;
    }

    public float getMaximumWeight() {
        return maximumWeight;
    }

    public void setMaximumWeight(float maximumWeight) {
        this.maximumWeight = maximumWeight;
    }

    public float getPrice() {
        return price;
    }

    public void stPrice(float price) {
        this.price = price;
    }

    @Override
    public List<ValidateError> validate() {
         List<ValidateError> errors = new ArrayList<>();
        
//        NAME
        if(name == null || name.length() == 0) {
            errors.add(new ValidateError("name", "Name cannot be empty!"));
        }
        else if(name.length() >100){
            errors.add(new ValidateError("name", "Name can only have 100 letters!"));
        }
        else if(ServiceDao.checkServiceName(name)){
            errors.add(new ValidateError("name", "This name has been already registed!"));
        }
//        DETAILS
        if(details == null || details.length() == 0) {
            errors.add(new ValidateError("details", "Details cannot be empty!"));
        }
        else if(details.length() >1000){
            errors.add(new ValidateError("details", "Details can only have 1000 letters!"));
        }
        return errors;
    }
    
}
