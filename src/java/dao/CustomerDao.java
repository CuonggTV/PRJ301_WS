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
    private static String GET_ALL_CUSTOMERS_QUERY = "select id, username, password, name, email, dob,phoneNumber,isBlocked " +
            "from Customer";
    private static String CHECK_CUSTOMER_EXIST_QUERY ="SELECT 1 FROM dbo.Customer \n" +
            "WHERE username = ? AND pass = ?";
    private static String CHECK_USERNAME_EXIST_QUERY ="SELECT 1 FROM dbo.Customer \n" +
            "WHERE username = ?";
    private static String CHECK_EMAIL_EXIST_QUERY ="SELECT 1 FROM dbo.Customer \n" +
            "WHERE email = ?";
    
    private static String INSERT_CUSTOMER_QUERY ="INSERT INTO [Customer] ([username], [password], [name], [email], [dob], [phoneNumber], [isBlocked])\n" +
"VALUES\n" +
"  (?, ?, ?, ?, ?, ?, 0),";
    
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
                ResultSet rs = stmt.executeQuery(GET_ALL_CUSTOMERS_QUERY);
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
    public static boolean checkCustomer(String username, String password){
        try{
            Connection connection = DatabaseUtils.makeConnection();
            PreparedStatement stmt = connection.prepareStatement(CHECK_CUSTOMER_EXIST_QUERY);
            if(connection != null){
                stmt.setString(1, username);
                stmt.setString(2, password);

                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }
        catch(Exception e){
            System.out.println("Cannot check customer!");
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static boolean checkUsernameExist(String username){
        try{
            Connection connection = DatabaseUtils.makeConnection();
            PreparedStatement stmt = connection.prepareStatement(CHECK_USERNAME_EXIST_QUERY);
            if(connection != null){
                stmt.setString(1,username);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }
        catch(Exception e){
            System.out.println("Cannot check customer!");
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    
    public static boolean checkEmailExist(String email){
        try{
            Connection connection = DatabaseUtils.makeConnection();
            PreparedStatement stmt = connection.prepareStatement(CHECK_EMAIL_EXIST_QUERY);
            if(connection != null){
                stmt.setString(1,email);
                ResultSet rs = stmt.executeQuery();
                return rs.next();
            }
        }
        catch(Exception e){
            System.out.println("Cannot check email!");
            System.out.println(e.getMessage());
        }
        return false;
    }
    public static boolean createCustomer(Customer customer){
        try{
            Connection connection = DatabaseUtils.makeConnection();
            PreparedStatement stmt = connection.prepareStatement(INSERT_CUSTOMER_QUERY);
            if(connection != null){
                stmt.setString(1, customer.getUsername());
                stmt.setString(2, customer.getPassword());
                stmt.setString(3, customer.getName());
                stmt.setString(4, customer.getEmail());
                stmt.setString(5, customer.getDob());
                stmt.setString(6, customer.getPhoneNumber());
                
                stmt.executeUpdate();
                return true;
            }
        }
        catch(Exception e){
            System.out.println("Cannot check email!");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
