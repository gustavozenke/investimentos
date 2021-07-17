package br.com.zenke.investimentos.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiResponse;
import br.com.zenke.investimentos.repository.FIIRepository;
import br.com.zenke.investimentos.utils.ValidaTicker;

@Service
public class CadastrarFIIService {

	@Autowired
	private FIIRepository repository;

	@Autowired
	private FiiResponse FIIDTO;

	@Autowired
	private List<Fii> listaFIIs;
	
	private final List<FiiResponse> listaAFIIDTO = new ArrayList<>();
	
	public ResponseEntity cadastrarFII(Fii FII) {

		if (!ValidaTicker.validaTickerFII(FII.getTicker())) {
			return ResponseEntity.badRequest().body("Ticker inválido");
		}

		try {
			repository.saveAndFlush(FII);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created");
		}catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Erro: "+e.getRootCause().getMessage());
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
		}
	}

}
