package br.com.zenke.investimentos.controller;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.AcaoRequest;
import br.com.zenke.investimentos.models.dto.FiiRequest;
import br.com.zenke.investimentos.service.acao.AtualizarAcaoService;
import br.com.zenke.investimentos.service.fii.AtualizarFIIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoRequestToAcao;
import static br.com.zenke.investimentos.mapper.Conversor.converterFiiRequestToFii;

@RestController
@RequestMapping("/atualizar")
public class AtualizacaoController {

    @Autowired
    private Acao acao;

    @Autowired
    private Fii fii;

    @Autowired
    private AtualizarAcaoService atualizarAcao;

    @Autowired
    private AtualizarFIIService atualizarFII;

    @PutMapping("/acao")
    public ResponseEntity atualizarAcao(@Valid @RequestBody AcaoRequest acaoRequest) {
        acao = converterAcaoRequestToAcao(acaoRequest);
        return atualizarAcao.atualizarAcao(acao);
    }

   @PutMapping("/fundo_imobiliario")
    public ResponseEntity atualizarFII(@Valid @RequestBody FiiRequest fiiRequest) {
        fii = converterFiiRequestToFii(fiiRequest);
        return atualizarFII.atualizarFii(fii);
    }
}
