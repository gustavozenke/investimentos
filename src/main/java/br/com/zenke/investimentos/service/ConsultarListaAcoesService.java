package br.com.zenke.investimentos.service;

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

@Service
public class ConsultarListaAcoesService {

	@Autowired
	private AcaoRepository repository;

	@Autowired
	private AcaoResponse AcaoDTO;

	@Autowired
	private List<Acao> listaAcoes;

	private final List<AcaoResponse> listaAcoesDTO = new ArrayList<>();

	public ResponseEntity consultarListaAcoes() {

		try {
			listaAcoes = repository.findAll();

			for (int i = 0; i < listaAcoes.size(); i++) {
				AcaoDTO = new DozerBeanMapper().map(listaAcoes.get(i), AcaoResponse.class);
				listaAcoesDTO.add(AcaoDTO);
			}

			return ResponseEntity.ok(listaAcoesDTO);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
		}
	}

}
