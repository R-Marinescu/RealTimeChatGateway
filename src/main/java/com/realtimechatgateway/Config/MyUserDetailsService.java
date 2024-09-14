package com.realtimechatgateway.Config;
import com.realtimechatgateway.POJO.GatewayUser;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final WebClient webClient;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MyUserDetailsService(WebClient.Builder webClientBuilder, PasswordEncoder passwordEncoder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081/user-service/api").build();
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JsonNode userJson = webClient.get()
                .uri("/users/username/{username}", username)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();

        if(userJson == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        String userUsername = userJson.get("username").asText();
        String userPassword = userJson.get("password").asText();
        String userRole = userJson.get("role").asText();
        boolean userActive = userJson.get("enabled").asBoolean();

        GatewayUser gatewayUser = new GatewayUser(userUsername, userPassword, userRole, userActive);

        passwordEncoder.encode(gatewayUser.getPassword());

        return new MyUserPrincipal(gatewayUser);
    }
}