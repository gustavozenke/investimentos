package br.com.zenke.investimentos.models.dto;

import java.math.BigDecimal;
import java.sql.Date;

import lombok.Getter;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FiiResponse {

	@JsonProperty("ticker")
	private String ticker;
	
	@JsonProperty("nome_fundo")
	private String nomeFundo;
	
	@JsonProperty("preco_cota")
	private BigDecimal preco;
	
	@JsonProperty("data_ipo")
	private Date dataIPO;

	@JsonProperty("setor")
	private String setor;

	@JsonProperty("dividend_yeld")
	private float dividendYeld;

	@JsonProperty("dividendo")
	private BigDecimal dividendo;

	@JsonProperty("vacancia_fisica")
	private float vacanciaFisica;

	@JsonProperty("quantidade_de_ativos")
	private String quantidadeAtivos;
	
}
