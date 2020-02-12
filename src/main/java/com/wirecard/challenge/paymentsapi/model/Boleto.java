package com.wirecard.challenge.paymentsapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


// Classe que representa a forma de pagamento "BOLETO"//
@Entity
public class Boleto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	//Código de pagamento do boleto
	
	@Column(name="code")
	private String code;

	//Data de vencimento do boleto.

	@Column(name="expirationDate")
	private String expirationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public String toString() {
		return "Boleto [id=" + id + ", code=" + code + ", expirationDate=" + expirationDate + "]";
	}
	
	
}
