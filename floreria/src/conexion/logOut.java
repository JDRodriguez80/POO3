package conexion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vistas.login;


public class logOut {
   public static void logout(JFrame context, login loginScreen){
       loginSesion.logeado=false;
       context.setVisible(false);
       JOptionPane.showMessageDialog(null, "Sesion cerrada");
       loginScreen.setVisible(true);
       
   
   }
}
