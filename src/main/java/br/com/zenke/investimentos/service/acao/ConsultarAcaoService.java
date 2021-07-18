package br.com.zenke.investimentos.service.acao;

import java.util.NoSuchElementException;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoResponse;
import br.com.zenke.investimentos.repository.AcaoRepository;

import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoToAcaoResponse;
import static br.com.zenke.investimentos.mapper.Conversor.converterFiiToFiiResponse;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;

@Service
public class ConsultarAcaoService {

	@Autowired
	private AcaoRepository repository;

	@Autowired
	private Acao acao;


	public ResponseEntity consultarAcao(String ticker) {

		if (!validaTickerAcao(ticker)) {
			return ResponseEntity.badRequest().body("Ticker inválido");
		}

		try {

			acao = repository.findById(ticker).get();
			return ResponseEntity.ok(converterAcaoToAcaoResponse(acao));

		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Ação não encontrada");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
		}
	}
}
