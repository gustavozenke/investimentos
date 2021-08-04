package br.com.zenke.investimentos.service.acao;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoToAcaoResponse;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;


@Service
public class AtualizarAcaoService {

    @Autowired
    private AcaoRepository repository;

    @Autowired
    private Optional<Acao> acaoDatabase;

    public ResponseEntity atualizarAcao(Acao acao) {

        if (!validaTickerAcao(acao.getTicker()))
            return ResponseEntity.badRequest().body("Ticker inválido");

        try {
            acaoDatabase = repository.findById(acao.getTicker());

            if (acaoDatabase.isPresent()){
                repository.setUserInfoById(acao.getNomeEmpresa(),
                    acao.getTipo(),
                    acao.getSubSetor(),
                    acao.getSegmento(),
                    acao.getPatrimonioLiquido(),
                    acao.getAtivoTotal(),
                    acao.getDividaLiquida(),
                    acao.getLucroLiquido(),
                    acao.getReturnOnEquity(),
                    acao.getReturnOnAsset(),
                    acao.getValorDeMercado(),
                    acao.getTicker());
            }

            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(converterAcaoToAcaoResponse(acao));

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Erro: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro" + e.getMessage());
        }
    }
}
