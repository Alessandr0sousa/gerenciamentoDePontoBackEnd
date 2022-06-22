package br.com.cad.funcionarios.service;

import br.com.cad.funcionarios.dto.CargosDto;
import br.com.cad.funcionarios.model.Cargos;
import br.com.cad.funcionarios.model.Pessoas;
import br.com.cad.funcionarios.repository.CargosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CargosService {
    @Autowired
    private CargosRepository cargosRepository;

    public ResponseEntity<Cargos> cadastrar(CargosDto dto, UriComponentsBuilder uriBuilder) {
        Cargos cargos = new Cargos();

        cargos.setNomeCargo(dto.getNomeCargo());
        cargos.setDescrição(dto.getDescrição());
        cargos.setSenioridade(dto.getSenioridade());

        cargosRepository.save(cargos);

        URI uri = uriBuilder.path("/cargos/{id}").buildAndExpand(cargos.getId()).toUri();

        return ResponseEntity.created(uri).body(cargos);

    }

    public ResponseEntity<List<Cargos>> buscar(Long id) {
        if (id != null){
            Optional<Cargos> cargos = cargosRepository.findById(id);
            if (!cargos.isEmpty()){
                return ResponseEntity.ok(List.of(cargos.get()));
            }else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(cargosRepository.findAll());
    }
}
