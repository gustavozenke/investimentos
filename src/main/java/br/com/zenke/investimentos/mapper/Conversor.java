package br.com.zenke.investimentos.mapper;

import br.com.zenke.investimentos.models.Fii;
import br.com.zenke.investimentos.models.Pessoa;
import br.com.zenke.investimentos.models.dto.*;
import br.com.zenke.investimentos.models.Acao;

public abstract class Conversor {
	
	public static Acao converterAcaoRequestToAcao(AcaoRequest acaoRequest) {
		return new Acao(acaoRequest.getTicker(),
						acaoRequest.getPreco(),
						acaoRequest.getDataIPO(),
						acaoRequest.getSetor(),
						acaoRequest.getNomeEmpresa(),
						acaoRequest.getTipo(),
						acaoRequest.getSubSetor(),
						acaoRequest.getSegmento(),
						acaoRequest.getPatrimonioLiquido(),
						acaoRequest.getAtivoTotal(),
						acaoRequest.getDividaLiquida(),
						acaoRequest.getLucroLiquido(),
						acaoRequest.getReturnOnEquity(),
						acaoRequest.getReturnOnAsset(),
						acaoRequest.getValorDeMercado());
	}

	public static AcaoResponse converterAcaoToAcaoResponse(Acao acao) {
		return new AcaoResponse(acao.getTicker(),
								acao.getNomeEmpresa(),
								acao.getPreco(),
								acao.getDataIPO(),
								acao.getTipo(),
								acao.getSubSetor(),
								acao.getSegmento(),
								acao.getPatrimonioLiquido(),
								acao.getAtivoTotal(),
								acao.getDividaLiquida(),
								acao.getLucroLiquido(),
								acao.getReturnOnEquity(),
								acao.getReturnOnAsset(),
								acao.getValorDeMercado());
	}

	public static Fii converterFiiRequestToFii(FiiRequest fiiRequest) {
		return new Fii(fiiRequest.getTicker().toUpperCase(),
					   fiiRequest.getPreco(),
					   fiiRequest.getDataIPO(),
				       fiiRequest.getNomeFundo(),
					   fiiRequest.getSetor(),
					   fiiRequest.getDividendYeld(),
				       fiiRequest.getDividendo(),
					   fiiRequest.getVacanciaFisica(),
					   fiiRequest.getQuantidadeAtivos());
	}

	public static FiiResponse converterFiiToFiiResponse(Fii fii) {
		return new FiiResponse(fii.getTicker().toUpperCase(),
							   fii.getNomeFundo(),
							   fii.getPreco(),
							   fii.getDataIPO(),
							   fii.getSetor(),
							   fii.getDividendYeld(),
							   fii.getDividendo(),
							   fii.getVacanciaFisica(),
							   fii.getQuantidadeAtivos());
	}

	public static Pessoa converterPessoaRequestToPessoa(PessoaRequest pessoaRequest) {
		return new Pessoa(pessoaRequest.getCpf(),
						  pessoaRequest.getNome(),
						  pessoaRequest.getEmail(),
						  pessoaRequest.getNumeroContato());
	}

	public static PessoaResponse converterPessoaToPessoaResponse(Pessoa pessoa) {
		return new PessoaResponse(pessoa.getNome(),
								  pessoa.getCpf(),
								  pessoa.getEmail(),
								  pessoa.getNumeroContato(),
								  pessoa.getCarteira());
	}

}
