package br.com.cad.funcionarios.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class JornadaTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regime;
    private String jornadDiaria;
    private String periodo;
    private String jornadaSemanal;

}
