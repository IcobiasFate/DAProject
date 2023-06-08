package com.crud.javashastra;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControler {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the name of the login page template (without the file extension)
    }
}
