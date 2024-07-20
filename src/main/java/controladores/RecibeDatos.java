package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecibeDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = "jdbc:mysql://localhost:3307/pruebabd";
            String usuario = "root";
            String password = "123456";
            Connection conexion = null;
            Statement statement = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
                statement = conexion.createStatement();

                String nombres = request.getParameter("nombres");
                String apellidos = request.getParameter("apellidos");
                String email = request.getParameter("email");
                String telefono = request.getParameter("telefono");
                String ciudad = request.getParameter("ciudad");

                String query = "INSERT INTO CLIENTES (NOMBRES, APELLIDOS, EMAIL, TELEFONO, CIUDAD) VALUES ('"
                        + nombres + "','" + apellidos + "','" + email + "','" + telefono + "','" + ciudad + "')";

                statement.executeUpdate(query);

                out.println("<h1>Cliente insertado correctamente</h1>");
                out.println("<a href='insertarDatos.jsp'>Insertar otro cliente</a>");

            } catch (ClassNotFoundException | SQLException e) {
                out.println("<h1>Error al insertar cliente: " + e.getMessage() + "</h1>");
            } finally {
                try {
                    if (statement != null) statement.close();
                    if (conexion != null) conexion.close();
                } catch (SQLException e) {
                    out.println("<h1>Error al cerrar la conexión: " + e.getMessage() + "</h1>");
                }
            }
        }
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

    @Override
    public String getServletInfo() {
        return "Recibe datos de clientes";
    }
}
