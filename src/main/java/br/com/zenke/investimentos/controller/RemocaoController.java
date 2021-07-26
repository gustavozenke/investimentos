package br.com.zenke.investimentos.controller;

import br.com.zenke.investimentos.service.pessoa.RemoverPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.zenke.investimentos.service.acao.RemoverAcaoService;
import br.com.zenke.investimentos.service.fii.RemoverFIIService;

@RestController
@RequestMapping("/remover")
public class RemocaoController {
	
	@Autowired
	private RemoverAcaoService removerAcao;
	
	@Autowired
	private RemoverFIIService removerFII;

	@Autowired
	private RemoverPessoa removerPessoa;
	
	@DeleteMapping("/acao")
	public ResponseEntity removerAcao(@RequestParam(name = "ticker") String ticker) {
		return removerAcao.removerAcao(ticker);
	}

	@DeleteMapping("/fundo_imobiliario")
	public ResponseEntity removerFII(@RequestParam(name = "ticker") String ticker) {
		return removerFII.removerFII(ticker);
	}

	@DeleteMapping("/pessoa")
	public ResponseEntity removerPessoa(@RequestParam(name = "cpf") String cpf) {
		return removerPessoa.removerPessoa(cpf);
	}
}
