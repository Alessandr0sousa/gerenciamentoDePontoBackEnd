package br.com.cad.funcionarios.repository;

import br.com.cad.funcionarios.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
    Optional<Funcionarios> findById(Long id);
}
