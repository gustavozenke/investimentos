package br.com.zenke.investimentos.service.acao;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoResponse;
import br.com.zenke.investimentos.repository.AcaoRepository;
import br.com.zenke.investimentos.service.acao.ConsultarAcaoService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;
import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoToAcaoResponse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class ConsultarAcaoServiceTest {

	@InjectMocks
	private ConsultarAcaoService consultarAcaoService;

	@Mock
	private AcaoRepository repository;

	@Test
	void testar_consulta_acao() {

		 Acao acaoExpected = new Acao("RADL4",
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

		when(repository.findById(anyString())).thenReturn(Optional.ofNullable(acaoExpected));

		AcaoResponse acaoResponse = (AcaoResponse) consultarAcaoService.consultarAcao("RADL4").getBody();

		Assertions.assertEquals(ResponseEntity.ok(converterAcaoToAcaoResponse(acaoExpected)).getBody().getTicker(),
				acaoResponse.getTicker());

	}
}
