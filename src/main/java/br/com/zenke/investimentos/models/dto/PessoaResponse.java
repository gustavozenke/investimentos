package br.com.zenke.investimentos.models.dto;

import br.com.zenke.investimentos.models.Carteira;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PessoaResponse {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("e-mail")
    private String email;

    @JsonProperty("numero_contato")
    private int numeroContato;

    @JsonProperty("carteira")
    private Carteira carteira;

}
