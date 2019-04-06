package pl.sda.webApp.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.webApp.model.Animal;

@RestController
public class MyFirstController {

    @GetMapping("/animal")
    public Animal animal(
            @RequestParam(name = "name", defaultValue = "default") String name) {
        Animal animal = new Animal(name, 8);
        return animal;
    }

    @GetMapping("/favourite/{number}")
    public String favourite(@PathVariable("number") String number) {
        return number;
    }
}
