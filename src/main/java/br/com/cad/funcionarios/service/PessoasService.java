package br.com.cad.funcionarios.service;

import br.com.cad.funcionarios.dto.PessoasDto;
import br.com.cad.funcionarios.model.Pessoas;
import br.com.cad.funcionarios.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class PessoasService {
    @Autowired
    private PessoasRepository pessoasRepository;

    public ResponseEntity<Pessoas> cadastrar(PessoasDto dto, UriComponentsBuilder uriBuilder) {
        RestTemplate apiViaCep = new RestTemplate();
        Pessoas pessoas = new Pessoas();

        ResponseEntity<Pessoas> cep = apiViaCep.exchange("https://viacep.com.br/ws/"+dto.getCep()+"/json/", HttpMethod.GET, null, Pessoas.class);

        pessoas.setNome(dto.getNome());
        pessoas.setCpf(dto.getCpf());
        pessoas.setEmail(dto.getEmail());
        pessoas.setCep(dto.getCep());
        pessoas.setLogradouro(cep.getBody().getLogradouro());
        pessoas.setBairro(cep.getBody().getBairro());
        pessoas.setLocalidade(cep.getBody().getLocalidade());
        pessoas.setUf(cep.getBody().getUf());
        pessoas.setNumero(dto.getNumero());

        pessoasRepository.save(pessoas);

        URI uri = uriBuilder.path("/cargos/{id}").buildAndExpand(pessoas.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoas);
    }

    public ResponseEntity<List<Pessoas>> listar(Long id) {
        if (id != null) {
            Optional<Pessoas> pessoas = pessoasRepository.findById(id);
            if (pessoas.isPresent()){
                return ResponseEntity.ok(List.of(pessoas.get()));
            }else {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(pessoasRepository.findAll());
    }


    public ResponseEntity<Pessoas> alterarPessoa(Long id, @Valid PessoasDto dto) {
        RestTemplate apiViaCep = new RestTemplate();
        Optional<Pessoas> pessoas = pessoasRepository.findById(id);

        if (!pessoas.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        ResponseEntity<Pessoas> cep = apiViaCep.exchange("https://viacep.com.br/ws/"+dto.getCep()+"/json/", HttpMethod.GET, null, Pessoas.class);

        pessoas.get().setNome(dto.getNome());
        pessoas.get().setCpf(dto.getCpf());
        pessoas.get().setEmail(dto.getEmail());
        pessoas.get().setCep(dto.getCep());
        pessoas.get().setLogradouro(cep.getBody().getLogradouro());
        pessoas.get().setBairro(cep.getBody().getBairro());
        pessoas.get().setLocalidade(cep.getBody().getLocalidade());
        pessoas.get().setUf(cep.getBody().getUf());
        pessoas.get().setNumero(dto.getNumero());

        pessoasRepository.save(pessoas.get());

        return ResponseEntity.ok(pessoas.get());

    }
}
