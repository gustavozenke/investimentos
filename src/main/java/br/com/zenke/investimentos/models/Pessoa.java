package br.com.zenke.investimentos.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Component
@Entity
@Getter
@NoArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    private String cpf;
    private String nome;
    private String email;
    private int numeroContato;

    @Transient
    private Carteira carteira;

    public Pessoa(String cpf, String nome, String email, int numeroContato) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.numeroContato = numeroContato;
        this.carteira = null;
    }

}
