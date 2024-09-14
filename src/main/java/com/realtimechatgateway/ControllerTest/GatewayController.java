package com.realtimechatgateway.ControllerTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {
    @GetMapping("/gate")
    public String home() {
        return "Gateway is running!";
    }
}

