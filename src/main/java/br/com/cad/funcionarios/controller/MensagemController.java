package br.com.cad.funcionarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/msg")
public class MensagemController {

    @GetMapping
    public ResponseEntity<String> msg(){
        return ResponseEntity.ok("Oi, eu sou Goku!");
    }
}
