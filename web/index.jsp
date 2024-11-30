<%@ page language="java" %>

<!DOCTYPE html>
<html>
<head>
     <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <form method="post" action="login">
    <h1>Ingrese a los controles del puente: </h1>
    <input type="text" name="username" placeholder="Usuario" required><br>
    <input type="password" name="password" placeholder="Contraseña" required><br>
    <button type="submit">Iniciar Sesión</button>
</form>

</body>
</html>