
package conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    public static Connection getConnection() throws Exception{
        String root= "jdbc:mysql://";
        String host="localhost:3306/";
        String db="floreria";
        String dbURL=root+host+db;
        String USER="root";
        String PASS="";
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = (Connection)DriverManager.getConnection(dbURL, USER, PASS);
        return conn;
    }
    
}
