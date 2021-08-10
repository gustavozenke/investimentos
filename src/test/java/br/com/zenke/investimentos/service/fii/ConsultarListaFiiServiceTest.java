package br.com.zenke.investimentos.service.fii;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.repository.AcaoRepository;
import br.com.zenke.investimentos.repository.FIIRepository;
import br.com.zenke.investimentos.service.acao.ConsultarListaAcoesService;
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
public class ConsultarListaFiiServiceTest {

    @InjectMocks
    private ConsultarListaFIIsService consultarListaFIIsService;

    @Mock
    private FIIRepository repository;

    private List<Fii> listaFii = new ArrayList<>();

    @Test
    void testar_consulta_lista_de_fiis() {

        Fii fiiExpected = new Fii("VRTA11",
                new BigDecimal(126.49),
                new Date(2017, 10, 20),
                "ALIANZA TRUST RENDA IMOBILIARIA FDO INV IMOB",
                "Logística",
                0.49f,
                new BigDecimal(0.62),
                0.0f ,
                13);

        Fii fiiExpected2 = new Fii("BCFF11",
                new BigDecimal(83.10),
                new Date(2009, 8, 27),
                "BTG Pactual Fundo de Fundos",
                "Títulos e Val. Mob.",
                0.56f,
                new BigDecimal(0.45),
                0.0f ,
                0);

        listaFii.add(fiiExpected);
        listaFii.add(fiiExpected2);

        when(repository.findAll()).thenReturn(listaFii);
        HttpStatus httpStatus = consultarListaFIIsService.consultarListaFIIs().getStatusCode();

        Assertions.assertEquals(HttpStatus.OK, httpStatus);
    }
}
