package br.com.zenke.investimentos.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.repository.AcaoRepository;
import br.com.zenke.investimentos.utils.ValidaTicker;

@Service
public class RemoveAcaoService {

	@Autowired
	private AcaoRepository repository;

	public ResponseEntity removeAcao(String ticker) {

		if (!ValidaTicker.validaTickerAcao(ticker)) {
			return ResponseEntity.badRequest().body("Ticker inválido");
		}

		try {
			repository.deleteById(ticker);
			return ResponseEntity.ok().body("Ação " + ticker + " removida com sucesso da base de dados.");
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ação não encontrada");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
