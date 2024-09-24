package zoo.arcadia.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.Image;

@Repository
public interface ImagesRepository extends JpaRepository<Image, Long> {

    List<Image> findAllByAnimalId(Long animalId);

    List<Image> findAllByHabitatId(Long habitatId);

    List<Image> findAllByServiceId(Long serviceId);
    
}
