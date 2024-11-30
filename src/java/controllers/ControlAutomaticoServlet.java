package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import models.Usuario;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/controlAutomatico")
public class ControlAutomaticoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener la sesión actual
        HttpSession session = request.getSession(false);

        // Verificar si la sesión es válida
        if (session == null || session.getAttribute("usuario") == null) {
            // Si no hay sesión o usuario, redirigir al login
            response.sendRedirect("login.jsp");
            return;
        }

        // Obtener el usuario de la sesión
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // Verificar el rol del usuario, solo los administradores y operarios pueden usar el control automático
        if ("administrador".equals(usuario.getRole()) || "operario".equals(usuario.getRole())) {
            // Procesar la acción automática solicitada
            String accion = request.getParameter("accion");

            if ("activar".equals(accion)) {
                // Lógica para activar el control automático
                request.setAttribute("mensaje", "El control automático del puente ha sido activado correctamente.");
                request.setAttribute("tipoMensaje", "exito");
            } else if ("desactivar".equals(accion)) {
                // Lógica para desactivar el control automático
                request.setAttribute("mensaje", "El control automático del puente ha sido desactivado correctamente.");
                request.setAttribute("tipoMensaje", "exito");
            } else {
                // Acción no reconocida
                request.setAttribute("mensaje", "Acción no válida para el control automático.");
                request.setAttribute("tipoMensaje", "error");
            }
        } else {
            // Si el usuario no tiene permisos
            request.setAttribute("mensaje", "No tienes permisos para realizar esta acción.");
            request.setAttribute("tipoMensaje", "error");
        }

        // Redirigir al JSP único
        request.getRequestDispatcher("controlAutomatico.jsp").forward(request, response);
    }
}


