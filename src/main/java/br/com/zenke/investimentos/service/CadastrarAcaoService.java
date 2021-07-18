package br.com.zenke.investimentos.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.repository.AcaoRepository;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;

@Service
public class CadastrarAcaoService {

	@Autowired
	private AcaoRepository repository;
	
	@Autowired
	private Optional<Acao> acaoDatabase;

	public ResponseEntity<?> cadastrarAcao(String ticker, Acao acao) {

		if (!validaTickerAcao(ticker)) {
			return ResponseEntity.badRequest().body("Ticker inválido");
		}

		try {
			acaoDatabase = repository.findById(ticker);
			
			if (acaoDatabase.isPresent())
				return ResponseEntity.status(HttpStatus.FOUND).body(acaoDatabase.get());

			repository.saveAndFlush(acao);
			return ResponseEntity.status(HttpStatus.CREATED).body(acao);

		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body("Erro: " + e.getRootCause().getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro" + e.getMessage());
		}
	}
}
