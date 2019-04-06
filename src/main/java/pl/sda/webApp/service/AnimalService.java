package pl.sda.webApp.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.webApp.model.Animal;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AnimalService {

    private Map<UUID, Animal> animalStorage = new HashMap<>();

    public Map<UUID, Animal> getAnimals() {
        return animalStorage;
    }

    public UUID addAnimal(Animal animal) {
        UUID uuid = UUID.randomUUID();
        animalStorage.put(uuid, animal);
        return uuid;
    }

    public boolean remove(UUID id) {
        if (animalStorage.containsKey(id)) {
            animalStorage.remove(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean edit(UUID id, Animal animal) {
        if (!animalStorage.containsKey(id) || animal == null) {
            throw new IllegalArgumentException("Wrong argument");
        }
        animalStorage.replace(id, animal);
        return true;
    }

    public ResponseEntity editName(UUID id, String name) {
        if (!animalStorage.containsKey(id)) {
            return null;
        }
        Animal animal = animalStorage.get(id);
        animal.setName(name);
        return ResponseEntity.ok(animal);
    }
}
