package zoo.arcadia.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.Habitat;

@Repository
public interface HabitatRepository extends JpaRepository<Habitat, Long> {
    
    Optional<Habitat> findByName(String name);
}
