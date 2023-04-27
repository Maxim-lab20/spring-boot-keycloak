package max.demo.springbootkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestsController {

    @GetMapping("/admin")
    public String getAdminText() {
        return "hello admin";
    }

}
