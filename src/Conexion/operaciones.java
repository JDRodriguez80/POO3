
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class operaciones {
    public static boolean logeado(String user, String pass, String puesto, JFrame frame){
        try {
           Connection conn = MySQLConnection.getConnection();
           String MySQLQuerry=
                   "SELECT user, password, puesto FROM empleados WHERE user= '"+
                   user+
                   "'AND password ='"+
                   pass+
                   "'AND puesto='"+
                   puesto+
                   "'";
           PreparedStatement ps= conn.prepareStatement(MySQLQuerry);
           ResultSet rs= ps.executeQuery();
           
            while (rs.next()) {                
                //loginSesion.numEmpleado=rs.getInt("numEmpleado");
                loginSesion.user=rs.getString("user");
                //loginSesion.pass=rs.getString("pass");
                loginSesion.puesto=rs.getString("puesto");
               
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "error en base de datos" + e.getMessage());
        }
        return false;
    }
}
