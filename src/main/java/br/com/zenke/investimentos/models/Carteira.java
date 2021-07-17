package br.com.zenke.investimentos.models;

import java.util.List;

public class Carteira {
	
	private String Nome;
	private List<Acao> Acoes;
	private List<Fii> FIIs;
	
	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public List<Acao> getAcoes() {
		return Acoes;
	}

	public void setAcoes(List<Acao> acoes) {
		Acoes = acoes;
	}

	public List<Fii> getFIIs() {
		return FIIs;
	}

	public void setFIIs(List<Fii> fIIs) {
		FIIs = fIIs;
	}

}
