package br.com.zenke.investimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.zenke.investimentos.models.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, String>{
	
}
