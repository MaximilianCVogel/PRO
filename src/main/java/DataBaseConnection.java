
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
        System.out.println("Connecte a la base de donnee");
        return conn;
    }

    /**
     * Methode qui permet d'effectuer une requete SELECT dans la BDD
     * @param requete la requete
     * @return le resultat de la requete, null si il y a une erreur
     */
    public ResultSet select(String requete) {

        try {
            Statement statement = getConnection().createStatement();
            return statement.executeQuery(requete);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public 


}
