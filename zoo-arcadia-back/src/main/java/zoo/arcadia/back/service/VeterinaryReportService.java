package zoo.arcadia.back.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import zoo.arcadia.back.entity.VeterinaryReport;
import zoo.arcadia.back.repository.VeterinaryReportRepository;

@Log4j2
@Service
@RequiredArgsConstructor
public class VeterinaryReportService {
    
    private final VeterinaryReportRepository veterinaryReportRepository;

    public List<VeterinaryReport> findAll() {
        log.info("Find all veterinary reports");
        return veterinaryReportRepository.findAll();
    }

    public VeterinaryReport findById(Long id) {
        return veterinaryReportRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Veterinary report not found"));
    }

    public List<VeterinaryReport> findAllByAnimalId(Long animalId) {
        return veterinaryReportRepository.findAllByAnimalId(animalId);
    }

    public List<VeterinaryReport> findAllByUserId(Long userId) {
        return veterinaryReportRepository.findAllByUserId(userId);
    }

    public VeterinaryReport createVeterinaryReport(VeterinaryReport veterinaryReport) {
        veterinaryReport.setId(null);
        return veterinaryReportRepository.save(veterinaryReport);
    }

    public VeterinaryReport updateVeterinaryReport(VeterinaryReport veterinaryReport) {
        if (veterinaryReport.getId() != null && veterinaryReportRepository.existsById(veterinaryReport.getId())) {
            return veterinaryReportRepository.save(veterinaryReport);
        }
        throw new IllegalArgumentException("Veterinary report not found");
    }

    public void deleteVeterinaryReport(Long id) {
        if (veterinaryReportRepository.existsById(id)) {
            veterinaryReportRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Veterinary report not found");
        }
    }
}
