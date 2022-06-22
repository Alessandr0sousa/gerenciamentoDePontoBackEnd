package br.com.cad.funcionarios.controller;

import br.com.cad.funcionarios.dto.FuncionariosDto;
import br.com.cad.funcionarios.model.Funcionarios;
import br.com.cad.funcionarios.service.FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionariosController {
    @Autowired
    private FuncionariosService funcionariosService;

    @PostMapping
    public ResponseEntity<Funcionarios> cadastrarFuncionario(@RequestBody(required = true) @Valid FuncionariosDto dto, UriComponentsBuilder uriBuilder) {
        return funcionariosService.cadastrar(dto, uriBuilder);

    }

    @GetMapping
    public ResponseEntity<List<Funcionarios>> listarFuncionario() {
        return funcionariosService.buscar(null);
    }

    @GetMapping
    public ResponseEntity<List<Funcionarios>> listarFuncionarioId(@PathVariable(required = false) Long id) {
        return funcionariosService.buscar(id);
    }
}
