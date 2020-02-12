package com.wirecard.challenge.paymentsapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Classe que representa o proprietário do Cartão de Crédito//
@Entity
public class Holder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	// Data de Nascimento //
	
	@Column(name="birthDate")
	private String birthDate;
	
	//Número do documento //
	
	@Column(name="documentNumber")
	private String documentNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	@Override
	public String toString() {
		return "Holder [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", documentNumber=" + documentNumber
				+ "]";
	}
	
	
}
