/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import dto.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DatabaseUtils;

/**
 *
 * @author USER
 */
public class CustomerDao {
    private static String GET_ALL_CUSTOMERS = "select id, username, password, name, email, dob,phoneNumber,isBlocked from Customer";
    
    private static Customer setCustomer(ResultSet rs){
        
        Customer customer = new Customer();
        try{
            customer.setId(rs.getInt("id"));
            customer.setUsername(rs.getString("username"));
            customer.setPassword("password");
            customer.setName(rs.getNString("name"));
            customer.setEmail(rs.getString("email"));
            customer.setDob(rs.getString("dob"));
            customer.setPhoneNumber(rs.getString("phoneNumber"));
            customer.setIsBlocked(rs.getBoolean("isBlocked"));
        }catch(SQLException e){
            System.out.println("Cannot set Customer!");
            System.out.println(e.getMessage());
        }
        return customer;

    }
    
    public static List<Customer> getAllCustomer(){
        List<Customer> customerList = new ArrayList<>();
        try{
            Connection connection = DatabaseUtils.makeConnection();
            Statement stmt = connection.createStatement();
            if(connection != null){
                ResultSet rs = stmt.executeQuery(GET_ALL_CUSTOMERS);
                while (rs.next()) {                    
                    customerList.add(setCustomer(rs));
                }
            }
        }
        catch(Exception e){
            System.out.println("Cannot get all customers!");
            System.out.println(e.getMessage());
        }
        return customerList;
    }
}
