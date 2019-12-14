package com.senac.prova_rec_backend.controller;

import com.senac.prova_rec_backend.domain.ContaPagar;
import com.senac.prova_rec_backend.domain.Pessoa;
import com.senac.prova_rec_backend.domain.TipoDespesa;
import com.senac.prova_rec_backend.repository.ContaPagarRepository;
import com.senac.prova_rec_backend.repository.PessoaRepository;
import com.senac.prova_rec_backend.repository.TipoDespesaRepository;
import com.senac.prova_rec_backend.vo.TotalContasPagar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contaPagar")
public class ContaPagarController {

    @Autowired
    private ContaPagarRepository contaPagarRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> find(@PathVariable("id") Integer id) {
        Optional<ContaPagar> contaPagar = contaPagarRepository.findById(id);
        if (contaPagar.isPresent()) {
            return ResponseEntity.ok(contaPagar.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid ContaPagar contaPagar) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(contaPagar.getPessoa().getId());
        Optional<TipoDespesa> tipoDespesa = tipoDespesaRepository.findById(contaPagar.getTipoDespesa().getId());

        if (pessoa.isPresent() && tipoDespesa.isPresent()) {
            contaPagar.setPessoa(pessoa.get());
            contaPagar.setTipoDespesa(tipoDespesa.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Pessoa ou Tipo de Despesa não estão cadastrados");
        }

        if (contaPagar.getDataEmissao().isBefore(contaPagar.getDataVencimento())) {
            return ResponseEntity.ok(contaPagarRepository.save(contaPagar));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("A data de vencimento não pode ser maior que a data de emissão");
        }
    }

    @GetMapping("/totalContasPagar")
    public List<TotalContasPagar> findTotalContasPagar() {
        return contaPagarRepository.findTotalContasPagar();
    }
}
