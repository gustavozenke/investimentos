package br.com.zenke.investimentos.mapper;

import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.dto.AcaoResponse;
import br.com.zenke.investimentos.models.dto.FiiRequest;
import br.com.zenke.investimentos.models.Acao;
import br.com.zenke.investimentos.models.dto.AcaoRequest;
import br.com.zenke.investimentos.models.dto.FiiResponse;

public abstract class Conversor {
	
	public static Acao converterAcaoRequestToAcao(AcaoRequest acaoRequest) {
		return new Acao(acaoRequest.getTicker().toUpperCase(),
						acaoRequest.getPreco(),
						acaoRequest.getDataIPO(),
						acaoRequest.getNomeEmpresa(),
						acaoRequest.getTipo());
	}

	public static AcaoResponse converterAcaoToAcaoResponse(Acao acao) {
		return new AcaoResponse(acao.getTicker(),
								acao.getNomeEmpresa(),
								acao.getPreco(),
								acao.getDataIPO(),
								acao.getTipo());
	}

	public static Fii converterFiiRequestToFii(FiiRequest fiiRequest) {
		return new Fii(fiiRequest.getTicker().toUpperCase(),
					   fiiRequest.getPreco(),
					   fiiRequest.getDataIPO(),
				       fiiRequest.getNomeFundo());
	}

	public static FiiResponse converterFiiToFiiResponse(Fii fii) {
		return new FiiResponse(fii.getTicker().toUpperCase(),
							   fii.getNomeFundo(),
							   fii.getPreco(),
							   fii.getDataIPO());
	}

}
