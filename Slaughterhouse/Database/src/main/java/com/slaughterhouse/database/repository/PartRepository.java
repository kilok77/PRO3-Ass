package com.slaughterhouse.database.repository;

import com.slaughterhouse.database.model.TableAnimal;
import com.slaughterhouse.database.model.TablePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<TablePart, Long> {
    // You can add custom query methods here if needed
}
