package com.m2i.tp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.entity.Client;

@Repository
@Transactional 
public class DaoClientJpa implements DaoClient {
	
	@PersistenceContext
	
	private EntityManager entityManager;

	@Override
	public Client findClientByNumero(Long numero) {
		
		return entityManager.find(Client.class,numero);
	}

	@Override
	public List<Client> findAllClient() {
		
		return entityManager.createQuery("select c FROM Client c",Client.class)
				.getResultList();
	}

	@Override
	public void updateClient(Client cli) {
		entityManager.merge(cli);

	}

	@Override
	public void createClient(Client cli) {
		entityManager.persist(cli);

	}

	@Override
	public void deleteClient(Long numero) {
		Client cli = entityManager.find(Client.class, numero);
		entityManager.remove(cli);

	}

}
