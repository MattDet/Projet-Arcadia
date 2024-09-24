package zoo.arcadia.back.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import zoo.arcadia.back.common.ImageEnum;
import zoo.arcadia.back.entity.Image;
import zoo.arcadia.back.service.ImageService;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/v1/images")
    public List<Image> findAll() {
        return imageService.findAll();
    }

    @GetMapping("/v1/images/{id}")
    public Image findById(@PathVariable Long id) {
        return imageService.findById(id);
    }

    @GetMapping(value = "/v1/images/{id}/display", produces = "image/jpeg")
    public @ResponseBody byte[] display(@PathVariable Long id) {
        return imageService.display(id);
    }

    @GetMapping("/v1/images/animal/{animalId}")
    public List<Image> findAllByAnimalId(@PathVariable Long animalId) {
        return imageService.findAllByAnimalId(animalId);
    }

    @GetMapping("/v1/images/habitat/{habitatId}")
    public List<Image> findAllByHabitatId(@PathVariable Long habitatId) {
        return imageService.findAllByHabitatId(habitatId);
    }

    @GetMapping("/v1/images/service/{serviceId}")
    public List<Image> findAllByServiceId(@PathVariable Long serviceId) {
        return imageService.findAllByServiceId(serviceId);
    }

    @PostMapping(value = "/v1/images/{type}/{id}", consumes = "multipart/form-data")
    public Image createImage(@RequestPart("file") MultipartFile file, @PathVariable ImageEnum type,
            @PathVariable Long id) {
        return imageService.createImage(file, type, id);
    }

    @PutMapping("/v1/images")
    public Image updateImage(@RequestBody Image image) {
        return imageService.updateImage(image);
    }

    @DeleteMapping("/v1/images/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}
