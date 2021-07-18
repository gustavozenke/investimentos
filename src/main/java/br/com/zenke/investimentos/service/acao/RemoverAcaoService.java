package br.com.zenke.investimentos.service.acao;

import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.repository.AcaoRepository;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;

@Service
public class RemoverAcaoService {

	@Autowired
	private AcaoRepository repository;

	public ResponseEntity removerAcao(String ticker) {

		if (!validaTickerAcao(ticker))
			return ResponseEntity.badRequest().body("Ticker inválido");

		try {
			repository.deleteById(ticker);
			return ResponseEntity.ok().body("Ação " + ticker + " removida com sucesso da base de dados.");

		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Ação não encontrada");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
		}
	}

}
