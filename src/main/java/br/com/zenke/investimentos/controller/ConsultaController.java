package br.com.zenke.investimentos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.zenke.investimentos.service.ConsultarAcaoService;
import br.com.zenke.investimentos.service.ConsultarFIIService;
import br.com.zenke.investimentos.service.ConsultarListaAcoesService;
import br.com.zenke.investimentos.service.ConsultarListaFIIsService;

@RestController
@RequestMapping("/consultar")
public class ConsultaController {

	@Autowired
	private ConsultarAcaoService consultarAcao;

	@Autowired
	private ConsultarListaAcoesService consultarListaAcoes;

	@Autowired
	private ConsultarFIIService consultarFII;
	
	@Autowired
	private ConsultarListaFIIsService consultarListaFIIs;

	@GetMapping("/acao")
	public ResponseEntity consultarAcao(@RequestParam(name = "ticker") String ticker) {
		return consultarAcao.consultarAcao(ticker);
	}

	@GetMapping("/fundo_imobiliario")
	public ResponseEntity consultarFII(@RequestParam(name = "ticker") String ticker) {
		return consultarFII.consultarFII(ticker);
	}

	@GetMapping("/lista_acoes")
	public ResponseEntity consultarListaAcoes() {
		return consultarListaAcoes.consultarListaAcoes();
	}
	
	@GetMapping("/lista_fundos_imobiliarios")
	public ResponseEntity consultarListaFIIs() {
		return consultarListaFIIs.consultarListaFIIs();
	}

}