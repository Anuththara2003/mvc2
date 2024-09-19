/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dto.OrderDto;
import Model.orderModel;

/**
 *
 * @author USER
 */
public class OrderController {
    
    private orderModel orderModel = new orderModel();
    
    public String placeOrder(OrderDto orderDto) throws Exception{
        String resp = orderModel.placeOrder(orderDto);
        return resp;
    }
}
