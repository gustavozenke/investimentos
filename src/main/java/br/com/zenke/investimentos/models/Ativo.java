package br.com.zenke.investimentos.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Acao.class, name = "Acao"),
        @JsonSubTypes.Type(value = Fii.class, name = "Fii")
})
public abstract class Ativo {

    @Id
    private String ticker;
    private BigDecimal preco;
    private Date dataIPO;
    private String setor;

    public Ativo(String ticker, BigDecimal preco, Date dataIPO, String setor) {
        this.ticker = ticker;
        this.preco = preco;
        this.dataIPO = dataIPO;
        this.setor = setor;
    }

    public Ativo() { }

    public String getTicker() {
        return this.ticker;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public Date getDataIPO() {
        return this.dataIPO;
    }

    public String getSetor() {
        return setor;
    }

}
