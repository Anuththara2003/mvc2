/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DBConnection.DBConnection;
import Dto.CustomerDto;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author USER
 */
public class CustomerModel {
    public ArrayList<CustomerDto> getAll() throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnetion();
        String sql = "SELECT * FROM Customer";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        while(rst.next()){
            CustomerDto customerDto = new CustomerDto();
            customerDto.setCustID(rst.getString("CustID"));
            customerDto.setCustTitle(rst.getString("CustTitle"));
            customerDto.setCustName(rst.getString("CustName"));
            customerDto.setDOB(rst.getString("DOB"));
            customerDto.setSalary(rst.getInt("Salary"));
            customerDto.setCustAddress(rst.getString("CustAddress"));
            customerDto.setCity(rst.getString("City"));
            customerDto.setProvince(rst.getString("Province"));
            customerDto.setPostalCode(rst.getString("PostalCode"));

 
            customerDtos.add(customerDto);
        }
        return customerDtos;
    }
    
    public String save(CustomerDto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnetion();
        
        String sql = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(1, dto.getCustID());
        statement.setString(2, dto.getCustTitle());
        statement.setString(3, dto.getCustName());
        statement.setString(4, dto.getDOB());
        statement.setDouble(5, dto.getSalary());
        statement.setString(6, dto.getCustAddress());
        statement.setString(7, dto.getCity());
        statement.setString(8, dto.getProvince());
        statement.setString(9, dto.getPostalCode());
        
        int resp = statement.executeUpdate();
        return resp > 0 ? "Success" : "Fail";
    }
    
    public String Update(CustomerDto dto) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnetion();
        
        String sql = "UPDATE customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustId = ?";         
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setString(9, dto.getCustID());
        statement.setString(1, dto.getCustTitle());
        statement.setString(2, dto.getCustName());
        statement.setString(3, dto.getDOB());
        statement.setDouble(4, dto.getSalary());
        statement.setString(5, dto.getCustAddress());
        statement.setString(6, dto.getCity());
        statement.setString(7, dto.getProvince());
        statement.setString(8, dto.getPostalCode());
        
        int resp = statement.executeUpdate();
        return resp > 0 ? "Success" : "Fail";
    }
    public CustomerDto getCustomer(String custId) throws SQLException, ClassNotFoundException{
          
        Connection connection=DBConnection.getInstance().getConnetion();
        String sql = "SELECT * FROM customer WHERE CustID = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, custId);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            CustomerDto dto = new CustomerDto();
            dto.setCustID(rst.getString("CustId"));
            dto.setCustTitle(rst.getString("CustTitle"));
            dto.setCustName(rst.getString("CustName"));
            dto.setDOB(rst.getString("DOB"));
            dto.setSalary(rst.getDouble("salary"));
            dto.setCustAddress(rst.getString("CustAddress"));
            dto.setCity(rst.getString("City"));
            dto.setProvince(rst.getString("Province"));
            dto.setPostalCode(rst.getString("PostalCode"));

            return dto;
        }
        return null;
    }
    public String clearCustomer(String custId) throws SQLException, ClassNotFoundException{
        Connection connection=DBConnection.getInstance().getConnetion(); 
        String sql = "DELETE FROM customer WHERE CustID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, custId);

        int affectedRows = statement.executeUpdate();
        return affectedRows > 0 ? "Success" : "Fail";
    }
}
