package com.clinicaVeterinaria.atv.dto.animal;

public record AnimalRequest(
    String nome,
    String especie,
    boolean ativo
) {
}
