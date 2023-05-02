package max.demo.springbootkeycloak.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/everyone-authenticated")
    public String getEveryoneText() {
        return "hello to everyone that is authenticated";
    }

    @GetMapping("/user")
    @RolesAllowed("USER")
    public String getUserText() {
        return "hello user";
    }

    @GetMapping("/admin")
    @RolesAllowed("ADMIN")
    public String getAdminText() {
        return "hello admin";
    }

}
