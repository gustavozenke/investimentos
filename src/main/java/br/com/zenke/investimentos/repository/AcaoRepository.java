package br.com.zenke.investimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.zenke.investimentos.models.Acao;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, String>{

    @Transactional //try to add this annotation
    @Modifying
    @Query(value = "UPDATE investimentos.acao acao SET " +
            "acao.nomeEmpresa = ?1, " +
            "acao.tipo = ?2, " +
            "acao.subSetor = ?3, " +
            "acao.segmento = ?4, " +
            "acao.patrimonioLiquido = ?5, " +
            "acao.ativoTotal = ?6, " +
            "acao.dividaLiquida = ?7, " +
            "acao.lucroLiquido = ?8, " +
            "acao.returnOnEquity = ?9, " +
            "acao.returnOnAsset = ?10, " +
            "acao.valorDeMercado = ?11 " +
            "WHERE acao.ticker = ?12", nativeQuery = true)
    void setUserInfoById(String nomeEmpresa, String tipo, String subSetor, String segmento,
                         BigDecimal patrimonioLiquido, BigDecimal ativoTotal, BigDecimal dividaLiquida,
                         BigDecimal lucroLiquido, float returnOnEquity, float returnOnAsset,
                         BigDecimal valorDeMercado, String ticker);

}
