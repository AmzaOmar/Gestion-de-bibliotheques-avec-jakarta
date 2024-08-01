package com.example.campuslibrary.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private static String url = "jdbc:mysql://localhost:3306/campuslibrary?ServerTimezone=GMT";
    private static String user = "Amza";
    private static String password = "Cheikhn@";

    private Connexion() {}

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connexion réussie");
            } else {
                System.out.println("Connexion échouée");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace(); // Gestion de l'exception de classe non trouvée
        }
        return conn;
    }
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connexion fermée avec succès");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                // Vous pouvez logger l'erreur ici
            }
        }
    }
}
