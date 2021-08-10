package br.com.zenke.investimentos.service.fii;

import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.repository.FIIRepository;
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
import static org.mockito.Mockito.when;

@SpringBootTest
public class CadastrarFIIServiceTest {

    @InjectMocks
    private CadastrarFIIService cadastrarFIIService;

    @Mock
    private FIIRepository repository;

    @Test
    void testar_cadastrar_fii() {

        Fii fii = new Fii("VRTA11",
                new BigDecimal("126.49"),
                new Date(2017, 10, 20),
                "ALIANZA TRUST RENDA IMOBILIARIA FDO INV IMOB",
                "Logística",
                0.49f,
                new BigDecimal("0.62"),
                0.0f ,
                13);;

        when(repository.findById(anyString())).thenReturn(Optional.empty());
        when(repository.saveAndFlush(fii)).thenReturn(null);

        HttpStatus httpStatus = cadastrarFIIService.cadastrarFII(fii).getStatusCode();

        Assertions.assertEquals(HttpStatus.CREATED, httpStatus);

    }
}
