package br.com.zenke.investimentos.service.acao;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.repository.AcaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AtualizarAcaoServiceTest {

    @InjectMocks
    private AtualizarAcaoService atualizarAcaoService;

    @Mock
    private AcaoRepository repository;

    @Test
    void testar_atualizar_acao() {

        Acao acao = new Acao("RADL4",
                new BigDecimal("20.09"),
                new Date(2004, 9, 17),
                "Saude",
                "Raia Drogasil S.A",
                "ON", "Comercio e distribuicao",
                "Medicamento e outros produtos",
                new BigDecimal("4448000000.00"),
                new BigDecimal("14150000000.00"),
                new BigDecimal("898380000.00"),
                new BigDecimal("547730000.00"),
                12.21f,
                3.87f,
                new BigDecimal("44750000000.00"));


        when(repository.findById(anyString())).thenReturn(Optional.of(acao));

        doNothing().when(repository).updateInfoByTicker(acao.getPreco(),
                acao.getDataIPO(),
                acao.getSetor(),
                acao.getNomeEmpresa(),
                acao.getTipo(),
                acao.getSubSetor(),
                acao.getSegmento(),
                acao.getPatrimonioLiquido(),
                acao.getAtivoTotal(),
                acao.getDividaLiquida(),
                acao.getLucroLiquido(),
                acao.getReturnOnEquity(),
                acao.getReturnOnAsset(),
                acao.getValorDeMercado(),
                acao.getTicker());

        HttpStatus httpStatus = atualizarAcaoService.atualizarAcao(acao).getStatusCode();

        Assertions.assertEquals(HttpStatus.ACCEPTED, httpStatus);

    }
}
