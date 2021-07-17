package br.com.zenke.investimentos.service;

import java.util.NoSuchElementException;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoResponse;
import br.com.zenke.investimentos.repository.AcaoRepository;
import br.com.zenke.investimentos.utils.ValidaTicker;

@Service
public class ConsultarAcaoService {

	@Autowired
	private AcaoRepository repository;

	@Autowired
	private Acao acao;

	@Autowired
	private AcaoResponse response;

	public ResponseEntity consultarAcao(String ticker) {

		if (!ValidaTicker.validaTickerAcao(ticker)) {
			return ResponseEntity.badRequest().body("Ticker inválido");
		}

		try {
			acao = repository.findById(ticker).get();
			response = new DozerBeanMapper().map(acao, AcaoResponse.class);
			return ResponseEntity.ok(response);
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ação não encontrada");
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
