<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Insertar Datos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CSS/styles.css">
</head>
<body>
    <div class="form-container">
        <h2>Insertar Nuevo Cliente</h2>
        <form action="RecibeDatos" method="post">
            <label for="nombres">Nombres:</label>
            <input type="text" id="nombres" name="nombres" required><br><br>
            
            <label for="apellidos">Apellidos:</label>
            <input type="text" id="apellidos" name="apellidos" required><br><br>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>
            
            <label for="telefono">Teléfono:</label>
            <input type="tel" id="telefono" name="telefono" required><br><br>
            
            <label for="ciudad">Ciudad:</label>
            <input type="text" id="ciudad" name="ciudad" required><br><br>
            
            <input type="submit" value="Insertar">
        </form>
    </div>
</body>
</html>



