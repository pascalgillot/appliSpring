package com.m2i.tp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity
public class Compte {

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
   
   @Column(length=32)
	private String label;
	private Double solde;

	public Long getNumero() {
		return numero;
	}

	public Compte() {
		super();
	}

	public Compte(Long numero, String label, Double solde) {
		super();
		this.numero = numero;
		this.label = label;
		this.solde = solde;
	}

	

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", label=" + label + ", solde=" + solde + "]";
	}

	// getters setters

}
