package br.com.gerenciadorcampeonatos.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.gerenciadorcampeonatos.modelo.Time;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class TimeService implements Serializable {

	@Inject
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Time salvar(Time time) {
		entityManager.persist(time);
		entityManager.flush();
		return time;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public Time atualizar(Time time) {
		return entityManager.merge(time);
	}

	public List<Time> buscarTodos() {
		List<Time> times = entityManager.createQuery("select t from Time t", Time.class).getResultList();
		System.out.println("size: " + times.size());
		return times;
	}

	public Time buscarPorId(Long id){
		return entityManager.find(Time.class, id);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void excluir(Time time) {
		entityManager.remove(entityManager.contains(time) ? time : entityManager.merge(time));
	}
	
	
	

}
