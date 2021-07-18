package br.com.zenke.investimentos.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoRequest;

public class Conversor {
	
	public static Acao converterAcaoResponseToAcao(AcaoRequest acaoRequest) {
		return new Acao(acaoRequest.getTicker(),
						acaoRequest.getPreco(),
						acaoRequest.getDataIPO(),
						acaoRequest.getNomeEmpresa(),
						acaoRequest.getTipo());
	}
}
