package controllers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import models.Usuario;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/calibrarPuente")
public class CalibrarPuenteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Obtener la sesión actual
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        // 2. Validación del usuario (solo administrador puede calibrar)
        if (usuario == null || !usuario.getRole().equals("administrador")) {
            // Si no es un administrador, redirigir al error.jsp
            response.sendRedirect("error.jsp");
            return;
        }

        // 3. Lógica de calibración
        boolean calibracionExitosa = calibrarPuente();

        // 4. Redirigir según el resultado de la calibración
        if (calibracionExitosa) {
            // Si la calibración es exitosa
            request.setAttribute("mensaje", "El puente se calibró exitosamente.");
            request.getRequestDispatcher("calibracionExitoso.jsp").forward(request, response);
        } else {
            // Si hubo un error en la calibración
            request.setAttribute("mensaje", "Hubo un problema al calibrar el puente.");
            request.getRequestDispatcher("calibracionError.jsp").forward(request, response);
        }
    }

    // Método simulado para realizar la calibración del puente
    private boolean calibrarPuente() {
        // Aquí iría la lógica real para calibrar el puente.
        // Este es un ejemplo simulado que devuelve siempre true (calibración exitosa).
        
        // Lógica de calibración (simulada)
        // Aquí puedes agregar la lógica real para ajustar parámetros del sistema de control del puente.
        
        // Para este ejemplo, retornamos true, indicando que la calibración fue exitosa.
        return true;  // Cambia este valor a 'false' para simular un error en la calibración.
    }
}
