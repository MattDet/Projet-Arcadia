package zoo.arcadia.back.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Optional<Animal> findByName(String name);

    List<Animal> findAllBySpeciesId(Long speciesId);

    List<Animal> findAllByHabitatId(Long habitatId);

}
