package br.com.zenke.investimentos.service.fii;

import br.com.zenke.investimentos.repository.FIIRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@SpringBootTest
public class RemoverFIIServiceTest {

    @InjectMocks
    private RemoverFIIService removerFIIService;

    @Mock
    private FIIRepository repository;

    @Test
    void testar_remover_fii() {

        doNothing().when(repository).deleteById(any());
        HttpStatus httpStatus = removerFIIService.removerFII("VRTA11").getStatusCode();
        Assertions.assertEquals(HttpStatus.OK, httpStatus);
    }
}