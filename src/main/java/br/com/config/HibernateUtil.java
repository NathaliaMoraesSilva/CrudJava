package br.com.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("config");

    public static EntityManager getSessionFactory() {
        return emf.createEntityManager();
    }
}
