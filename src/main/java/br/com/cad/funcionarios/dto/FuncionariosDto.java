package br.com.cad.funcionarios.dto;

import br.com.cad.funcionarios.model.NivelHierarquico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

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
