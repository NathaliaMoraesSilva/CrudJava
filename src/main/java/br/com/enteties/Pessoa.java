package br.com.enteties;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Endereco endereco;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cargo cargo;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Salario salario;

    public Salario getSalario() {
        return salario;
    }

    public void setSalario(Salario salario) {
        this.salario = salario;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        endereco.setPessoa(this); // Mantém a consistência da relação bidirecional
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
        cargo.setPessoa(this); // Mantém a consistência da relação bidirecional
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}