package br.com.zenke.investimentos.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;

@SpringBootTest
public class ValidaTickerTest {

    @Test
    void testar_validacao_ticker_acao_ON_correto() {
        Assertions.assertTrue(validaTickerAcao("WEGE3"));
    }

    @Test
    void testar_validacao_ticker_acao_PN_correto() {
        Assertions.assertTrue(validaTickerAcao("ITSA4"));
    }

    @Test
    void testar_validacao_ticker_acao_preferencial_A_correto() {
        Assertions.assertTrue(validaTickerAcao("CPLE6"));
    }

    @Test
    void testar_validacao_ticker_acao_UNIT_correto() {
        Assertions.assertTrue(validaTickerAcao("TAEE11"));
    }

    @Test
    void testar_validacao_ticker_acao_numero_invalido() {
        Assertions.assertFalse(validaTickerAcao("TAEE12"));
    }

    @Test
    void testar_validacao_ticker_acao_tamanho_ticker_incorreto() {
        Assertions.assertFalse(validaTickerAcao("TAEEE11"));
        Assertions.assertFalse(validaTickerAcao("TAE11"));
    }

    @Test
    void testar_validacao_ticker_fii_correto() {
        Assertions.assertTrue(validaTickerAcao("ALZR11"));
    }

    @Test
    void testar_validacao_ticker_fii_numero_incorreto() {
        Assertions.assertFalse(validaTickerAcao("ALZR12"));
    }
    
    @Test
    void testar_validacao_ticker_fii_tamanho_ticker_incorreto() {
        Assertions.assertFalse(validaTickerAcao("VRTAA11"));
        Assertions.assertFalse(validaTickerAcao("VRT11"));
    }

}
