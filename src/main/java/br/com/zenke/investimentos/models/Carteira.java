package br.com.zenke.investimentos.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Entity
@Getter
@NoArgsConstructor
@Table(name = "carteira")
public class Carteira {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String nomeCarteira;
	private int quantidadeAcoes;
	private int getQuantidadeFiis;

	@Transient
	private List<Acao> listaDeAcoes;

	@Transient
	private List<Fii> listaDeFiis;

	public Carteira(int id, String nomeCarteira, int quantidadeAcoes, int getQuantidadeFiis, List<Acao> listaDeAcoes, List<Fii> listaDeFiis) {
		this.id = id;
		this.nomeCarteira = nomeCarteira;
		this.quantidadeAcoes = quantidadeAcoes;
		this.getQuantidadeFiis = getQuantidadeFiis;
		this.listaDeAcoes = listaDeAcoes;
		this.listaDeFiis = listaDeFiis;
	}

}
