package br.com.enteties;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String numero;

    @OneToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    // Construtores, Getters e Setters
    public Endereco() {}

    public Endereco(String rua, String cep, String numero, Pessoa pessoa) {
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}