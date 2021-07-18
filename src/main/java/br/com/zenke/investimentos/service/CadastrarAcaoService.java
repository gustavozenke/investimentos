package br.com.zenke.investimentos.service;

import java.util.Optional;

import br.com.zenke.investimentos.models.dto.AcaoResponse;
import br.com.zenke.investimentos.models.dto.FiiResponse;
import org.dozer.DozerBeanMapper;
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

	@Autowired
	private AcaoResponse response;

	public ResponseEntity<?> cadastrarAcao(Acao acao) {

		if (!validaTickerAcao(acao.getTicker()))
			return ResponseEntity.badRequest().body("Ticker inválido");

		try {
			acaoDatabase = repository.findById(acao.getTicker());
			
			if (acaoDatabase.isPresent()) {
				response = new DozerBeanMapper().map(acaoDatabase, AcaoResponse.class);
				return ResponseEntity.status(HttpStatus.FOUND).body(response);
			}

			repository.saveAndFlush(acao);
			response = new DozerBeanMapper().map(acao, AcaoResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
					.body("Erro: " + e.getRootCause().getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Erro" + e.getMessage());
		}
	}
}
