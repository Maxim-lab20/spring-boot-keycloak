package max.demo.springbootkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassesController {

    @GetMapping("/classes")
    public List<String> getClasses() {
        return List.of("Herbology", "Potions", "Defence Against Dark Arts");
    }

}
