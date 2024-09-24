package zoo.arcadia.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import zoo.arcadia.back.entity.Species;
import zoo.arcadia.back.repository.SpeciesRepository;

@Log4j2
@Service
@RequiredArgsConstructor
public class SpeciesService  {
    
    private final SpeciesRepository speciesRepository;
    
    public List<Species> findAll() {
        log.info("Find all species");
        return speciesRepository.findAll();
    }

    public Species findById(Long id) {
        return speciesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Species not found"));
    }

    public Species findByName(String name) {
        return speciesRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Species not found"));
    }

    public Species createSpecies(Species species) {
        species.setId(null);
        return speciesRepository.save(species);
    }

    public Species updateSpecies(Species species) {
        if (species.getId() != null && speciesRepository.existsById(species.getId())) {
            return speciesRepository.save(species);
        }
        throw new IllegalArgumentException("Species not found");
    }

    public void deleteSpecies(Long id) {
        if (speciesRepository.existsById(id)) {
            speciesRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Species not found");
        }
    }
}
