/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Calendar;

/**
 *
 * @author PC
 */
public class FormatUtils {
    public static boolean checkPhoneFormat(String phoneNumber){
        return phoneNumber.matches("\\d{10}");
    }
    
    public static boolean checkEmailFormat(String email){
        //return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$");
        return true;
    }
    
    public static boolean checkDobFormat(String dob){
         Calendar calendar = Calendar.getInstance();
         boolean rs = true;
         int dobYear = 0;
         int currentYear = calendar.get(Calendar.YEAR);
         String []a = dob.split("-");
         try{
             dobYear = Integer.parseInt(a[0]);
         }
         catch (NumberFormatException e){
             System.out.println("Cannot parse dobYear");
             System.out.println(e.getMessage());
             rs = false;
         }
         
         System.out.println("cur: " + currentYear);
         System.out.println("dob: " + dobYear);

         
         if(currentYear - dobYear < 16){
             rs = false;
         }
         return rs;
    }
}
