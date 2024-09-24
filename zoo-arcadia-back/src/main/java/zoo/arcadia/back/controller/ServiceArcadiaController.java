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
import zoo.arcadia.back.entity.ServiceArcadia;
import zoo.arcadia.back.service.ServiceArcadiaService;


@RestController
@RequiredArgsConstructor
public class ServiceArcadiaController {
    
    private final ServiceArcadiaService serviceArcadiaService;

    @GetMapping("/v1/services")
    public List<ServiceArcadia> findAll() {
        return serviceArcadiaService.findAll();
    }

    @GetMapping("/v1/services/{id}")
    public ServiceArcadia findById(@PathVariable Long id) {
        return serviceArcadiaService.findById(id);
    }

    @GetMapping("/v1/services/name/{name}")
    public ServiceArcadia findByName(@PathVariable String name) {
        return serviceArcadiaService.findByName(name);
    }

    @PostMapping("/v1/services")
    public ServiceArcadia createService(@RequestBody ServiceArcadia serviceArcadia) {
        return serviceArcadiaService.createService(serviceArcadia);
    }

    @PutMapping("/v1/services")
    public ServiceArcadia updateService(@RequestBody ServiceArcadia serviceArcadia) {
        return serviceArcadiaService.updateService(serviceArcadia);
    }

    @DeleteMapping("/v1/services/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceArcadiaService.deleteService(id);
    }
}
