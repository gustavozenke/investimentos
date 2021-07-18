package br.com.zenke.investimentos.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
@Entity
@Getter
@NoArgsConstructor
@Table(name = "fundosimobiliarios")
public class Fii extends Ativo{

	private String nomeFundo;
	private float dividendYeld;
	private BigDecimal dividendo;
	private float vacanciaFisica;
	private String quantidadeAtivos;

	public Fii(String ticker, BigDecimal preco, Date dataIPO, String nomeFundo, String setor, float dividendYeld,
			   BigDecimal dividendo, float vacanciaFisica, String quantidadeAtivos) {
		super(ticker, preco, dataIPO, setor);
		this.nomeFundo = nomeFundo;
		this.dividendYeld = dividendYeld;
		this.dividendo = dividendo;
		this.vacanciaFisica = vacanciaFisica;
		this.quantidadeAtivos = quantidadeAtivos;
	}
}
