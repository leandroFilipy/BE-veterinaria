package com.clinicaVeterinaria.atv.mapper;

import org.springframework.stereotype.Component;

import com.clinicaVeterinaria.atv.dto.animal.AnimalRequest;
import com.clinicaVeterinaria.atv.dto.animal.AnimalResponse;
import com.clinicaVeterinaria.atv.model.Animal;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AnimalMapper {

    private final ConsultaMapper consultaMapper;

    public Animal toEntity (AnimalRequest animalRequest){
        return new Animal(
            animalRequest.nome(),
            animalRequest.especie(),
            animalRequest.ativo()
        );
    }

    public AnimalResponse toResponse(Animal animal){
        return new AnimalResponse(
            animal.getId(),
            animal.getNome(),
            animal.getEspecie(),
            animal.isAtivo(),
            animal.getConsultas() != null? animal.getConsultas().stream().map(consultaMapper::toResponse).toList(): null
        );
    }
    
}
