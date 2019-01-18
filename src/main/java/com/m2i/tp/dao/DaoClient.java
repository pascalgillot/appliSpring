package com.m2i.tp.dao;

import java.util.List;

import com.m2i.tp.entity.Client;

public interface DaoClient {
	public Client findClientByNumero(Long numero);
	public List<Client> findAllClient();
	
	public void updateClient(Client cli);

	public void createClient(Client cli);

	public void deleteClient(Long numero);

}
