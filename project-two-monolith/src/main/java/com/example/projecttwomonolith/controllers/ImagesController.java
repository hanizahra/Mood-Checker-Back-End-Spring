package com.example.projecttwomonolith.controllers;
import com.example.projecttwomonolith.models.Image;
import com.example.projecttwomonolith.repositories.ImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ImagesController {

    @Autowired
    private ImagesRepository imagesRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/images")
    public Iterable<Image> findAllImages() {
        return imagesRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/images/{imageId}")
    public Optional<Image> findImageById(@PathVariable Long imageId) {
        return imagesRepository.findById(imageId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/images/{imageId}")
    public HttpStatus deleteImageById(@PathVariable Long imageId) {
        imagesRepository.deleteById(imageId);
        return HttpStatus.OK;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/images")
    public Image createNewImage(@RequestBody Image newImage) {
        return imagesRepository.save(newImage);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PatchMapping("/images/{imageId}")
    public Image updateImageById(@PathVariable Long imageId, @RequestBody Image imageRequest) {

        Image imageFromDb = imagesRepository.findById(imageId).get();

        imageFromDb.setOriginalImage(imageRequest.getOriginalImage());
        imageFromDb.setColorizedImage(imageRequest.getColorizedImage());
        imageFromDb.setNote(imageRequest.getNote());

        return imagesRepository.save(imageFromDb);
    }



}