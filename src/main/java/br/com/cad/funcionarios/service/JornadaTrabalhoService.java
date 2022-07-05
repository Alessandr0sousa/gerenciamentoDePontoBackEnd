package br.com.cad.funcionarios.service;

import br.com.cad.funcionarios.dto.JornadaTrabalhoDto;
import br.com.cad.funcionarios.model.JornadaTrabalho;
import br.com.cad.funcionarios.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@Service
public class JornadaTrabalhoService {

    @Autowired
    private JornadaTrabalhoRepository jornadaTrabalhoRepository;

    @Transactional
    public ResponseEntity<JornadaTrabalho> cadastrar(JornadaTrabalhoDto dto, UriComponentsBuilder uriBuilder) {
        JornadaTrabalho jornadaTrabalho = jornadaTrabalhoRepository.save(JornadaTrabalho.builder()
                .regime(dto.getRegime())
                .jornadDiaria(dto.getJornadDiaria())
                .periodo(dto.getPeriodo())
                .jornadaSemanal(dto.getJornadaSemanal())
                .build());

        URI uri = uriBuilder.path("/jornadaTrabalho/{id}").buildAndExpand(jornadaTrabalho.getId()).toUri();

        return ResponseEntity.created(uri).body(jornadaTrabalho);
    }

    public ResponseEntity<List<JornadaTrabalho>> listar(Long id) {
        if (id != null){
            return ResponseEntity.ok(List.of(jornadaTrabalhoRepository.findById(id)
                    .orElseThrow(()-> new EntityNotFoundException("File not found"))));
        }
        return ResponseEntity.ok(jornadaTrabalhoRepository.findAll());
    }
}
