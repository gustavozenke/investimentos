package br.com.zenke.investimentos.service.acao;

import java.util.ArrayList;
import java.util.List;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoResponse;
import br.com.zenke.investimentos.repository.AcaoRepository;

import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoToAcaoResponse;

@Service
public class ConsultarListaAcoesService {

	@Autowired
	private AcaoRepository repository;

	@Autowired
	private List<Acao> listaAcoes;

	@Autowired
	private List<AcaoResponse> listaAcoesResponse;

	public ResponseEntity consultarListaAcoes() {

		try {

			listaAcoes = repository.findAll();
			listaAcoesResponse = new ArrayList<>();

			for (int i = 0; i < listaAcoes.size(); i++)
				listaAcoesResponse.add(converterAcaoToAcaoResponse(listaAcoes.get(i)));

			return ResponseEntity.ok(listaAcoesResponse);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
		}
	}

}
