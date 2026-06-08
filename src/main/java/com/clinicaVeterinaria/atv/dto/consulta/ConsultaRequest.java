package com.clinicaVeterinaria.atv.dto.consulta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ConsultaRequest (
    LocalDate dataConsulta,
    String descricao,
    BigDecimal valorConsulta,
    String retorno,
    long idAnimal
){
}
