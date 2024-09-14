package com.realtimechatgateway.POJO;

public class GatewayUser {
    private String username;
    private String password;

    private String role;
    private boolean active;

    public GatewayUser(String username, String password, String role, boolean active) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public String getRole() {
        return role;
    }
}
