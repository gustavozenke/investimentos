package br.com.zenke.investimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zenke.investimentos.models.Acao;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Date;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, String>
{

    @Transactional
    @Modifying
    @Query(value = "UPDATE investimentos.acao acao SET " +
            "acao.preco = ?1, " +
            "acao.dataIPO = ?2, " +
            "acao.setor = ?3, " +
            "acao.nomeEmpresa = ?4, " +
            "acao.tipo = ?5, " +
            "acao.subSetor = ?6, " +
            "acao.segmento = ?7, " +
            "acao.patrimonioLiquido = ?8, " +
            "acao.ativoTotal = ?9, " +
            "acao.dividaLiquida = ?10, " +
            "acao.lucroLiquido = ?11, " +
            "acao.returnOnEquity = ?12, " +
            "acao.returnOnAsset = ?13, " +
            "acao.valorDeMercado = ?14 " +
            "WHERE acao.ticker = ?15", nativeQuery = true)
    void updateInfoByTicker(BigDecimal preco, Date dataIPO, String setor, String nomeEmpresa, String tipo,
                            String subSetor, String segmento, BigDecimal patrimonioLiquido, BigDecimal ativoTotal,
                            BigDecimal dividaLiquida, BigDecimal lucroLiquido, float returnOnEquity,
                            float returnOnAsset, BigDecimal valorDeMercado, String ticker);

}