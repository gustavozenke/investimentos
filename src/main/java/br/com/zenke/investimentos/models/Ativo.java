package br.com.zenke.investimentos.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

}
