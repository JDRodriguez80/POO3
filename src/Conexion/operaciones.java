package Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class operaciones {
    public static boolean logeado (String user, String pass, String puesto, JFrame frame ){
        try {
            Connection conn = MySQLConection.getConnection();
            String querry=
              "SELECT numEmpleado, user, password, puesto FROM empleados WHERE user= '"+
                   user+
                   "'AND password ='"+
                   pass+
                   "'AND puesto='"+
                   puesto+
                   "'";
            PreparedStatement ps = conn.prepareStatement(querry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                loginSesion.user=rs.getString("user");
                loginSesion.puesto=rs.getString("puesto"); 
              
                return true;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "error de conexion" +e.getMessage());
        
        }
        return false;

    
    }
    
    
    
}
