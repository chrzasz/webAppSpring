package pl.sda.webApp.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.webApp.model.Animal;
import pl.sda.webApp.service.AnimalService;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<UUID, Animal> animals() {
        return animalService.getAnimals();
    }

    @PostMapping("/add")
    public UUID addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable UUID id) {
        return animalService.remove(id);
    }

    @PutMapping("/edit/{id}")
    public boolean edit(@RequestBody Animal animal, @PathVariable UUID id) {
        try {
            return animalService.edit(id, animal);
        } catch (Exception ex) {
            return false;
        }
    }

    @PutMapping("/edit-name/{id}")
    public ResponseEntity editName(@RequestParam("name") String name, @PathVariable UUID id) {
        ResponseEntity result = animalService.editName(id, name);

        if (result == null) {
            return ResponseEntity.badRequest().body("Bad request");
        } else {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
        }
    }


}
