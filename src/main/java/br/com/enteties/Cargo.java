package br.com.enteties;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nomeCargo;

    @Column(nullable = false)
    private LocalDate dataInicial;

    @Column(nullable = true)
    private LocalDate dataFinal;

    @OneToOne
    @JoinColumn(name = "Pessoa_id", nullable = false)
    private Pessoa pessoa;



    public Cargo() {
    }


    public Cargo(String nomeCargo, LocalDate dataInicial, LocalDate dataFinal, Pessoa pessoa) {
        this.nomeCargo = nomeCargo;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.pessoa = pessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }


}
