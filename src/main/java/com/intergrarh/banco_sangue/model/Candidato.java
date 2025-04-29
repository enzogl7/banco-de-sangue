package com.intergrarh.banco_sangue.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {
    private String nome;
    private String sexo;
    private String estado;
    private double peso;
    private double altura;
    private String dataNasc;
    private String tipoSanguineo;
}
