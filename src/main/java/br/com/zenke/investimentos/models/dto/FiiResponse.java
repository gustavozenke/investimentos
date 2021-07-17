package br.com.zenke.investimentos.models.dto;

import java.math.BigDecimal;
import java.sql.Date;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiiResponse {

	@JsonProperty("ticker")
	private String Ticker;
	
	@JsonProperty("nome_fundo")
	private String NomeFundo;
	
	@JsonProperty("preco_cota")
	private BigDecimal Preco;
	
	@JsonProperty("data_ipo")
	private Date DataIPO;
	
}
