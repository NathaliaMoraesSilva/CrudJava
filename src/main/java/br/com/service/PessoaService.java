package br.com.service;

import br.com.dao.PessoaDAO;
import br.com.enteties.Pessoa;

public class PessoaService {

    private final PessoaDAO pessoaDAO = new PessoaDAO();


    public void salvar(Pessoa pessoa) {
        pessoaDAO.salvar(pessoa);
    }

    public void excluir(int id) {
        pessoaDAO.deletar(Long.parseLong(String.valueOf(id)));
    }

    public Pessoa buscarPorId(int id) {

        Pessoa pessoaBusca = pessoaDAO.buscar(Long.parseLong(String.valueOf(id)));
        return pessoaBusca;
    }

    public void atualizar(Pessoa pessoa) {
        pessoaDAO.atualizar(pessoa);
    }

}
