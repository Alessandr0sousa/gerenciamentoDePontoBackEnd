package br.com.cad.funcionarios.controller;

import br.com.cad.funcionarios.dto.JornadaTrabalhoDto;
import br.com.cad.funcionarios.model.JornadaTrabalho;
import br.com.cad.funcionarios.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController @RequestMapping("/jornada")
public class JornadaTrabalhoController {
    @Autowired
    private JornadaTrabalhoService jornadaTrabalhoService;

    @PostMapping
    @Transactional
    public ResponseEntity<JornadaTrabalho> cadastrarJornada(@RequestBody @Valid JornadaTrabalhoDto dto, UriComponentsBuilder uriBuilder) {
        return jornadaTrabalhoService.cadastrar(dto, uriBuilder);
    }

    @GetMapping
    public ResponseEntity<List<JornadaTrabalho>> listarJornadas(){
        return jornadaTrabalhoService.listar(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<JornadaTrabalho>> listarJornadasId(@PathVariable(required = false) Long id){
        return jornadaTrabalhoService.listar(id);
    }
}
