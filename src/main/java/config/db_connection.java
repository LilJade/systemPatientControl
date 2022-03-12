package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LilJade
 */
public class db_connection {
    private Connection con;
    private String host = "localhost";
    private String user = "root";
    private String password = "liljade09";
    private String db = "spc_db";
    private String url = "jdbc:mysql://" + host + "/" + db;
    
    public Connection connectDB() {
        try {
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            System.out.println("Error trying to connect to database: " + e.getMessage());
        }
        return con;
    }
}
