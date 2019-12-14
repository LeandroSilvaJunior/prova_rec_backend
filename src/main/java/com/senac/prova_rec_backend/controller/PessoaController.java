package com.senac.prova_rec_backend.controller;

import com.senac.prova_rec_backend.domain.Pessoa;
import com.senac.prova_rec_backend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    @CrossOrigin
    public List<Pessoa> find() {
        return pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody @Valid Pessoa pessoa) {
        if (pessoa.getNome().equals("")||  pessoa.getNome().equals(null)) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("O nome é obrigatorio");
        } else {
            return ResponseEntity.ok(pessoaRepository.save(pessoa));
        }
    }
}
