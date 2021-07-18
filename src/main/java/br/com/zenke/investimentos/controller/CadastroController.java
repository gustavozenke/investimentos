package br.com.zenke.investimentos.controller;

import javax.validation.Valid;

import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoRequest;
import br.com.zenke.investimentos.service.acao.CadastrarAcaoService;
import br.com.zenke.investimentos.service.fii.CadastrarFIIService;
import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoRequestToAcao;
import static br.com.zenke.investimentos.mapper.Conversor.converterFiiRequestToFii;

@RestController
@RequestMapping("/cadastrar")
public class CadastroController {

	@Autowired
	private Acao acao;

	@Autowired
	private Fii fii;

	@Autowired
	private CadastrarAcaoService cadastrarAcao;

	@Autowired
	private CadastrarFIIService cadastrarFII;

	@PostMapping("/acao")
	public ResponseEntity cadastrarAcao(@Valid @RequestBody AcaoRequest acaoRequest) {
		acao = converterAcaoRequestToAcao(acaoRequest);
		return cadastrarAcao.cadastrarAcao(acao);
	}

	@PostMapping("/fundo_imobiliario")
	public ResponseEntity cadastrarFII(@RequestBody FiiRequest fiiRequest) {
		fii = converterFiiRequestToFii(fiiRequest);
		return cadastrarFII.cadastrarFII(fii);
	}
}