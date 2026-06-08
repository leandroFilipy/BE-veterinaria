package com.clinicaVeterinaria.atv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clinicaVeterinaria.atv.model.Animal;

@Repository
public interface  AnimalRepository extends JpaRepository<Animal, Long>{
    
    
}
