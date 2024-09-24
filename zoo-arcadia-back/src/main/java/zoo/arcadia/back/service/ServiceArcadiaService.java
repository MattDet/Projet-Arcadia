package zoo.arcadia.back.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import zoo.arcadia.back.entity.ServiceArcadia;
import zoo.arcadia.back.repository.ServiceArcadiaRepository;

@Log4j2
@Service
@RequiredArgsConstructor
@Repository
public class ServiceArcadiaService {

    private final ServiceArcadiaRepository serviceArcadiaRepository;
    
    public List<ServiceArcadia> findAll() {
        log.info("Find all services");
        return serviceArcadiaRepository.findAll();
    }

    public ServiceArcadia findById(Long id) {
        return serviceArcadiaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Service not found"));
    }

    public ServiceArcadia findByName(String name) {
        return serviceArcadiaRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("Service not found"));
    }

    public ServiceArcadia createService(ServiceArcadia serviceArcadia) {
        serviceArcadia.setId(null);
        return serviceArcadiaRepository.save(serviceArcadia);
    }

    public ServiceArcadia updateService(ServiceArcadia serviceArcadia) {
        if (serviceArcadia.getId() != null && serviceArcadiaRepository.existsById(serviceArcadia.getId())) {
            return serviceArcadiaRepository.save(serviceArcadia);
        }
        throw new IllegalArgumentException("Service not found");
    }

    public void deleteService(Long id) {
        if (serviceArcadiaRepository.existsById(id)) {
            serviceArcadiaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Service not found");
        }
    }
}
