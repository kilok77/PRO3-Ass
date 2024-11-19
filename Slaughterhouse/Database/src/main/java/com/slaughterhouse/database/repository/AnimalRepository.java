package com.slaughterhouse.database.repository;

import com.slaughterhouse.database.model.TableAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<TableAnimal, Long> {

    // Custom query using @Query annotation
    @Query("SELECT a FROM TableAnimal a WHERE a.origin = ?1")
    List<TableAnimal> findAnimalsByOrigin(String origin);
}
