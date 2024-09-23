package zoo.arcadia.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    
}
