package tn.iit.glid23.auth.model;

public class UtilisateurModel {
    private String name;
    private String lastName;
    private String email;
    private String role;
    private String password;

    // Constructor
    public UtilisateurModel() {
        this.name = "";
        this.lastName = "";
        this.email = "";
        this.role = "";
        this.password = "";
    }
    public UtilisateurModel(String name, String lastName, String email, String role, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

