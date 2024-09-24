package zoo.arcadia.back.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import zoo.arcadia.back.common.ImageEnum;
import zoo.arcadia.back.entity.Animal;
import zoo.arcadia.back.entity.Habitat;
import zoo.arcadia.back.entity.Image;
import zoo.arcadia.back.entity.ServiceArcadia;
import zoo.arcadia.back.repository.ImagesRepository;

@Log4j2
@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImagesRepository imagesRepository;
    private final AnimalService animalService;
    private final HabitatService habitatService;
    private final ServiceArcadiaService serviceArcadiaService;

    @Value("${arcadia.zoo.repository}")
    private String repository;

    public List<Image> findAll() {
        log.info("Find all images");
        return imagesRepository.findAll();
    }

    public Image findById(Long id) {
        return imagesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Image not found"));
    }

    public List<Image> findAllByAnimalId(Long animalId) {
        return imagesRepository.findAllByAnimalId(animalId);
    }

    public List<Image> findAllByHabitatId(Long habitatId) {
        return imagesRepository.findAllByHabitatId(habitatId);
    }

    public List<Image> findAllByServiceId(Long serviceId) {
        return imagesRepository.findAllByServiceId(serviceId);
    }

    public byte[] display(Long id) {
        Image image = findById(id);
        try {
            return Files.readAllBytes(Paths.get(image.getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Image createImage(MultipartFile image, ImageEnum imageEnum, Long id) {
        String imagePath = repository + File.separator + UUID.randomUUID().toString();
        try (OutputStream outputStream = new FileOutputStream(
                new File(imagePath))) {
            IOUtils.copy(image.getInputStream(), outputStream);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        switch (imageEnum) {
            case service:
                ServiceArcadia serviceArcadia = serviceArcadiaService.findById(id);
                return imagesRepository
                        .save(new Image(null, imagePath, image.getOriginalFilename(), null, null, serviceArcadia));

            case animal:
                Animal animal = animalService.findById(id);
                return imagesRepository
                        .save(new Image(null, imagePath, image.getOriginalFilename(), animal, null, null));

            case habitat:
                Habitat habitat = habitatService.findById(id);
                return imagesRepository
                        .save(new Image(null, imagePath, image.getOriginalFilename(), null, habitat, null));

            default:
                throw new IllegalArgumentException("Image type not found");
        }
    }

    public Image updateImage(Image image) {
        if (image.getId() != null && imagesRepository.existsById(image.getId())) {
            return imagesRepository.save(image);
        }
        throw new IllegalArgumentException("Image not found");
    }

    public void deleteImage(Long id) {
        log.info("Deleting image with id {}", id);

        // Rechercher l'image en base
        Image image = imagesRepository.findById(id).orElse(null);

        if (image != null) {
            log.info("Image found: {} (file name: {})", id, image.getPath());

            // Supprimer le fichier physique sur le disque
            try {
                Files.deleteIfExists(Paths.get(image.getPath()));
                log.info("File {} deleted successfully", image.getPath());
            } catch (IOException e) {
                log.error("Error during file deletion for image id {}, error: {}", id, e.getMessage());
                throw new RuntimeException("File deletion failed: " + e.getMessage());
            }

            // Supprimer l'enregistrement en base
            imagesRepository.deleteById(id);
            log.info("Image record with id {} deleted from database", id);
        } else {
            log.warn("Image with id {} not found, nothing to delete", id);
        }
    }
}
