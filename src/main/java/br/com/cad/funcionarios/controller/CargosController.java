package br.com.cad.funcionarios.controller;

import br.com.cad.funcionarios.dto.CargosDto;
import br.com.cad.funcionarios.model.Cargos;
import br.com.cad.funcionarios.service.CargosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargosController {

    @Autowired
    private CargosService cargosService;

    @PostMapping
    @Transactional
    private ResponseEntity<Cargos> CadastrarCargos(@RequestBody @Valid CargosDto dto, UriComponentsBuilder uriBuilder) {
        return cargosService.cadastrar(dto, uriBuilder);
    }

    @GetMapping
    private ResponseEntity<List<Cargos>> listarCargos() {
        return cargosService.buscar(null);
    }

    @GetMapping("/{id}")
    private ResponseEntity<List<Cargos>> listarCargosId(@PathVariable(required = false) Long id) {
        return cargosService.buscar(id);
    }


}
