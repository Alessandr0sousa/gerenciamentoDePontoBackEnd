package br.com.cad.funcionarios.repository;

import br.com.cad.funcionarios.model.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoasRepository extends JpaRepository<Pessoas, Long> {
    Optional<Pessoas> findById(Long id);
}
