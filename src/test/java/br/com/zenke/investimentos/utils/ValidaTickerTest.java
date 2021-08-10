package br.com.zenke.investimentos.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class ValidaTickerTest {

    @Test
    void testar_validacao_ticker_acao_ON_correto() {
        assertTrue(validaTickerAcao("WEGE3"));
    }

    @Test
    void testar_validacao_ticker_acao_PN_correto() {
        assertTrue(validaTickerAcao("ITSA4"));
    }

    @Test
    void testar_validacao_ticker_acao_preferencial_A_correto() {
        assertTrue(validaTickerAcao("CPLE6"));
    }

    @Test
    void testar_validacao_ticker_acao_UNIT_correto() {
        assertTrue(validaTickerAcao("TAEE11"));
    }

    @Test
    void testar_validacao_ticker_acao_numero_invalido() {
        assertFalse(validaTickerAcao("TAEE12"));
    }

    @Test
    void testar_validacao_ticker_acao_tamanho_ticker_incorreto() {
        assertFalse(validaTickerAcao("TAEEE11"));
        assertFalse(validaTickerAcao("TAE11"));
    }

    @Test
    void testar_validacao_ticker_fii_correto() {
        assertTrue(validaTickerAcao("ALZR11"));
    }

    @Test
    void testar_validacao_ticker_fii_numero_incorreto() {
        assertFalse(validaTickerAcao("ALZR12"));
    }
    
    @Test
    void testar_validacao_ticker_fii_tamanho_ticker_incorreto() {
        assertFalse(validaTickerAcao("VRTAA11"));
        assertFalse(validaTickerAcao("VRT11"));
    }

}
