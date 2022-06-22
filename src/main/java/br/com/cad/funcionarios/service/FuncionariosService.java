package br.com.cad.funcionarios.service;

import br.com.cad.funcionarios.dto.FuncionariosDto;
import br.com.cad.funcionarios.model.Funcionarios;
import br.com.cad.funcionarios.repository.CargosRepository;
import br.com.cad.funcionarios.repository.FuncionariosRepository;
import br.com.cad.funcionarios.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {
    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private CargosRepository cargosRepository;
    @Autowired
    private PessoasRepository pessoasRepository;

    @Transactional
    public ResponseEntity<Funcionarios> cadastrar(FuncionariosDto dto, UriComponentsBuilder uriBuilder) {
        Funcionarios funcionarios = new Funcionarios();

        funcionarios.setCargo(cargosRepository.findById(dto.getCargoId()).get());
        funcionarios.setPessoa(pessoasRepository.findById(dto.getPessoaId()).get());
        funcionarios.setNivelHierarquico(dto.getNivelHierarquico());
        funcionarios.setSuperiorImediato(pessoasRepository.findById(dto.getSuperiorImediatoId()).get());

        funcionariosRepository.save(funcionarios);

        URI uri = uriBuilder.path("/funcionarios/{id}").buildAndExpand(funcionarios.getId()).toUri();

        return ResponseEntity.created(uri).body(funcionarios);
    }

    public ResponseEntity<List<Funcionarios>> buscar(Long id) {
        if (id != null) {
            Optional<Funcionarios> funcionarios = funcionariosRepository.findById(id);
            if (!funcionarios.isEmpty()){
                return ResponseEntity.ok(List.of(funcionarios.get()));
            }else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(funcionariosRepository.findAll());
    }
}
