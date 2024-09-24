package zoo.arcadia.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zoo.arcadia.back.entity.VeterinaryReport;

@Repository
public interface VeterinaryReportRepository extends JpaRepository<VeterinaryReport, Long> {
    
    List<VeterinaryReport> findAllByAnimalId(Long animalId);

    List<VeterinaryReport> findAllByUserId(Long userId);
}
