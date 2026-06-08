package com.clinicaVeterinaria.atv.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.clinicaVeterinaria.atv.dto.consulta.ConsultaRequest;
import com.clinicaVeterinaria.atv.dto.consulta.ConsultaResponse;
import com.clinicaVeterinaria.atv.mapper.ConsultaMapper;
import com.clinicaVeterinaria.atv.model.Animal;
import com.clinicaVeterinaria.atv.model.Consulta;
import com.clinicaVeterinaria.atv.repository.AnimalRepository;
import com.clinicaVeterinaria.atv.repository.ConsultaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ConsultaService {
    

    private final ConsultaMapper mapper;
    private final ConsultaRepository repository;
    private final AnimalRepository animalRepository;


    public ConsultaResponse create(ConsultaRequest consultaRequest){
        Animal animal = animalRepository.findById(consultaRequest.idAnimal()).orElseThrow(()-> new RuntimeException());
        Consulta consulta = mapper.toEntity(consultaRequest);
        consulta.setAnimal(animal);
        Consulta consultaSalva = repository.save(consulta);
        ConsultaResponse consultaResponse = mapper.toResponse(consultaSalva);
        return consultaResponse;
    }

    public List<ConsultaResponse> listAll(){
        List<Consulta> consultas = repository.findAll();
        List<ConsultaResponse> dto = new ArrayList<>();

        for(Consulta c: consultas){
            dto.add(mapper.toResponse(c));
        }
        return dto;
    }

    public ConsultaResponse findById(long id){
        Consulta consulta = repository.findById(id).orElseThrow(()-> new RuntimeException());
        ConsultaResponse consultaResponse = mapper.toResponse(consulta);
        return consultaResponse;
    }

    public ConsultaResponse update(long id, ConsultaRequest consultaRequest){
        Animal animal = animalRepository.findById(consultaRequest.idAnimal()).orElseThrow(()-> new RuntimeException());
        Consulta consulta = repository.findById(id).orElseThrow(()-> new RuntimeException());
        consulta.setDataConsulta(consultaRequest.dataConsulta());
        consulta.setDescricao(consultaRequest.descricao());
        consulta.setValorConsulta(consultaRequest.valorConsulta());
        consulta.setRetorno(consultaRequest.retorno());
        consulta.setAnimal(animal);
        Consulta consultaSalva = repository.save(consulta);
        ConsultaResponse consultaResponse = mapper.toResponse(consultaSalva);
        return consultaResponse;
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public List<ConsultaResponse> findConsultaByAnimalNome (String nome){
        List<Consulta> consultas = repository.findConsultaByAnimalNome(nome);
        List<ConsultaResponse> dto = new ArrayList<>();

        for(Consulta c: consultas){
            dto.add(mapper.toResponse(c));
        }
        return dto;
    }

}
