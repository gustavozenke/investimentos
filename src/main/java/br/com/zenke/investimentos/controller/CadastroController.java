package br.com.zenke.investimentos.controller;

import javax.validation.Valid;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenke.investimentos.mapper.Conversor;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.AcaoRequest;
import br.com.zenke.investimentos.service.CadastrarAcaoService;
import br.com.zenke.investimentos.service.CadastrarFIIService;

@RestController
@RequestMapping("/cadastrar")
public class CadastroController {

	@Autowired
	private Acao acao;

	@Autowired
	private CadastrarAcaoService cadastrarAcao;

	@Autowired
	private CadastrarFIIService cadastrarFII;

	@PostMapping("/acao/{ticker}")
	public ResponseEntity cadastrarAcao(@RequestBody @Valid AcaoRequest acaoRequest) {

		acao = Conversor.converterAcaoResponseToAcao(acaoRequest);
		return cadastrarAcao.cadastrarAcao(acao.getTicker(), acao);
	}

/*
	@PostMapping("/fundo_imobiliario")
	public ResponseEntity cadastrarFII(@RequestBody @Valid Fii FII) {

		return cadastrarFII.cadastrarFII(FII);
	}
*/

}