package br.com.zenke.investimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zenke.investimentos.models.Fii;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Date;

@Repository
public interface FIIRepository  extends JpaRepository<Fii, String>
{
    @Transactional
    @Modifying
    @Query(value = "UPDATE investimentos.fundosimobiliarios fii SET " +
            "fii.preco = ?1, " +
            "fii.dataIPO = ?2, " +
            "fii.setor = ?3, " +
            "fii.nomeFundo = ?4, " +
            "fii.dividendYeld = ?5, " +
            "fii.dividendo = ?6, " +
            "fii.vacanciaFisica = ?7, " +
            "fii.quantidadeAtivos = ?8 " +
            "WHERE fii.ticker = ?9", nativeQuery = true)
    void updateInfoByTicker(BigDecimal preco, Date dataIPO, String setor, String nomeFundo, float dividendYeld,
                            BigDecimal dividendo, float vacanciaFisica, int quantidadeAtivos, String ticker);
}

