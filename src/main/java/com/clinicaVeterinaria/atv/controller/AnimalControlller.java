package com.clinicaVeterinaria.atv.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinicaVeterinaria.atv.dto.animal.AnimalRequest;
import com.clinicaVeterinaria.atv.dto.animal.AnimalResponse;
import com.clinicaVeterinaria.atv.service.AnimalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/animais")
@RequiredArgsConstructor
public class AnimalControlller {
    

    private final AnimalService service;


    @PostMapping
    public ResponseEntity<AnimalResponse> create(@RequestBody AnimalRequest animalRequest){
        return ResponseEntity.status(201).body(service.create(animalRequest));
    }

    @GetMapping
    public ResponseEntity<List<AnimalResponse>> listAll(){
        return ResponseEntity.status(200).body(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalResponse> findById(@PathVariable long id){
        return ResponseEntity.status(200).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalResponse> update(@PathVariable long id, @RequestBody AnimalRequest animalRequest){
        return ResponseEntity.status(200).body(service.update(id, animalRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.status(204).build();
    }


}
