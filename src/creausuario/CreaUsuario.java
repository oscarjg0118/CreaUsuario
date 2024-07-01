package creausuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreaUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String url = "jdbc:mysql://localhost:3306/pruebabd";
            String usuario = "root";
            String password = "";
            Connection conexion;
            Statement statement;

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO CLIENTES(NOMBRES, APELLIDOS, EMAIL, TELEFONO, CIUDAD) VALUES ('JUANCHO', 'MARTINEZ', 'JUANCHO@GMAIL.COM', '313259366', 'CALI')");
            conexion.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CreaUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("clientes.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}