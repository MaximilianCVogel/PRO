
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
        System.out.println("Connecté à la base de donnée");
        return conn;
    }

    /**
     * Méthode qui permet d'effectuer une requête SELECT dans la BDD
     * @param requete la requête
     * @return le résultat de la requête, null si il y a une erreur
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


}
