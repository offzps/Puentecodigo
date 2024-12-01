package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import models.Usuario;
import models.UsuarioManager;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Llamar al modelo para autenticar
        Usuario usuario = UsuarioManager.autenticar(username, password);
        
        if (usuario != null) {
            // Crear sesión y redirigir al menú
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            response.sendRedirect("menu.jsp");
        } else {
            // Devolver al login con mensaje de error
            request.setAttribute("error", "Usuario o contraseña incorrectos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }*/
        try (PrintWriter out = response.getWriter()) {
            out.println("Helloworld");
        }
        
    }
}
