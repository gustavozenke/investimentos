package br.com.zenke.investimentos.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "fundosimobiliarios")
public class Fii{

	@Id
	private String Ticker;
	private BigDecimal Preco;
	private Date DataIPO;
	private String NomeFundo;

}
