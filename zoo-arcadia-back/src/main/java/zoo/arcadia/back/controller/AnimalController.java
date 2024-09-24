package zoo.arcadia.back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zoo.arcadia.back.entity.Animal;
import zoo.arcadia.back.service.AnimalService;

@RestController
@RequiredArgsConstructor
public class AnimalController {
    
    private final AnimalService animalService;

    @GetMapping("/v1/animals")
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/v1/animals/{id}")
    public Animal findById(@PathVariable Long id) {
        return animalService.findById(id);
    }

    @GetMapping("/v1/animals/name/{name}")
    public Animal findByName(@PathVariable String name) {
        return animalService.findByName(name);
    }

    @GetMapping("/v1/animals/species/{speciesId}")
    public List<Animal> findAllBySpeciesId(@PathVariable Long speciesId) {
        return animalService.findAllBySpeciesId(speciesId);
    }

    @GetMapping("/v1/animals/habitat/{habitatId}")
    public List<Animal> findAllByHabitatId(@PathVariable Long habitatId) {
        return animalService.findAllByHabitatId(habitatId);
    }
    
    @PostMapping("/v1/animals")
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }
    
    @PutMapping("/v1/animals")
    public Animal updateAnimal(@RequestBody Animal animal) {
        return animalService.updateAnimal(animal);
    }
    
    @DeleteMapping("/v1/animals/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }
}
