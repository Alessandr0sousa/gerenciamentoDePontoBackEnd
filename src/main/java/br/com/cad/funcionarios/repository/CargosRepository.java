package br.com.cad.funcionarios.repository;

import br.com.cad.funcionarios.model.Cargos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CargosRepository extends JpaRepository<Cargos, Long> {
    Optional<Cargos> findById(Long id);
}
