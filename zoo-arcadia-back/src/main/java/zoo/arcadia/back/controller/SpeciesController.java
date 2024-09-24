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
import zoo.arcadia.back.entity.Species;
import zoo.arcadia.back.service.SpeciesService;

@RestController
@RequiredArgsConstructor
public class SpeciesController {
    
    private final SpeciesService speciesService;

    @GetMapping("/v1/species")
    public List<Species> findAll() {
        return speciesService.findAll();
    }

    @GetMapping("/v1/species/{id}")
    public Species findById(@PathVariable Long id) {
        return speciesService.findById(id);
    }

    @GetMapping("/v1/species/name/{name}")
    public Species findByName(@PathVariable String name) {
        return speciesService.findByName(name);
    }
    
    @PostMapping("/v1/species")
    public Species createSpecies(@RequestBody Species species) {
        return speciesService.createSpecies(species);
    }
    
    @PutMapping("/v1/species")
    public Species updateSpecies(@RequestBody Species species) {
        return speciesService.updateSpecies(species);
    }
    
    @DeleteMapping("/v1/species/{id}")
    public void deleteSpecies(@PathVariable Long id) {
        speciesService.deleteSpecies(id);
    }
}
