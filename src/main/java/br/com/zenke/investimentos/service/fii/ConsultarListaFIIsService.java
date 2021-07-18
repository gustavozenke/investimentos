package br.com.zenke.investimentos.service.fii;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiResponse;
import br.com.zenke.investimentos.repository.FIIRepository;
import static br.com.zenke.investimentos.mapper.Conversor.converterFiiToFiiResponse;

@Service
public class ConsultarListaFIIsService {

	@Autowired
	private FIIRepository repository;

	@Autowired
	private List<Fii> listaFIIs;

	@Autowired
	private List<FiiResponse> listaFiiResponse;


	public ResponseEntity consultarListaFIIs() {

		try {

			listaFIIs = repository.findAll();
			listaFiiResponse = new ArrayList<>();

			for (int i = 0; i < listaFIIs.size(); i++)
				listaFiiResponse.add(converterFiiToFiiResponse(listaFIIs.get(i)));

			return ResponseEntity.ok(listaFiiResponse);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
		}
	}

}
