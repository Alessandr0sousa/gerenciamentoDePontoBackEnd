package br.com.cad.funcionarios.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
public class CargosDto {

    @NotEmpty @Length(min = 3)
    private String nomeCargo;
    @NotEmpty
    private String descrição;
    @NotEmpty @Length(min = 3)
    private String senioridade;

}
