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
public class AcaoResponse {

	@JsonProperty("ticker")
	private String ticker;
	
	@JsonProperty("nome_empresa")
	private String nomeEmpresa;
	
	@JsonProperty("preco_cota")
	private BigDecimal preco;
	
	@JsonProperty("data_ipo")
	private Date dataIPO;
	
	@JsonProperty("tipo_acao")
	private String tipo;

	@JsonProperty("sub_setor")
	private String subSetor;

	@JsonProperty("segmento")
	private String segmento;

	@JsonProperty("patrimonio_liquido")
	private BigDecimal patrimonioLiquido;

	@JsonProperty("ativo_total")
	private BigDecimal ativoTotal;

	@JsonProperty("divida_liquida")
	private BigDecimal dividaLiquida;

	@JsonProperty("lucro_liquido")
	private BigDecimal lucroLiquido;

	@JsonProperty("roe")
	private float returnOnEquity;

	@JsonProperty("roa")
	private float returnOnAsset;

	@JsonProperty("valor_de_mercado")
	private BigDecimal valorDeMercado;
}
