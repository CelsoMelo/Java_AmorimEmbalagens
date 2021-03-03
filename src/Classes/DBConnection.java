package Classes;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

   // private static final String USR = "root";
    private static final String URL = "jdbc:sqlite:bd/amorim.db";/*"jdbc:mysql://localhost:3306/AmorimEmbalagens";*/
   // private static final String PASS = "";
    private static final String DRIVER = "org.sqlite.JDBC";/*"com.mysql.jdbc.Driver";*/

    public static Connection conectar() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL/*, USR, PASS*/);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }

    }

    public static void closeConnection(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, Statement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, Statement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
