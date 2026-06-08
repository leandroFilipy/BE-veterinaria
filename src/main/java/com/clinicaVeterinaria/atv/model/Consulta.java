package com.clinicaVeterinaria.atv.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private LocalDate dataConsulta;
    private String descricao;
    private BigDecimal valorConsulta;
    private String retorno;

    @ManyToOne
    private Animal animal;

    public Consulta(LocalDate dataConsulta, String descricao, BigDecimal valorConsulta, String retorno){
        this.dataConsulta=dataConsulta;
        this.descricao=descricao;
        this.valorConsulta=valorConsulta;
        this.retorno=retorno;
    }
}
