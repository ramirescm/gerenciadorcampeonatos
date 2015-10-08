package br.com.gerenciadorcampeonatos.service;

import br.com.gerenciadorcampeonatos.modelo.Time;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TimeService {
    @PersistenceContext
    private EntityManager entityManager;
    
    public void salvar(Time time){
        entityManager.persist(time);
    }    
    
    
    
    
}
