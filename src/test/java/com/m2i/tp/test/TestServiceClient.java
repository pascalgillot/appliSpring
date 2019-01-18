package com.m2i.tp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.m2i.tp.config.AppConfig;
import com.m2i.tp.entity.Client;
import com.m2i.tp.entity.Compte;
import com.m2i.tp.service.ServiceClient;
import com.m2i.tp.service.ServiceCompte;

//nécessite spring-test dans pom.xml
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/mySpringConf.xml")
@ContextConfiguration(classes= {AppConfig.class})
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceClient {
	@Autowired
	private ServiceClient serviceClient ; //à tester
	
	@Autowired
	private ServiceCompte serviceCompte ; //annexe pour tester
	
	@Test
	public void Test_compte_du_client() {
		Client cli = new Client(null,"Teddy","riner","0102030405" ,"teddy.riner@ici_ou_la.fr");
		serviceClient.saveOrUpdateClient(cli);
		
		Compte cptA = new Compte(null,"compte A",100.0);
		this.serviceCompte.saveOrUpdateCompte(cptA);
		
		Compte cptB = new Compte(null,"compte B",100.0);
		this.serviceCompte.saveOrUpdateCompte(cptB);
		
		serviceClient.ajouterComptePourClient(cli.getNumero(), cptA.getNumero());
		serviceClient.ajouterComptePourClient(cli.getNumero(), cptB.getNumero());
		//partie haute du test à reporter dans une initialisation de la partie web/jsf (ex: @PostConstruct)
		//------------------------
		//partie basse du test servant d'inspairation pour coder l'action d'un managedBean
		
		List<Compte> listeComptes = serviceClient.rechercherComptesDuClient(cli.getNumero());
		System.out.println("comptes du client:" + listeComptes);
		Assert.assertTrue(listeComptes.size()==2);
		
	}

}
