package br.com.zenke.investimentos.service.fii;

import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiResponse;
import br.com.zenke.investimentos.repository.FIIRepository;
import br.com.zenke.investimentos.service.fii.ConsultarFIIService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;
import static br.com.zenke.investimentos.mapper.Conversor.converterFiiToFiiResponse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ConsultarFIIServiceTest {

    @InjectMocks
    private ConsultarFIIService consultarFIIService;

    @Mock
    private FIIRepository repository;

    @Test
    void testar_consulta_acao() {

        Fii fiiExpected = new Fii("VRTA11",
                new BigDecimal(126.49),
                new Date(2017, 10, 20),
                "ALIANZA TRUST RENDA IMOBILIARIA FDO INV IMOB",
                "Logística",
                0.49f,
                new BigDecimal(0.62),
                0.0f ,
                13);

        when(repository.findById(anyString())).thenReturn(Optional.ofNullable(fiiExpected));

        FiiResponse fiiResponse = (FiiResponse) consultarFIIService.consultarFII("VRTA11").getBody();

        Assertions.assertEquals(ResponseEntity.ok(converterFiiToFiiResponse(fiiExpected)).getBody().getTicker(),
                fiiResponse.getTicker());
    }
}
