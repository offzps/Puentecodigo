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

@WebServlet("/controlUsuarios")
public class ControlUsuariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if ("administrador".equals(usuario.getRole()) || "operario".equals(usuario.getRole())) {
            request.setAttribute("usuarios", UsuarioManager.getUsuarios());
            request.getRequestDispatcher("controlUsuarios.jsp").forward(request, response);
        } else {
            request.setAttribute("mensaje", "No tienes permisos para acceder al control de usuarios.");
            request.getRequestDispatcher("controlUsuariosError.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if ("administrador".equals(usuario.getRole())) {
            if ("agregar".equals(accion)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String role = request.getParameter("role");

                if (username != null && !username.isEmpty() && password != null && !password.isEmpty() && role != null && !role.isEmpty()) {
                    Usuario nuevoUsuario = new Usuario(username, password, role);
                    UsuarioManager.agregarUsuario(nuevoUsuario);
                    request.setAttribute("mensaje", "Usuario agregado correctamente.");
                } else {
                    request.setAttribute("mensaje", "Todos los campos son obligatorios.");
                }

                request.getRequestDispatcher("controlUsuarios.jsp").forward(request, response);
            } else if ("eliminar".equals(accion)) {
                String username = request.getParameter("username");

                if (username != null && !username.isEmpty()) {
                    UsuarioManager.eliminarUsuario(username);
                    request.setAttribute("mensaje", "Usuario eliminado correctamente.");
                } else {
                    request.setAttribute("mensaje", "Debe especificar un nombre de usuario para eliminar.");
                }

                request.getRequestDispatcher("controlUsuarios.jsp").forward(request, response);
            } else if ("modificar".equals(accion)) {
                String username = request.getParameter("username");
                String newPassword = request.getParameter("password");
                String newRole = request.getParameter("role");

                if (username != null && !username.isEmpty() && newPassword != null && !newPassword.isEmpty() && newRole != null && !newRole.isEmpty()) {
                    UsuarioManager.modificarUsuario(username, newPassword, newRole);
                    request.setAttribute("mensaje", "Usuario modificado correctamente.");
                } else {
                    request.setAttribute("mensaje", "Todos los campos son obligatorios para modificar un usuario.");
                }

                request.getRequestDispatcher("controlUsuarios.jsp").forward(request, response);
            } else {
                request.setAttribute("mensaje", "Acción no válida.");
                request.getRequestDispatcher("controlUsuariosError.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("mensaje", "No tienes permisos para realizar esta acción.");
            request.getRequestDispatcher("controlUsuariosError.jsp").forward(request, response);
        }
    }
}
