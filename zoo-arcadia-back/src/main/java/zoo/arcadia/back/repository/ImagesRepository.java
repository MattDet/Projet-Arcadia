package zoo.arcadia.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.Image;

@Repository
public interface ImagesRepository extends JpaRepository<Image, Long> {
    
}
