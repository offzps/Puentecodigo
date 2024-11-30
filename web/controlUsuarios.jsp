<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Control de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h1>Control de Usuarios</h1>
    
    <p>${mensaje}</p> <!-- Mensaje de acción exitosa o error -->
    
    <h2>Lista de Usuarios</h2>
    <table>
        <tr>
            <th>Username</th>
            <th>Rol</th>
            <th>Acciones</th>
        </tr>
        <c:forEach var="usuario" items="${usuarios}">
            <tr>
                <td>${usuario.username}</td>
                <td>${usuario.role}</td>
                <td>
                    <form method="post">
                        <input type="hidden" name="username" value="${usuario.username}">
                        <button type="submit" name="accion" value="eliminar">Eliminar</button>
                        <button type="submit" name="accion" value="modificar">Modificar</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Agregar Usuario</h2>
    <form method="post">
        <label>Username: <input type="text" name="username" required></label><br>
        <label>Password: <input type="password" name="password" required></label><br>
        <label>Rol: 
            <select name="role">
                <option value="administrador">Administrador</option>
                <option value="operario">Operario</option>
                <option value="usuario">Usuario</option>
            </select>
        </label><br>
        <button type="submit" name="accion" value="agregar">Agregar Usuario</button>
    </form>

    <a href="menu.jsp">Volver al menú</a>
</body>
</html>
c