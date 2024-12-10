/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author blood
 */
public class CConexion {
    
    Connection conectar = null;
    
    String usuario="root";
    String contrasenia="root";
    String bd="dbpos";
    String ip="localhost";
    String puerto="3306";
    
    String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
            //JOptionPane.showMessageDialog(null,"Conexion correcta a BD");
        } 
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"NO SE CONECTÓ A LA BD:"+e.toString());
        }
    
    return conectar;
        
    }
    
    public void cerrarConexion(){
        try {
            if (conectar!=null && !conectar.isClosed()) {
                conectar.close();
                //JOptionPane.showMessageDialog(null,"La conexion fue cerrada");
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Logro cerrar la conexion"+e.toString());
        }
        
        
    }
    
    
}
