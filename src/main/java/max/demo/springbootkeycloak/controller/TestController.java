package max.demo.springbootkeycloak.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    @RolesAllowed("USER")
    public String getHomeText() {
        return "hello user";
    }

    @GetMapping("/admin")
    @RolesAllowed("ADMIN")
    public String getAdminText() {
        return "hello admin";
    }

}
