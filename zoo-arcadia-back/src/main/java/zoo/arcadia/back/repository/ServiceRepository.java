package zoo.arcadia.back.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.ServiceArcadia;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceArcadia, Long> {
    
}
