package br.com.zenke.investimentos.service.acao;

import br.com.zenke.investimentos.repository.AcaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RemoverAcaoServiceTest {

    @InjectMocks
    private RemoverAcaoService removerAcaoService;

    @Mock
    private AcaoRepository repository;

    @Test
    void testar_remover_acao() {

        doNothing().when(repository).deleteById(any());
        HttpStatus httpStatus = removerAcaoService.removerAcao("RADL4").getStatusCode();
        Assertions.assertEquals(HttpStatus.OK, httpStatus);

    }
}