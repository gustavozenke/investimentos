package br.com.zenke.investimentos.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Ativo {

    @Id
    private String Ticker;
    private BigDecimal Preco;
    private Date DataIPO;

    public Ativo(String ticker, BigDecimal preco, Date dataIPO) {
        this.Ticker = ticker;
        this.Preco = preco;
        this.DataIPO = dataIPO;
    }

    public Ativo() { }

    public String getTicker() {
        return this.Ticker;
    }

    public BigDecimal getPreco() {
        return this.Preco;
    }

    public Date getDataIPO() {
        return this.DataIPO;
    }

}
