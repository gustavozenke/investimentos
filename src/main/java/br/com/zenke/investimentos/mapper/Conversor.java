package br.com.zenke.investimentos.mapper;

import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.FiiRequest;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoRequest;

public abstract class Conversor {
	
	public static Acao converterAcaoRequestToAcao(AcaoRequest acaoRequest) {
		return new Acao(acaoRequest.getTicker().toUpperCase(),
						acaoRequest.getPreco(),
						acaoRequest.getDataIPO(),
						acaoRequest.getNomeEmpresa(),
						acaoRequest.getTipo());
	}

	public static Fii converterFiiRequestToFii(FiiRequest fiiRequest) {
		return new Fii(fiiRequest.getTicker().toUpperCase(),
					   fiiRequest.getPreco(),
					   fiiRequest.getDataIPO(),
				       fiiRequest.getNomeFundo());
	}

}
