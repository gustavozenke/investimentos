package br.com.zenke.investimentos.service;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.repository.FIIRepository;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerFII;

@Service
public class RemoveFIIService {

	@Autowired
	private FIIRepository repository;

	public ResponseEntity removeFII(String ticker) {

		if (!validaTickerFII(ticker)) {
			return ResponseEntity.badRequest().body("Ticker inválido");
		}

		try {
			repository.deleteById(ticker);
			return ResponseEntity.ok().body("Fundo " + ticker + " removido com sucesso da base de dados.");
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fundo não encontrado");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
