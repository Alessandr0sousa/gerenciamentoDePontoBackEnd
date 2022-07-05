package br.com.cad.funcionarios.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JornadaTrabalhoDto {
    @NotEmpty @Length(min = 3)
    private String regime;
    @NotEmpty
    private String jornadDiaria;
    @NotEmpty
    private String periodo;
    @NonNull
    private String jornadaSemanal;

}
