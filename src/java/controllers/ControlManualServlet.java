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

@WebServlet("/controlManual")
public class ControlManualServlet extends HttpServlet {
    
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

        // Verificar el rol del usuario, solo los usuarios autorizados pueden controlar el puente manualmente
        if ("administrador".equals(usuario.getRole()) || "operario".equals(usuario.getRole())) {
            // Si el usuario tiene permiso, procesar el control manual
            String accion = request.getParameter("accion"); // Obtener acción (subir, bajar, detener, etc.)

            // Aquí podrías agregar la lógica para controlar el puente manualmente
            // Esta es solo una simulación, en un caso real se interactuaría con un sistema físico
            if ("subir".equals(accion)) {
                // Lógica para subir el puente
                request.setAttribute("mensaje", "El puente se está subiendo manualmente.");
                request.getRequestDispatcher("controlManualExitoso.jsp").forward(request, response);
            } else if ("bajar".equals(accion)) {
                // Lógica para bajar el puente
                request.setAttribute("mensaje", "El puente se está bajando manualmente.");
                request.getRequestDispatcher("controlManualExitoso.jsp").forward(request, response);
            } else {
                // Acción no reconocida
                request.setAttribute("mensaje", "Acción no válida para el control manual.");
                request.getRequestDispatcher("controlManualError.jsp").forward(request, response);
            }
        } else {
            // Si el usuario no tiene permisos, mostrar un error
            request.setAttribute("mensaje", "No tienes permisos para realizar esta acción.");
            request.getRequestDispatcher("controlManualError.jsp").forward(request, response);
        }
    }
}

