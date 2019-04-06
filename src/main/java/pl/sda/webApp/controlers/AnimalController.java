package pl.sda.webApp.controlers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sda.webApp.model.Animal;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private List<Animal> animalStorage = new ArrayList<>();

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Animal> animals() {
        return animalStorage;
    }

    @PostMapping("/add")
    public void addAnimal(@RequestBody Animal animal) {
        animalStorage.add(animal);
    }
}
