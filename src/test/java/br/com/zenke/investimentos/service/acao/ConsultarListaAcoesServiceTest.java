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
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ConsultarListaAcoesServiceTest {

    @InjectMocks
    private ConsultarListaAcoesService consultarListaAcoesService;

    @Mock
    private AcaoRepository repository;

    private List<Acao> listaAcoes = new ArrayList<>();

    @Test
    void testar_consulta_lista_de_acoes() {

        Acao acaoExpected = new Acao("RADL4",
                new BigDecimal("90.09"),
                new Date(1997, 9, 17),
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

        Acao acaoExpected2 = new Acao("ITSA4",
                new BigDecimal("11.09"),
                new Date(2004, 11, 21),
                "Bancario",
                "Itausa",
                "PN", "Bancarios",
                "Financeiro",
                new BigDecimal("2948005600.14"),
                new BigDecimal("1150069700.45"),
                new BigDecimal("983150000.00"),
                new BigDecimal("532030000.00"),
                09.00f,
                4.26f,
                new BigDecimal("10360000400.00"));

        listaAcoes.add(acaoExpected);
        listaAcoes.add(acaoExpected2);

        when(repository.findAll()).thenReturn(listaAcoes);
        HttpStatus httpStatus = consultarListaAcoesService.consultarListaAcoes().getStatusCode();

        Assertions.assertEquals(HttpStatus.OK, httpStatus);
    }
}