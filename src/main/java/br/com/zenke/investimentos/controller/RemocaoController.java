package br.com.zenke.investimentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.zenke.investimentos.service.RemoveAcaoService;
import br.com.zenke.investimentos.service.RemoveFIIService;

@RestController
@RequestMapping("/remover")
public class RemocaoController {
	
	@Autowired
	private RemoveAcaoService removerAcao;
	
	@Autowired
	private RemoveFIIService removerFII;
	
	@DeleteMapping("/acao")
	public ResponseEntity RemoverAcao(@RequestParam(name = "ticker") String ticker) {
		return removerAcao.removeAcao(ticker);
	}

	@DeleteMapping("/fundo_imobiliario")
	public ResponseEntity RemoverFII(@RequestParam(name = "ticker") String ticker) {
		return removerFII.removeFII(ticker);
	}
}
