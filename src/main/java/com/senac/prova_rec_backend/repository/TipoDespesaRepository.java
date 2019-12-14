package com.senac.prova_rec_backend.repository;

import com.senac.prova_rec_backend.domain.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer> {
}
