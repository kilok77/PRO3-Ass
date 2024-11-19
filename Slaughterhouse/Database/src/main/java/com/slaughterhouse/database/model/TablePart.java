package com.slaughterhouse.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class TablePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;  // Unique identifier for the part
    private String partType;  // Type of the part (e.g., "Steak", "Ribs")
    private Double partWeight;  // Weight of the part

    private Long animalId;  // The animal that the part came from (Many parts can come from one animal)

    // Getters and setters
    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getPartType() {
        return partType;
    }

    public void setPartType(String partType) {
        this.partType = partType;
    }

    public Double getPartWeight() {
        return partWeight;
    }

    public void setPartWeight(Double partWeight) {
        this.partWeight = partWeight;
    }

    public Long getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Long animalId) {
        this.animalId = animalId;
    }
}

