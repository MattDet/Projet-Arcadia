package zoo.arcadia.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.Species;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    
        Optional<Species> findByName(String name);

}
