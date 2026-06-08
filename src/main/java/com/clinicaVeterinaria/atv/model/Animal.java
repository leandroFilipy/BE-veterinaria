package com.clinicaVeterinaria.atv.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String especie;
    private boolean ativo;

    @OneToMany(mappedBy="animal")
    private List<Consulta> consultas = new ArrayList<>();
    
    public Animal(String nome, String especie, boolean ativo){
        this.nome = nome;
        this.especie=especie;
        this.ativo=ativo;
    }

}
