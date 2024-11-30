package models;

import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private static final List<Usuario> usuarios = new ArrayList<>();

    static {
        usuarios.add(new Usuario("admin", "admin123", "administrador"));
        usuarios.add(new Usuario("operario", "operario123", "operario"));
        usuarios.add(new Usuario("usuario1", "user123", "usuario"));
        usuarios.add(new Usuario("usuario2", "user456", "usuario"));
    }

    public static Usuario autenticar(String username, String password) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }

    public static List<Usuario> getUsuarios() {
        return new ArrayList<>(usuarios); // Retornar copia para evitar modificaciones externas.
    }

    public static void agregarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.stream().anyMatch(u -> u.getUsername().equals(usuario.getUsername()))) {
            usuarios.add(usuario);
        }
    }
    

    public static void eliminarUsuario(String username) {
        usuarios.removeIf(usuario -> usuario.getUsername().equals(username));
    }

    public static void modificarUsuario(String username, String newPassword, String newRole) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username)) {
                usuario.setPassword(newPassword);
                usuario.setRole(newRole);
                break;
            }
        }
    }
}
