
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySQLConection {
    public static Connection getConnection() throws Exception{
    
        String root="jdbc:mysql://";
        String host="localhost:3306/";
        String db="floreria";
        String URL=root+host+db;
        String USER="root";
        String PASS="";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn=(Connection)DriverManager.getConnection(URL, USER,PASS);
        return conn;
    
    }

    
}
