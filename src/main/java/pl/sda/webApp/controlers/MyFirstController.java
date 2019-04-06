package pl.sda.webApp.controlers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sda.webApp.model.Animal;

@RestController
public class MyFirstController {

    @GetMapping(value = "/animal", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Animal animal(
            @RequestParam(name = "name", defaultValue = "default") String name) {
        Animal animal = new Animal(name, 8);
        return animal;
    }

    @GetMapping(value = "/animalXML", produces = "application/xml")
    public Animal animalXML(
            @RequestParam(name = "name", defaultValue = "default") String name) {
        Animal animal = new Animal(name, 9);
        return animal;
    }

    @RequestMapping(path = "favourite/{number}", method = RequestMethod.GET)
    public String favourite(
            @PathVariable("number") String number,
            @RequestParam(name = "name", defaultValue = "default") String name) {
        return " Hello," + name + " your favourite number is: " + number;
    }

    @GetMapping(value = "/animalx")
    public Animal animalXML() {
        Animal animal = new Animal("Kacper", 9);
        return animal;
    }

}
