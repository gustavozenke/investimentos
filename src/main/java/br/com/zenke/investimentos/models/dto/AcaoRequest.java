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
import lombok.NoArgsConstructor;

public class AcaoRequest {

	@NotNull 
	@NotBlank 
	@Size(min = 5, max = 6)
	private String Ticker;

	@NotNull 
	@DecimalMin(value = "0.01")
    @Digits(integer = 4, fraction=2)
	private BigDecimal Preco;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 100)
	private Date DataIPO;


	@NotNull
	@NotBlank
	@Size(min = 1, max = 100)
	private String NomeEmpresa;


	@NotNull 
	@NotBlank 
	@Size(min = 2, max = 2)
	private String Tipo;
	
}
