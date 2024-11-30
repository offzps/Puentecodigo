package models;

public class Usuario {
    private String username;
    private String password;
    private String role;

    public Usuario(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Método para actualizar la contraseña del usuario
    public void setPassword(String password) {
        this.password = password;
    }

    // Método para actualizar el rol del usuario
    public void setRole(String role) {
        this.role = role;
    }
}
