package br.com.zenke.investimentos.models.dto;

import java.math.BigDecimal;
import java.sql.Date;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AcaoRequest{

	@NotNull
	@NotBlank
	@Size(min = 5, max = 6)
	private String ticker;

	@NotNull
	@DecimalMin(value = "0.01")
    @Digits(integer = 4, fraction=2)
	private BigDecimal preco;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataIPO;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 100)
	private String setor;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 100)
	private String nomeEmpresa;

	@NotNull
	@NotBlank
	@Size(min = 2, max = 2)
	private String tipo;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 100)
	private String subSetor;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 100)
	private String segmento;

	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal patrimonioLiquido;

	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal ativoTotal;

	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal dividaLiquida;

	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal lucroLiquido;

	@NotNull
	@Digits(integer = 3, fraction=2)
	private float returnOnEquity;

	@NotNull
	@Digits(integer = 3, fraction=2)
	private float returnOnAsset;

	@NotNull
	@DecimalMin(value = "0.01")
	private BigDecimal valorDeMercado;
}
