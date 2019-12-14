package com.senac.prova_rec_backend.controller;

import com.senac.prova_rec_backend.domain.Pessoa;
import com.senac.prova_rec_backend.domain.TipoDespesa;
import com.senac.prova_rec_backend.repository.TipoDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tipoDespesa")
public class TipoDespesaController {

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;

    @GetMapping
    @CrossOrigin
    public List<TipoDespesa> find() {
        return tipoDespesaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid TipoDespesa tipoDespesa) {
        if (tipoDespesa.getNome().equals("") || tipoDespesa.getNome().equals(null)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("O nome é obrigatorio");
        } else {
            return ResponseEntity.ok(tipoDespesaRepository.save(tipoDespesa));
        }
    }
}
