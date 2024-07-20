package creausuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreaUsuario {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3307/pruebabd";
        String usuario = "root";
        String password = "123456";
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreaUsuario.class.getName()).log(Level.SEVERE, "Error cargando el driver JDBC: " + ex.getMessage(), ex);
        }

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO CLIENTES(NOMBRES, APELLIDOS, EMAIL, TELEFONO, CIUDAD) VALUES ('Pepe', 'Castillo', 'pepe@gmail.com', '3112568974', 'Cali')");
            rs = statement.executeQuery("SELECT * FROM CLIENTES");
            while (rs.next()) {
                System.out.println(rs.getInt("id_cliente") + " : " + rs.getString("nombres"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreaUsuario.class.getName()).log(Level.SEVERE, "Error al insertar cliente: " + ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CreaUsuario.class.getName()).log(Level.SEVERE, "Error cerrando recursos: " + ex.getMessage(), ex);
            }
        }
    }
}
