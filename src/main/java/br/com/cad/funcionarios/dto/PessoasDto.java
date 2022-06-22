package br.com.cad.funcionarios.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class PessoasDto {

    @NotEmpty @Length(min = 3)
    private String nome;
    @NotEmpty @Length(min = 11, max = 11)
    private String cpf;
    @NotEmpty @Email
    private String email;
    @NotEmpty @Length(min = 8, max = 8)
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String numero;

}
