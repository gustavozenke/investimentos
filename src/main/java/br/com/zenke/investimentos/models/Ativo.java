package br.com.zenke.investimentos.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Locale;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Acao.class, name = "Acao"),
        @JsonSubTypes.Type(value = Fii.class, name = "Fii")
})
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
