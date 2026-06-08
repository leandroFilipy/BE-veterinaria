package com.clinicaVeterinaria.atv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clinicaVeterinaria.atv.dto.animal.AnimalRequest;
import com.clinicaVeterinaria.atv.dto.animal.AnimalResponse;
import com.clinicaVeterinaria.atv.mapper.AnimalMapper;
import com.clinicaVeterinaria.atv.model.Animal;
import com.clinicaVeterinaria.atv.repository.AnimalRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnimalService {
    

    private final AnimalMapper mapper;
    private final AnimalRepository repository;


    public AnimalResponse create(AnimalRequest animalRequest){
        Animal animal = mapper.toEntity(animalRequest);
        Animal animalSalvo = repository.save(animal);
        AnimalResponse animalResponse = mapper.toResponse(animalSalvo);
        return animalResponse;
    }

    public List<AnimalResponse> listAll(){
        List<Animal> animais = repository.findAll();
        List<AnimalResponse> dto = new ArrayList<>();

        for(Animal a: animais){
            dto.add(mapper.toResponse(a));
        }
        return dto;
    }

    public AnimalResponse findById(long id){
        Animal animal = repository.findById(id).orElseThrow(() -> new RuntimeException());
        AnimalResponse animalResponse = mapper.toResponse(animal);
        return animalResponse;
    }

    public AnimalResponse update(long id, AnimalRequest animalRequest){
        Animal animal = repository.findById(id).orElseThrow(()-> new RuntimeException());
        animal.setNome(animalRequest.nome());
        animal.setEspecie(animalRequest.especie());
        animal.setAtivo(animalRequest.ativo());
        Animal animalSalvo = repository.save(animal);
        AnimalResponse animalResponse = mapper.toResponse(animalSalvo);
        return animalResponse;
    }

    public void delete(long id){
        repository.deleteById(id);
    }

}
