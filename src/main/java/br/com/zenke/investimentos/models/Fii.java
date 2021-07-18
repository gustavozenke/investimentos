package br.com.zenke.investimentos.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
@Entity
@Table(name = "fundosimobiliarios")
public class Fii extends Ativo{

	private String nomeFundo;
	private String setor;
	private float dividendYeld;
	private BigDecimal dividendo;
	private float vacanciaFisica;
	private String quantidadeAtivos;

	public Fii(String ticker, BigDecimal preco, Date dataIPO, String nomeFundo, String setor, float dividendYeld,
			   BigDecimal dividendo, float vacanciaFisica, String quantidadeAtivos) {
		super(ticker, preco, dataIPO);
		this.nomeFundo = nomeFundo;
		this.setor = setor;
		this.dividendYeld = dividendYeld;
		this.dividendo = dividendo;
		this.vacanciaFisica = vacanciaFisica;
		this.quantidadeAtivos = quantidadeAtivos;
	}

	public Fii() { }

	public String getNomeFundo() {
		return nomeFundo;
	}

	public String getSetor() {
		return setor;
	}

	public float getDividendYeld() {
		return dividendYeld;
	}

	public BigDecimal getDividendo() {
		return dividendo;
	}

	public float getVacanciaFisica() {
		return vacanciaFisica;
	}

	public String getQuantidadeAtivos() {
		return quantidadeAtivos;
	}


}
