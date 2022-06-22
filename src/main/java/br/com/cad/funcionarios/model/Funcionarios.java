package br.com.cad.funcionarios.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoas pessoa;
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargos cargo;
    @ManyToOne
    @JoinColumn(name = "superior_imediato_id")
    private Pessoas superiorImediato;
    @Enumerated
    private NivelHierarquico nivelHierarquico;
    private LocalDateTime dataCriacao = LocalDateTime.now();

}
