package br.com.zenke.investimentos.service.acao;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoResponse;
import br.com.zenke.investimentos.repository.AcaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;
import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoToAcaoResponse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CadastrarAcaoServiceTest {

    @InjectMocks
    private CadastrarAcaoService cadastrarAcaoService;

    @Mock
    private AcaoRepository repository;

    @Test
    void testar_cadastrar_acao() {

        Acao acao = new Acao("RADL4",
                new BigDecimal(90.09),
                new Date(1997, 9, 17),
                "Saude",
                "Raia Drogasil S.A",
                "ON", "Comercio e distribuicao",
                "Medicamento e outros produtos",
                new BigDecimal(4448000000.00),
                new BigDecimal(14150000000.00),
                new BigDecimal(898380000.00),
                new BigDecimal(547730000.00),
                12.21f,
                3.87f,
                new BigDecimal(44750000000.00));

        when(repository.findById(anyString())).thenReturn(Optional.empty());
        when(repository.saveAndFlush(acao)).thenReturn(null);

        HttpStatus httpStatus = cadastrarAcaoService.cadastrarAcao(acao).getStatusCode();

        Assertions.assertEquals(HttpStatus.CREATED, httpStatus);

    }
}