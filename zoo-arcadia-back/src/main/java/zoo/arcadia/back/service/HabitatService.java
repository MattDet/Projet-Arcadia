package zoo.arcadia.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import zoo.arcadia.back.entity.Habitat;
import zoo.arcadia.back.repository.HabitatRepository;

@Log4j2
@Service
@RequiredArgsConstructor
public class HabitatService {
    
    private final HabitatRepository habitatRepository;

    public List<Habitat> findAll() {
        log.info("Find all habitats");
        return habitatRepository.findAll();
    }

    public Habitat findById(Long id) {
        return habitatRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Habitat not found"));
    }

    public Habitat findByName(String name) {
        return habitatRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Habitat not found"));
    }

    public Habitat createHabitat(Habitat habitat) {
        habitat.setId(null);
        return habitatRepository.save(habitat);
    }

    public Habitat updateHabitat(Habitat habitat) {
        if (habitat.getId() != null && habitatRepository.existsById(habitat.getId())) {
            return habitatRepository.save(habitat);
        }
        throw new IllegalArgumentException("Habitat not found");
    }

    public void deleteHabitat(Long id) {
        if (habitatRepository.existsById(id)) {
            habitatRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Habitat not found");
        }
    }
}
