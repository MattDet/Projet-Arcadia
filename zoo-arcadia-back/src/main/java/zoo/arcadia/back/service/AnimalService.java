package zoo.arcadia.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import zoo.arcadia.back.entity.Animal;
import zoo.arcadia.back.repository.AnimalRepository;

@Log4j2
@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public List<Animal> findAll() {
        log.info("Find all animals");
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Animal not found"));
    }

    public Animal findByName(String name) {
        return animalRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Animal not found"));
    }

    public List<Animal> findAllBySpeciesId(Long speciesId) {
        return animalRepository.findAllBySpeciesId(speciesId);
    }

    public List<Animal> findAllByHabitatId(Long habitatId) {
        return animalRepository.findAllByHabitatId(habitatId);
    }

    public Animal createAnimal(Animal animal) {
        animal.setId(null);
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        if (animal.getId() != null && animalRepository.existsById(animal.getId())) {
            return animalRepository.save(animal);
        }
        throw new IllegalArgumentException("Animal not found");
    }

    public void deleteAnimal(Long id) {
        if (animalRepository.existsById(id)) {
            animalRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Animal not found");
        }
    }
    
}
