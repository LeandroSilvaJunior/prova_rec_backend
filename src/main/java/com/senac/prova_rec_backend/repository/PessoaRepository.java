package com.senac.prova_rec_backend.repository;

import com.senac.prova_rec_backend.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
