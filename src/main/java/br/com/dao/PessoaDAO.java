package br.com.dao;

import br.com.enteties.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PessoaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void salvar(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pessoa); // Persistir Pessoa (e Endereco, Cargo, Salario devido ao cascade)
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Pessoa buscar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Pessoa.class, id);
        } finally {
            em.close();
        }
    }

    public void atualizar(Pessoa pessoa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pessoa); // Atualizar Pessoa (e Endereco, Cargo, Salario devido ao cascade)
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, id);
            if (pessoa != null) {
                em.remove(pessoa); // Remover Pessoa (e Endereco, Cargo, Salario devido ao cascade)
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}