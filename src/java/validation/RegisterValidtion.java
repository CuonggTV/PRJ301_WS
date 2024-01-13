/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import dto.ValidateError;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class RegisterValidtion implements ValiditionBase{
    private String username;
    private String password;
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
        if(username == null || username.length() == 0){
            errors.add(new ValidateError("username", "Username cannot be empty!"));
        }
        
//        PASSWORD
        
        if(password == null || password.length() == 0){
            errors.add(new ValidateError("password", "Password cannot be empty!"));
        }
        
//        NAME
        if(name == null || name.length() == 0){
            errors.add(new ValidateError("name", "Name cannot be empty!"));
        }
        
//        EMAIL
        if(email == null || email.length() == 0){
            errors.add(new ValidateError("email", "Email cannot be empty!"));
        }
        
//        DOB
        if(dob == null || dob.length() == 0){
            errors.add(new ValidateError("dob", "Date of birth cannot be empty!"));
        }
        
//        PHONENUMBER
        if(phoneNumber == null || phoneNumber.length() == 0){
            errors.add(new ValidateError("phoneNumber", "Phone number cannot be empty!"));
        }
        
        return errors;
    }
}
