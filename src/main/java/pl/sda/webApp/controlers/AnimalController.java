package pl.sda.webApp.controlers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.sda.webApp.model.Animal;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private Map<UUID, Animal> animalStorage = new HashMap<>();

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<UUID, Animal> animals() {
        return animalStorage;
    }

    @PostMapping("/add")
    public UUID addAnimal(@RequestBody Animal animal) {
        UUID uuid = UUID.randomUUID();
        animalStorage.put(uuid, animal);
        return uuid;
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable UUID id) {
        if (animalStorage.containsKey(id)) {
            animalStorage.remove(id);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/edit/{id}")
    public boolean edit(@RequestBody Animal animal, @PathVariable UUID id) {
        if (!animalStorage.containsKey(id) || animal == null) {
            throw new IllegalArgumentException("Wrong argument");
        }
        animalStorage.replace(id, animal);
        return true;
    }

    @PutMapping("/edit-name/{id}")
    public boolean editName(@RequestParam("name") String name, @PathVariable UUID id) {
        if (!animalStorage.containsKey(id)) {
            throw new IllegalArgumentException("Wrong argument");
        }
        animalStorage.get(id).setName(name);
        return true;
    }


}
