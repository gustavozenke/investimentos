package br.com.zenke.investimentos.service.pessoa;

import br.com.zenke.investimentos.models.Pessoa;
import br.com.zenke.investimentos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static br.com.zenke.investimentos.mapper.Conversor.converterPessoaToPessoaResponse;

@Service
public class CadastrarPessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private Optional<Pessoa> pessoaDatabase;

    public ResponseEntity cadastrarPessoa(Pessoa pessoa) {

        try {
            pessoaDatabase = repository.findById(pessoa.getCpf());

            if (pessoaDatabase.isPresent())
                return ResponseEntity.status(HttpStatus.FOUND)
                        .body(converterPessoaToPessoaResponse(pessoaDatabase.get()));

            repository.saveAndFlush(pessoa);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(converterPessoaToPessoaResponse(pessoa));

        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("Erro: " + e.getRootCause().getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro" + e.getMessage());
        }
    }

}
