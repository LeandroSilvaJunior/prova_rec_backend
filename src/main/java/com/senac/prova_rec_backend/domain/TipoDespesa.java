package com.senac.prova_rec_backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class TipoDespesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "tipoDespesa")
    @JsonIgnore
    private Set<ContaPagar> contasPagar;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<ContaPagar> getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(Set<ContaPagar> contasPagar) {
        this.contasPagar = contasPagar;
    }
}
