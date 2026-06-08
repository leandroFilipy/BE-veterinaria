package com.clinicaVeterinaria.atv.dto.animal;

import java.util.List;

import com.clinicaVeterinaria.atv.dto.consulta.ConsultaResponse;

public record AnimalResponse (
    long id,
    String nome,
    String especie,
    boolean ativo,
    List<ConsultaResponse> consultas
){
}
