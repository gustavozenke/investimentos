package br.com.zenke.investimentos.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoRequest;

public class Conversor {

	@Autowired
	private Acao acao;
	
	public static Acao converterAcaoResponseToAcao(AcaoRequest acaoRequest) {
		return new DozerBeanMapper().map(acaoRequest,Acao.class);
	}
}
