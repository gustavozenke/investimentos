package br.com.zenke.investimentos.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
@Entity
@Table(name = "acao")
public class Acao extends Ativo {

	private String NomeEmpresa;
	private String Tipo;

	public Acao() { }

	public Acao(String ticker, BigDecimal preco, Date dataIPO, String nomeEmpresa, String tipo) {
		super(ticker, preco, dataIPO);
		this.NomeEmpresa = nomeEmpresa;
		this.Tipo = tipo;
	}

	public String getNomeEmpresa() {
		return this.NomeEmpresa;
	}

	public String getTipo() {
		return this.Tipo;
	}
}
