package com.slaughterhouse.database.service;

import com.slaughterhouse.database.model.TableAnimal;
import com.slaughterhouse.database.model.TablePart;
import com.slaughterhouse.database.repository.AnimalRepository;
import com.slaughterhouse.database.repository.PartRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    @Autowired
    private PartRepository partRepository;

    public List<TablePart> getAllParts() {
        return partRepository.findAll();
    }

    public Optional<TablePart> getPartById(Long animalId) {
        return partRepository.findById(animalId);
    }

    public TablePart savePart(TablePart tablePart) {
        return partRepository.save(tablePart);
    }

    public void deletePart(Long partId) { partRepository.deleteById(partId);
    }
}
