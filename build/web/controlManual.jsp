<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- Importación de JSTL -->
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Control Manual del Puente</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Control Manual del Puente</h1>
    </header>
    <main>
        <!-- Validar si el usuario está autenticado -->
        <c:if test="${not empty usuario}">
            <form method="post" action="controlManual">
                <p>Seleccione la acción que desea realizar:</p>
                <button type="submit" name="accion" value="subir">Subir Puente</button>
                <button type="submit" name="accion" value="bajar">Bajar Puente</button>
                <button type="submit" name="accion" value="detener">Detener Puente</button>
            </form>
        </c:if>
        <c:if test="${empty usuario}">
            <!-- Usuario no autenticado -->
            <p>No tienes permisos para realizar acciones manuales en el puente.</p>
            <a href="login.jsp">Volver al inicio</a>
        </c:if>
        <a href="menu.jsp">Volver al menú principal</a>
    </main>
</body>
</html>
