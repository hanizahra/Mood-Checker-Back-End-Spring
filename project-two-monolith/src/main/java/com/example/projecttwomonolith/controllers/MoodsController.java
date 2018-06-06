package com.example.projecttwomonolith.controllers;

import com.example.projecttwomonolith.models.Mood;
import com.example.projecttwomonolith.repositories.MoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;



@RestController
public class MoodsController {

    @Autowired
    private MoodsRepository moodsRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/moods")
    public Iterable<Mood> findAllMoods() {
        return moodsRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/moods/{moodId}")
    public Optional<Mood> findMoodById(@PathVariable Long moodId) {
        return moodsRepository.findById(moodId);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/moods/{moodId}")
    public HttpStatus deleteMoodById(@PathVariable Long moodId) {
        moodsRepository.deleteById(moodId);
        return HttpStatus.OK;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/moods")
    public Mood createNewMood(@RequestBody Mood newMood) {
        return moodsRepository.save(newMood);
    }

    @CrossOrigin(origins = "*")
    @PatchMapping("/moods/{moodId}")
    public Mood updateMoodById(@PathVariable Long moodId, @RequestBody Mood moodRequest) {

        Mood moodFromDb = moodsRepository.findById(moodId).get();

        moodFromDb.setUserInput(moodRequest.getUserInput());
        moodFromDb.setApiOutput(moodRequest.getApiOutput());
        moodFromDb.setNote(moodRequest.getNote());

        return moodsRepository.save(moodFromDb);
    }

}
