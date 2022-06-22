package br.com.cad.funcionarios.dto;

import br.com.cad.funcionarios.model.Cargos;
import br.com.cad.funcionarios.model.NivelHierarquico;
import br.com.cad.funcionarios.model.Pessoas;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class FuncionariosDto {

    @NonNull
    private Long pessoaId;
    @NonNull
    private Long cargoId;
    @NonNull
    private Long superiorImediatoId;
    private NivelHierarquico nivelHierarquico;

}
