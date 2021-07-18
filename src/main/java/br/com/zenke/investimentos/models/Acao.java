package br.com.zenke.investimentos.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

@Component
@Entity
@Getter
@NoArgsConstructor
@Table(name = "acao")
public class Acao extends Ativo {

	private String nomeEmpresa;
	private String tipo;
	private String subSetor;
	private String segmento;
	private BigDecimal patrimonioLiquido;
	private BigDecimal ativoTotal;
	private BigDecimal dividaLiquida;
	private BigDecimal lucroLiquido;
	private float returnOnEquity;
	private float returnOnAsset;
	private BigDecimal valorDeMercado;

	public Acao(String ticker, BigDecimal preco, Date dataIPO, String setor, String nomeEmpresa, String tipo,
				String subSetor, String segmento, BigDecimal patrimonioLiquido, BigDecimal ativoTotal,
				BigDecimal dividaLiquida, BigDecimal lucroLiquido, float returnOnEquity, float returnOnAsset,
				BigDecimal valorDeMercado) {
		super(ticker, preco, dataIPO, setor);
		this.nomeEmpresa = nomeEmpresa;
		this.tipo = tipo;
		this.subSetor = subSetor;
		this.segmento = segmento;
		this.patrimonioLiquido = patrimonioLiquido;
		this.ativoTotal = ativoTotal;
		this.dividaLiquida = dividaLiquida;
		this.lucroLiquido = lucroLiquido;
		this.returnOnEquity = returnOnEquity;
		this.returnOnAsset = returnOnAsset;
		this.valorDeMercado = valorDeMercado;
	}
}
