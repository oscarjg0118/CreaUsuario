<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mostrar Datos</title>
</head>
<body>
    <h2>Lista de Clientes</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Email</th>
            <th>Teléfono</th>
            <th>Ciudad</th>
        </tr>
        <%
            String url = "jdbc:mysql://localhost:3307/pruebabd";
            String usuario = "root";
            String password = "123456";
            Connection conexion = null;
            Statement statement = null;
            ResultSet rs = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(url, usuario, password);
                statement = conexion.createStatement();
                rs = statement.executeQuery("SELECT * FROM CLIENTES");

                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getInt("id_cliente") + "</td>");
                    out.println("<td>" + rs.getString("nombres") + "</td>");
                    out.println("<td>" + rs.getString("apellidos") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("telefono") + "</td>");
                    out.println("<td>" + rs.getString("ciudad") + "</td>");
                    out.println("</tr>");
                }
            } catch (ClassNotFoundException | SQLException e) {
                out.println("<h1>Error al mostrar clientes: " + e.getMessage() + "</h1>");
            } finally {
                try {
                    if (rs != null) rs.close();
                    if (statement != null) statement.close();
                    if (conexion != null) conexion.close();
                } catch (SQLException e) {
                    out.println("<h1>Error al cerrar la conexión: " + e.getMessage() + "</h1>");
                }
            }
        %>
    </table>
</body>
</html>

