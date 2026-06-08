package com.clinicaVeterinaria.atv.mapper;

import org.springframework.stereotype.Component;

import com.clinicaVeterinaria.atv.dto.animal.AnimalResume;
import com.clinicaVeterinaria.atv.dto.consulta.ConsultaRequest;
import com.clinicaVeterinaria.atv.dto.consulta.ConsultaResponse;
import com.clinicaVeterinaria.atv.model.Consulta;

@Component
public class ConsultaMapper {
    

    public Consulta toEntity(ConsultaRequest consultaRequest){
        return new Consulta(
            consultaRequest.dataConsulta(),
            consultaRequest.descricao(),
            consultaRequest.valorConsulta(),
            consultaRequest.retorno()
        );
    }

    public ConsultaResponse toResponse(Consulta consulta){
        return new ConsultaResponse(
            consulta.getId(),
            consulta.getDataConsulta(),
            consulta.getDescricao(),
            consulta.getValorConsulta(),
            consulta.getRetorno(),
            new AnimalResume(
                consulta.getAnimal().getId(),
                consulta.getAnimal().getNome(),
                consulta.getAnimal().getEspecie(),
                consulta.getAnimal().isAtivo()
            )
        );
    }
}
