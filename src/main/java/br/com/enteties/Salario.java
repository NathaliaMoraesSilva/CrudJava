package br.com.enteties;

import jakarta.persistence.*;

@Entity
@Table(name = "Salario")
public class Salario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private double salario;


    @OneToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    public Salario(double salario) {
        this.salario = salario;

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Salario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
