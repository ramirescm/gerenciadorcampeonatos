package br.com.gerenciadorcampeonatos.core;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @PersistenceContext(unitName = "gecampeonatoPU")
    private EntityManager em;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return em;
    }

}
