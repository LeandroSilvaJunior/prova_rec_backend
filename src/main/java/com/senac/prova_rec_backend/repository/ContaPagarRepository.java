package com.senac.prova_rec_backend.repository;

import com.senac.prova_rec_backend.domain.ContaPagar;
import com.senac.prova_rec_backend.vo.TotalContasPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContaPagarRepository extends JpaRepository<ContaPagar, Integer> {

    @Query("select new com.senac.prova_rec_backend.vo.TotalContasPagar(cp.tipoDespesa.nome, sum(cp.valor)) "
            + "from ContaPagar cp "
            + "where cp.dataPagamento is null "
            + "group by cp.tipoDespesa.nome "
            + "order by cp.tipoDespesa.nome")
    List<TotalContasPagar> findTotalContasPagar();
}
