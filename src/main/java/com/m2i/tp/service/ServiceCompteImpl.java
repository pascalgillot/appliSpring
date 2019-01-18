package com.m2i.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m2i.tp.dao.DaoCompte;
import com.m2i.tp.entity.Compte;


@Service //heritant de @Component
@Transactional
public class ServiceCompteImpl implements ServiceCompte {
	
	//NB: daoCompte pourra référencer une instance
	//de type Daocompte ou bien DaoCompteJpa
	
	
	private DaoCompte daoCompte; //dao vers lequel déléguer
	
	//Methode d'injection de dependance
	@Autowired // ici ou bien directement au dessus de private
	//Autowired ressemble à @EJB ou @Inject de DI/CDI
	//eet demande à injecter un composant spring existant compatible avec l 'interface DaoCompte
	public void setDaoCompte(DaoCompte daocompte) {
		this.daoCompte = daocompte;
	}

	@Override
	public Compte rechercherCompteParNumero(Long numero) {
		
		return daoCompte.findCompteByNumero(numero);
	}

	@Override
	public void saveOrUpdateCompte(Compte cpt) {
		if(cpt.getNumero()==null) {
			daoCompte.createCompte(cpt);
		}else
			daoCompte.createCompte(cpt);

	}

	@Override
	public void transferer(Double montant, Long numCptDeb, Long numCptCred) {
		Compte cptDeb = daoCompte.findCompteByNumero(numCptDeb);
		cptDeb.setSolde(cptDeb.getSolde() - montant);
		daoCompte.updateCompte(cptDeb); // uniquement necessaire en mode non @transactionnnel
										// non persistent
		Compte cptCred = daoCompte.findCompteByNumero(numCptCred);
		cptDeb.setSolde(cptCred.getSolde() - montant);
		daoCompte.updateCompte(cptCred);
	}

}
