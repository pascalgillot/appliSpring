package com.m2i.tp.service;

import java.util.List;

import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Compte;

public interface ServiceClient {
	
	public Client rechercherClientById(Long numero);
	
	public void saveOrUpdateClient(Client cli);
	
	public void ajouterComptePourClient(long numCliExistant,long numCptExistant);

	public List<Compte> rechercherComptesDuClient(Long numero);
	
	// verifier String identiteClient
	

}
