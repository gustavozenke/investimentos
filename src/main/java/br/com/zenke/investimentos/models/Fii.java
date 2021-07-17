package br.com.zenke.investimentos.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
@Entity
@Table(name = "fundosimobiliarios")
public class Fii extends Ativo {

	private String NomeFundo;

	public Fii() {
	}

	public Fii(String ticker, BigDecimal preco, Date dataIPO, String nomeFundo) {
		super(ticker, preco, dataIPO);
		this.NomeFundo = nomeFundo;
	}

	public String getNomeFundo() {
		return this.NomeFundo;
	}

}
