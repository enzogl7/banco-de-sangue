package com.intergrarh.banco_sangue.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "tipo_sanguineo")
@Table(name = "tipos_sanguineos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoSanguineo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;

    @ManyToMany
    @JoinTable(name = "doacoes_possiveis", joinColumns = @JoinColumn(name = "doador_id"), inverseJoinColumns = @JoinColumn(name = "receptor_id"))
    private Set<TipoSanguineo> podeDoarPara;

    @ManyToMany
    @JoinTable(name = "recebimentos_possiveis", joinColumns = @JoinColumn(name = "receptor_id"), inverseJoinColumns = @JoinColumn(name = "doador_id"))
    private Set<TipoSanguineo> podeReceberDe;
}

