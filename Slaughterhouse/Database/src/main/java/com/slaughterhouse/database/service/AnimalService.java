package com.slaughterhouse.database.service;

import com.slaughterhouse.database.model.TableAnimal;
import com.slaughterhouse.database.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<TableAnimal> getAllAnimals() {
        return animalRepository.findAll();
    }
    public List<TableAnimal> getAnimalsByOrigin(String origin) {
        return animalRepository.findAnimalsByOrigin(origin);
    }

    public Optional<TableAnimal> getAnimalById(Long animalId) {
        return animalRepository.findById(animalId);
    }

    public TableAnimal saveAnimal(TableAnimal tableAnimal) {
        return animalRepository.save(tableAnimal);
    }

    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }


}
