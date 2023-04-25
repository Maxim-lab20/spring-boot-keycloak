package max.demo.springbootkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String getHomeMessage() {
        return "Welcome to Hogwarts!";
    }


}
