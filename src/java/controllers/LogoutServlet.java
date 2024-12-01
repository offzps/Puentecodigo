package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Obtener sesión actual
        /*
        if (session != null) {
            session.invalidate(); // Invalidar sesión
        }
        response.sendRedirect("login.jsp"); // Redirigir al login
*/
        response.sendRedirect("/"); // Redirigir al login
    }
}
