package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class dbConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/hotel_booking";
    private static final String USER = "root";
    private static final String PSW = "#Varun@2003&25";
    protected static Connection conn=null;
    public static void connect()throws SQLException{
        conn=DriverManager.getConnection(URL,USER, PSW);
    }
}
