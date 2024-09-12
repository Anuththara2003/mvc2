/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dto.CustomerDto;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.CustomerModel;



 
 

/**
 *
 * @author USER
 */
public class CustomerController {
    
     private final CustomerModel CUSTOMER_Model;

    public CustomerController() {
        CUSTOMER_Model = new CustomerModel();
    }

    public ArrayList<CustomerDto> getAllCustomer() throws SQLException, ClassNotFoundException{
        ArrayList<CustomerDto> customerDto = CUSTOMER_Model.getAll();
        return customerDto;
    }
    
    public String saveCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        String resp = CUSTOMER_Model.save(customerDto);
        return resp;
    }

    public String updateCustomer(CustomerDto customerDto) throws SQLException, ClassNotFoundException{
        String resp = CUSTOMER_Model.Update(customerDto);
        return resp;
    }
    public CustomerDto searchCustomer(String CustId) throws SQLException, ClassNotFoundException{
        CustomerDto dto = CUSTOMER_Model.getCustomer(CustId);
        return dto;
    }

    public void saveCustomer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String deleteCustomer(String CustId) throws SQLException, ClassNotFoundException{
        String del = CUSTOMER_Model.clearCustomer(CustId);
        return del;
    }
}

    

