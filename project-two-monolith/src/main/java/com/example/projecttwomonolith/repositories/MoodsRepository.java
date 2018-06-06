package com.example.projecttwomonolith.repositories;
import com.example.projecttwomonolith.models.Mood;
import org.springframework.data.repository.CrudRepository;

public interface MoodsRepository extends CrudRepository<Mood, Long> {

}