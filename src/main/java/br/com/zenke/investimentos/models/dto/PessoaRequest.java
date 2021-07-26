package br.com.zenke.investimentos.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    @NotNull
    @NotBlank
    @Size(min = 5, max = 50)
    private String email;

    @NotNull
    private int numeroContato;
}
