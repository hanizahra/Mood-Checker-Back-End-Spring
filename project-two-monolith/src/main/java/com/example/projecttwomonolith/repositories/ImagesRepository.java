package com.example.projecttwomonolith.repositories;
import com.example.projecttwomonolith.models.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImagesRepository extends CrudRepository<Image, Long> {

}