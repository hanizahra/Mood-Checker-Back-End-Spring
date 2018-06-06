package com.example.projecttwomonolith.repositories;

import com.example.projecttwomonolith.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}