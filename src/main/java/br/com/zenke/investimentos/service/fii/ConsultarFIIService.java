package br.com.zenke.investimentos.service.fii;

import java.util.NoSuchElementException;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiResponse;
import br.com.zenke.investimentos.repository.FIIRepository;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerFII;

@Service
public class ConsultarFIIService {

	@Autowired
	private FIIRepository repository;

	@Autowired
	private Fii FII;

	@Autowired
	private FiiResponse response;

	public ResponseEntity consultarFII(String ticker) {

		if (!validaTickerFII(ticker)) {
			return ResponseEntity.badRequest().body("Ticker inválido");
		}

		try {
			FII = repository.findById(ticker).get();
			response = new DozerBeanMapper().map(FII, FiiResponse.class);

			return ResponseEntity.ok(response);

		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Fundo Imobiliario não encontrado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
		}
	}
}
