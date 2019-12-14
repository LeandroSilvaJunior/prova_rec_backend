package com.senac.prova_rec_backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "pessoa")
    @JsonIgnore
    private List<ContaPagar> contasPagar;

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

    public List<ContaPagar> getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(List<ContaPagar> contasPagar) {
        this.contasPagar = contasPagar;
    }
}
