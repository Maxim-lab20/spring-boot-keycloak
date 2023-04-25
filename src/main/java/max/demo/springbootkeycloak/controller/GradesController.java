package max.demo.springbootkeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GradesController {

    @GetMapping("/grades/herbology")
    public Map<String, Integer> getHerbologyGrades() {
        return Map.of("Harry", 6, "Hermione", 10, "Ron", 6);
    }

    @GetMapping("/grades/potions")
    public Map<String, Integer> getPotionsGrades() {
        return Map.of("Harry", 2, "Hermione", 10, "Ron", 4);
    }

    @GetMapping("/grades/defence")
    public Map<String, Integer> getDefenceAgainstDarkArtsGrades() {
        return Map.of("Harry", 9, "Hermione", 10, "Ron", 8);
    }

}
