package zoo.arcadia.back.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.ServiceArcadia;

@Repository
public interface ServiceArcadiaRepository extends JpaRepository<ServiceArcadia, Long> {

        Optional<ServiceArcadia> findByName(String name);
}
