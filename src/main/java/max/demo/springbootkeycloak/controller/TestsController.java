package max.demo.springbootkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestsController {

    @GetMapping("/tests-dates")
    public List<String> getTests() {
        return List.of("25.09.2023", "25.12.2023", "25.06.2024");
    }

    @GetMapping("/surprise-tests-dates")
    public List<String> getSurpriseTests() {
        return List.of("06.10.2023", "10.12.2023", "13.03.2024");
    }

}
