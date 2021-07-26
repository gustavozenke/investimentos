package br.com.zenke.investimentos.controller;

import javax.validation.Valid;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.Pessoa;
import br.com.zenke.investimentos.models.dto.FiiRequest;
import br.com.zenke.investimentos.models.dto.PessoaRequest;
import br.com.zenke.investimentos.service.pessoa.CadastrarPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoRequest;
import br.com.zenke.investimentos.service.acao.CadastrarAcaoService;
import br.com.zenke.investimentos.service.fii.CadastrarFIIService;

import static br.com.zenke.investimentos.mapper.Conversor.*;

@RestController
@RequestMapping("/cadastrar")
public class CadastroController {

	@Autowired
	private Acao acao;

	@Autowired
	private Fii fii;

	@Autowired
	private Pessoa pessoa;

	@Autowired
	private CadastrarAcaoService cadastrarAcao;

	@Autowired
	private CadastrarFIIService cadastrarFII;

	@Autowired
	private CadastrarPessoaService cadastrarPessoaService;

	@PostMapping("/acao")
	public ResponseEntity cadastrarAcao(@Valid @RequestBody AcaoRequest acaoRequest) {
		acao = converterAcaoRequestToAcao(acaoRequest);
		return cadastrarAcao.cadastrarAcao(acao);
	}

	@PostMapping("/fundo_imobiliario")
	public ResponseEntity cadastrarFII(@Valid @RequestBody FiiRequest fiiRequest) {
		fii = converterFiiRequestToFii(fiiRequest);
		return cadastrarFII.cadastrarFII(fii);
	}

	@PostMapping("/pessoa")
	public ResponseEntity cadastrarPessoa(@Valid @RequestBody PessoaRequest pessoaRequest) {
		pessoa = converterPessoaRequestToPessoa(pessoaRequest);
		return cadastrarPessoaService.cadastrarPessoa(pessoa);
	}

}