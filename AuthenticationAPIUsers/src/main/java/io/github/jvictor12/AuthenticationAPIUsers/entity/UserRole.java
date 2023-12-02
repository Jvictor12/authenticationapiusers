package io.github.jvictor12.AuthenticationAPIUsers.entity;

public enum UserRole {

    Admin("admin"),
    User("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
