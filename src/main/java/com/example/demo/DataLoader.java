package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    DirectorRepository directorRepository;
    @Override
    public void run(String... args) throws Exception {
        Director director = new Director();
        director.setName("Eyob");
        director.setGenre("Drama");
        directorRepository.save(director);

        director = new Director();
        director.setName("Amenu");
        director.setGenre("Action");
        directorRepository.save(director);
    }
}
