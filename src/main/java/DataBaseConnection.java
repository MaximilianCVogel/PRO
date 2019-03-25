
import java.sql.*;
import java.util.*;

public class DataBaseConnection {
    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "root");
        conn = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/",
                connectionProps);
        System.out.println("Connected to database");
        return conn;
    }
}
