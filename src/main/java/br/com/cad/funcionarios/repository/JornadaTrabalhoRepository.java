package br.com.cad.funcionarios.repository;

import br.com.cad.funcionarios.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JornadaTrabalhoRepository extends JpaRepository<JornadaTrabalho, Long> {
    Optional<JornadaTrabalho> findById(Long id);
}
