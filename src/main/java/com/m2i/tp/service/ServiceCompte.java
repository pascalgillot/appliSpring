package com.m2i.tp.service;

import com.m2i.tp.entity.Compte;

/**
 * 
 * Interface du "Business Service" (Service metier) "ServiceCompte" comportant:
 * - des donées Crud déléguées au DAO * 
 * - des methodes assocciées à des règles * de * gestions (verif ...) 
 * - des methodes avec des methodes de transactions
 * - des * methodes specifiques au metier
 */

public interface ServiceCompte {

	public Compte rechercherCompteParNumero(Long numero);

	// ...
	public void saveOrUpdateCompte(Compte cpt);

	// public boolean verifierDecouvertAutorisé();
	public void transferer(Double montant, Long numCpDeb, Long numCptCred);

}
