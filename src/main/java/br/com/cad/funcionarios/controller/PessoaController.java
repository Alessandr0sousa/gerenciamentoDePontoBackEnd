package br.com.cad.funcionarios.controller;

import br.com.cad.funcionarios.dto.CargosDto;
import br.com.cad.funcionarios.dto.PessoasDto;
import br.com.cad.funcionarios.model.Pessoas;
import br.com.cad.funcionarios.service.PessoasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoasService pessoasService;
    @PostMapping
    @Transactional
    private ResponseEntity<Pessoas> cadastrarPessoa(@RequestBody(required = true) @Valid PessoasDto dto, UriComponentsBuilder uriBuilder){
        return pessoasService.cadastrar(dto, uriBuilder);
    }
    @GetMapping
    private ResponseEntity<List<Pessoas>> listarPessoas(){
        return pessoasService.listar(null);
    }
    @GetMapping("/{id}")
    private ResponseEntity<List<Pessoas>> listarPessoasId(@PathVariable(required = false) Long id){
        return pessoasService.listar(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pessoas> alterarPessoas(@PathVariable(required = true) Long id, @RequestBody(required = true) @Valid PessoasDto dto){
        return pessoasService.alterarPessoa(id, dto);
    }

}
