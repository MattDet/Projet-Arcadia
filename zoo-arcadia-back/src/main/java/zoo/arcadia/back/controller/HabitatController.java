package zoo.arcadia.back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zoo.arcadia.back.entity.Habitat;
import zoo.arcadia.back.service.HabitatService;

@RestController
@RequiredArgsConstructor
public class HabitatController {
    
    private final HabitatService habitatService;

    @GetMapping("/v1/habitats")
    public List<Habitat> findAll() {
        return habitatService.findAll();
    }

    @GetMapping("/v1/habitats/{id}")
    public Habitat findById(Long id) {
        return habitatService.findById(id);
    }

    @GetMapping("/v1/habitats/name/{name}")
    public Habitat findByName(String name) {
        return habitatService.findByName(name);
    }

    @PostMapping("/v1/habitats")
    public Habitat createHabitat(Habitat habitat) {
        return habitatService.createHabitat(habitat);
    }

    @PutMapping("/v1/habitats")
    public Habitat updateHabitat(Habitat habitat) {
        return habitatService.updateHabitat(habitat);
    }

    @DeleteMapping("/v1/habitats/{id}")
    public void deleteHabitat(Long id) {
        habitatService.deleteHabitat(id);
    }

}
