package zoo.arcadia.back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import zoo.arcadia.back.entity.VeterinaryReport;
import zoo.arcadia.back.service.VeterinaryReportService;

@RestController
@RequiredArgsConstructor
public class VeterinaryReportController {
    
    private final VeterinaryReportService veterinaryReportService;

    @GetMapping("/v1/veterinary-reports")
    public List<VeterinaryReport> findAll() {
        return veterinaryReportService.findAll();
    }

    @GetMapping("/v1/veterinary-reports/{id}")
    public VeterinaryReport findById(@PathVariable Long id) {
        return veterinaryReportService.findById(id);
    }

    @GetMapping("/v1/veterinary-reports/animal/{animalId}")
    public List<VeterinaryReport> findAllByAnimalId(@PathVariable Long animalId) {
        return veterinaryReportService.findAllByAnimalId(animalId);
    }

    @GetMapping("/v1/veterinary-reports/user/{userId}")
    public List<VeterinaryReport> findAllByUserId(@PathVariable Long userId) {
        return veterinaryReportService.findAllByUserId(userId);
    }

    @PostMapping("/v1/veterinary-reports")
    public VeterinaryReport createVeterinaryReport(@RequestBody VeterinaryReport veterinaryReport) {
        return veterinaryReportService.createVeterinaryReport(veterinaryReport);
    }

    @PutMapping("/v1/veterinary-reports")
    public VeterinaryReport updateVeterinaryReport(@RequestBody VeterinaryReport veterinaryReport) {
        return veterinaryReportService.updateVeterinaryReport(veterinaryReport);
    }

    @DeleteMapping("/v1/veterinary-reports/{id}")
    public void deleteVeterinaryReport(@PathVariable Long id) {
        veterinaryReportService.deleteVeterinaryReport(id);
    }
}
