/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import dao.CustomerDao;
import dto.ValidateError;
import java.util.ArrayList;
import java.util.List;
import utils.FormatUtils;

/**
 *
 * @author USER
 */
public class RegisterValidtion implements ValiditionBase{
    private String username;
    private String password;
    private String confirmPassword;

    private String name;
    private String email;
    private String dob;
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber.trim();
    }

    @Override
    public List<ValidateError> validate() {
        List<ValidateError> errors = new ArrayList<>();
        
//        USERNAME
        if(username == null || username.length() == 0) {
            errors.add(new ValidateError("username", "Username cannot be empty!"));
        }
        else if(username.length() >50){
             errors.add(new ValidateError("username", "Username only has 50 letters!"));

        }
        else if(CustomerDao.checkUsernameExist(username)){
            errors.add(new ValidateError("username", "Username has been registed!"));
        }
        
//        PASSWORD
        
        if(password == null || password.length() == 0){
            errors.add(new ValidateError("password", "Password cannot be empty!"));
        }
//        CONFIRM PASSWORD
         if(confirmPassword == null || confirmPassword.length() == 0){
            errors.add(new ValidateError("confirmPassword", "Confirm password cannot be empty!"));
        }
        else if(!confirmPassword.equals(password)){
            errors.add(new ValidateError("confirmPassword", "Confirm password must equal to password!"));
        }
        
//        NAME
        if(name == null || name.length() == 0){
            errors.add(new ValidateError("name", "Name cannot be empty!"));
        }
        
//        EMAIL
        if(email == null || email.length() == 0){
            errors.add(new ValidateError("email", "Email cannot be empty!"));
        }
        else if (!FormatUtils.checkEmailFormat(email)){
            errors.add(new ValidateError("email", "Wrong email format!"));
        }
        else if (CustomerDao.checkEmailExist(email)){
            errors.add(new ValidateError("email", "Email has been registed!!"));
        }
        
//        DOB
        if(dob == null || dob.length() == 0){
            errors.add(new ValidateError("dob", "Date of birth cannot be empty!"));
        }
        else if(!FormatUtils.checkDobFormat(dob)){
            errors.add(new ValidateError("dob", "You must be 16 years old or older to use our services!"));
        }
        
        
//        PHONENUMBER
        if(phoneNumber == null || phoneNumber.length() == 0){
            errors.add(new ValidateError("phoneNumber", "Phone number cannot be empty!"));
        }
        else if(!FormatUtils.checkPhoneFormat(phoneNumber)){
             errors.add(new ValidateError("phoneNumber", "Phone number must have ten numbers!"));
        }
        
        return errors;
    }
}
