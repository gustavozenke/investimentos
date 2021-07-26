package br.com.zenke.investimentos.service.pessoa;

import br.com.zenke.investimentos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RemoverPessoa {

    @Autowired
    private PessoaRepository repository;

    public ResponseEntity removerPessoa(String ticker) {

        try {
            repository.deleteById(ticker);
            return ResponseEntity.ok().body("CPF " + ticker + " removido com sucesso da base de dados.");

        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("CPF não encontrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
