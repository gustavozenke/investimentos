package br.com.zenke.investimentos.service.fii;

import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.repository.FIIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static br.com.zenke.investimentos.mapper.Conversor.converterFiiToFiiResponse;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;

@Service
public class AtualizarFIIService {

    @Autowired
    private FIIRepository repository;

    @Autowired
    private Optional<Fii> fiiDatabase;

    public ResponseEntity atualizarFii(Fii fii) {

        if (!validaTickerAcao(fii.getTicker()))
            return ResponseEntity.badRequest().body("Ticker inválido");

        try {
            fiiDatabase = repository.findById(fii.getTicker());

            if (fiiDatabase.isPresent()){
                repository.updateInfoByTicker(
                        fii.getPreco(),
                        fii.getDataIPO(),
                        fii.getSetor(),
                        fii.getNomeFundo(),
                        fii.getDividendYeld(),
                        fii.getDividendo(),
                        fii.getVacanciaFisica(),
                        fii.getQuantidadeAtivos(),
                        fii.getTicker());

                return ResponseEntity.status(HttpStatus.ACCEPTED)
                        .body(converterFiiToFiiResponse(fii));
            }
            else
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("FII não encontrado");

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Erro: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro" + e.getMessage());
        }
    }
}
