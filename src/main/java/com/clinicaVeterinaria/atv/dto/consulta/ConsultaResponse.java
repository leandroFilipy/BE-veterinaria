package com.clinicaVeterinaria.atv.dto.consulta;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.clinicaVeterinaria.atv.dto.animal.AnimalResume;

public record ConsultaResponse(
    long id,
    LocalDate dataConsulta,
    String descricao,
    BigDecimal valorConsulta,
    String retorno,
    AnimalResume consulta
) {
    
}
