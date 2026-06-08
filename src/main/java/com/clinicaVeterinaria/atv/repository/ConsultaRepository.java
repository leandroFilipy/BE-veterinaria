package com.clinicaVeterinaria.atv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinicaVeterinaria.atv.model.Consulta;

@Repository
public interface  ConsultaRepository extends JpaRepository<Consulta, Long>{

    @Query("SELECT c FROM Consulta c WHERE c.animal.nome = :nome")
    List<Consulta> findConsultaByAnimalNome(@Param("nome") String nome);

    
}
