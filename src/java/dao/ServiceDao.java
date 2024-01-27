/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import utils.DatabaseUtils;
import dto.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import validation.ServiceValidation;

/**
 *
 * @author PC
 */
public class ServiceDao {
    private static String SELECT_ALL_SERVICE_QUERY = "SELECT id, name, details, weightMinimum, weightMaximun, price, isDisable FROM Service ";
    private static String CHECK_SERVICE_NAME_QUERY = "SELECT 1 FROM Service WHERE name = ?";

    private static String INSERT_SERVICE_QUERY = "INSERT INTO [Service] ([name], [details], [weightMinimum], [weightMaximun], [price], [isDisable]) VALUES\n" +
            "  (?,?, ?, ?, ?, 0)";
    
    private static Service setService(ResultSet rs) throws SQLException{
        Service sv = new Service();
        sv.setId(rs.getInt("id"));
        sv.setName(rs.getNString("name"));
        sv.setDetails(rs.getNString("details"));
        sv.setMinimumWeight(rs.getFloat("weightMinimum"));
        sv.setMaximumWeight(rs.getFloat("weightMaximun"));
        sv.setPrice(rs.getFloat("price"));
        sv.setIsDisable(rs.getBoolean("isDisable"));
        
        return sv;
    }
    
    public static  List<Service> selectAllService(){
        List<Service> serviceList = new ArrayList<>();
         try{
            Connection connection = DatabaseUtils.makeConnection();
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(SELECT_ALL_SERVICE_QUERY);
            while(rs.next()){
                serviceList.add(setService(rs));
            };
         }
         catch(Exception e){
            System.out.println("Cannot create service!");
            System.out.println(e.getMessage());
        }
         return serviceList;
    }
    
    public static boolean checkServiceName(String name){
         try{
            Connection connection = DatabaseUtils.makeConnection();
            PreparedStatement stmt = connection.prepareStatement(CHECK_SERVICE_NAME_QUERY);
            stmt.setNString(1,name);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
         }
         catch(Exception e){
            System.out.println("Cannot create service!");
            System.out.println(e.getMessage());
        }
         return false;
    }
    public static boolean createService(ServiceValidation sv){
        try{
            Connection connection = DatabaseUtils.makeConnection();
            PreparedStatement stmt = connection.prepareStatement(INSERT_SERVICE_QUERY);
            stmt.setNString(1, sv.getName());
            stmt.setNString(2, sv.getDetails());
            stmt.setFloat(3, sv.getMinimumWeight());
            stmt.setFloat(4, sv.getMaximumWeight());
            stmt.setFloat(5, sv.getPrice());
            
            stmt.executeUpdate();
            return true;
        }
        catch(Exception e){
            System.out.println("Cannot create service!");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
