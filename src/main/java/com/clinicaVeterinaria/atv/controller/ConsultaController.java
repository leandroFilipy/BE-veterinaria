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

import com.clinicaVeterinaria.atv.dto.consulta.ConsultaRequest;
import com.clinicaVeterinaria.atv.dto.consulta.ConsultaResponse;
import com.clinicaVeterinaria.atv.service.ConsultaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consultas")
public class ConsultaController {
    

    private final ConsultaService service;

    @PostMapping
    public ResponseEntity<ConsultaResponse> create(@RequestBody ConsultaRequest consultaRequest){
        return ResponseEntity.status(201).body(service.create(consultaRequest));
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> listAll(){
        return ResponseEntity.status(200).body(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> findById(@PathVariable long id){
        return ResponseEntity.status(200).body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponse> update(@PathVariable long id, @RequestBody ConsultaRequest consultaRequest){
        return ResponseEntity.status(200).body(service.update(id, consultaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ConsultaResponse>> findByAnimalNome(@PathVariable String nome){
        return ResponseEntity.status(200).body(service.findConsultaByAnimalNome(nome));
    }

}
