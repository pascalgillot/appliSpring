package com.m2i.tp.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoClient;
import com.m2i.tp.dao.DaoCompte;
import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Compte;

@Service
@Transactional
public class ServiceClientImpl implements ServiceClient {
	
	@Autowired
	private DaoClient daoClient; //dao vers lequel déléguer
	
	@Autowired
	private DaoCompte daoCompte; //dao vers lequel déléguer

	@Override
	public Client rechercherClientById(Long numero) {
		
		return daoClient.findClientByNumero(numero);
	}

	@Override
	public void saveOrUpdateClient(Client cli) {
		if(cli.getNumero()==null) {
			daoClient.createClient(cli);
		}else
			daoClient.createClient(cli);

	}

	@Override
	public void ajouterComptePourClient(long numCliExistant,long numCptExistant) {
		Client cli = daoClient.findClientByNumero(numCliExistant);
		Compte cpt = daoCompte.findCompteByNumero(numCptExistant);
		cli.getComptes().add(cpt); //cpt relié à cli en mémoire
		daoClient.updateClient(cli);
	}
	
	public static void loadNowInMemoryLazyCollection(Collection col) {
		col.size(); //en appelant .size() sur une collection JPA/Hib en mode lazy
		//ça provoque un parcours de la collection pour connaître la taille 
		//et ca déclenche immédiatement une remontée des objets des tables vers le mémoire
	}

	@Override
	public List<Compte> rechercherComptesDuClient(Long numero) {
		Client cli = daoClient.findClientByNumero(numero);
		List<Compte> listeCompte = cli.getComptes();
		loadNowInMemoryLazyCollection(listeCompte);
		return listeCompte;
	}

	

}
