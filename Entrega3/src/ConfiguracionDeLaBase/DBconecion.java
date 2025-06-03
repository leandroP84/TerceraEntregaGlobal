package ConfiguracionDeLaBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconecion {

    private static final int MAX_CONNECTIONS = 10;
    private static int activeConnections = 0;

    private static final String URL = "jdbc:mysql://localhost:3306/TirameElBITDB";
    private static final String USER = "root";
    private static final String PASSWORD = "tirameelbit";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("EXCEPCION SI NO SE ENCONTRO", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (activeConnections >= MAX_CONNECTIONS) {
            throw new SQLException(String.valueOf(MAX_CONNECTIONS));
        }

        if (URL == null || URL.isEmpty() || USER == null) {
            throw new SQLException();
        }

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            activeConnections++;
            return conn;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    public static synchronized int getActiveConnections() {
        return activeConnections;
    }


    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                activeConnections--; //Esto hace que se cierre es la inversa
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}