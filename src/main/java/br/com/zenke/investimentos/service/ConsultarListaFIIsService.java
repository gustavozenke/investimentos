package br.com.zenke.investimentos.service;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiResponse;
import br.com.zenke.investimentos.repository.FIIRepository;

@Service
public class ConsultarListaFIIsService {

	@Autowired
	private FIIRepository repository;

	@Autowired
	private List<Fii> listaFIIs;

	private final List<FiiResponse> listaFIIsDTO = new ArrayList<>();

	@Autowired
	private FiiResponse FIIDTO;

	public ResponseEntity consultarListaFIIs() {
		try {

			listaFIIs = repository.findAll();
			System.out.println(listaFIIs.size());
			for (int i = 0; i < listaFIIs.size(); i++) {
				FIIDTO = new DozerBeanMapper().map(listaFIIs.get(i), FiiResponse.class);
				listaFIIsDTO.add(FIIDTO);
			}
			return ResponseEntity.ok(listaFIIsDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
