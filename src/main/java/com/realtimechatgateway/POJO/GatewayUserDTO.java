package com.realtimechatgateway.POJO;

public class GatewayUserDTO {
    private String username;
    private String password;
    private boolean enabled;

    public GatewayUserDTO() {}

    public GatewayUserDTO(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return enabled;
    }

    public void setActive(boolean active) {
        this.enabled = active;
    }
}

