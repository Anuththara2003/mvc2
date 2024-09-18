/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gdse;

import DBConnection.DBConnection;
import View.LayoutFrame;
import View.OderForm;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class Gdse {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBConnection.getInstance().getConnetion();
          new LayoutFrame().setVisible(true);
      
        
    
    }
   
}
