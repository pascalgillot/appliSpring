package com.m2i.tp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity
public class Client {
	@Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	@Column(length=32)
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(name = "Client_Compte",
		joinColumns = {@JoinColumn(name = "client_id")},
		inverseJoinColumns = {@JoinColumn(name = "compte_id")})
	private List<Compte> comptes;
	
	public Client() {
		super();
	}

	public Client(Long numero, String nom, String prenom, String email, String telephone) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [numero=" + numero + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + "]";
	}
	
	
	

}
