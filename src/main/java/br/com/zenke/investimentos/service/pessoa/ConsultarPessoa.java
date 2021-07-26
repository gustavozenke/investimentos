package br.com.zenke.investimentos.service.pessoa;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.Pessoa;
import br.com.zenke.investimentos.repository.AcaoRepository;
import br.com.zenke.investimentos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

import static br.com.zenke.investimentos.mapper.Conversor.converterAcaoToAcaoResponse;
import static br.com.zenke.investimentos.mapper.Conversor.converterPessoaToPessoaResponse;
import static br.com.zenke.investimentos.utils.ValidaTicker.validaTickerAcao;

@Service
public class ConsultarPessoa {


    @Autowired
    private PessoaRepository repository;

    @Autowired
    private Pessoa pessoaDatabase;

    public ResponseEntity consultarPessoa(String cpf) {

        try {

            pessoaDatabase = repository.findById(cpf).get();
            return ResponseEntity.ok(converterPessoaToPessoaResponse(pessoaDatabase));

        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Pessoa não encontrada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
