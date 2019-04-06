package pl.sda.webApp.controlers;

import org.springframework.web.bind.annotation.*;
import pl.sda.webApp.model.Animal;

@RestController
public class MyFirstController {

    @GetMapping(value = "/animal", produces = "application/xml")
    public Animal animal(
            @RequestParam(name = "name", defaultValue = "default") String name) {
        Animal animal = new Animal(name, 8);
        return animal;
    }

    @RequestMapping(path = "favourite/{number}", method = RequestMethod.GET)
    public String favourite(
            @PathVariable("number") String number,
            @RequestParam(name = "name", defaultValue = "default") String name) {
        return " Hello," + name + " your favourite number is: " + number;
    }
}
