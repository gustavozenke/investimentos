package br.com.zenke.investimentos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoResponse;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiResponse;
import br.com.zenke.investimentos.repository.FIIRepository;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerFII;

@Service
public class CadastrarFIIService {

	@Autowired
	private FIIRepository repository;

	@Autowired
	private Optional<Fii> fiiDatabase;

	@Autowired
	private FiiResponse response;
	
	public ResponseEntity cadastrarFII(Fii fii) {

		if (!validaTickerFII(fii.getTicker()))
			return ResponseEntity.badRequest().body("Ticker inválido");

		try {
			fiiDatabase = repository.findById(fii.getTicker());

			if (fiiDatabase.isPresent()) {
				response = new DozerBeanMapper().map(fiiDatabase, FiiResponse.class);
				return ResponseEntity.status(HttpStatus.FOUND).body(response);
			}

			repository.saveAndFlush(fii);
			response = new DozerBeanMapper().map(fii, FiiResponse.class);

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
