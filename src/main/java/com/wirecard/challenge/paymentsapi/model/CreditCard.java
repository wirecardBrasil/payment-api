package com.wirecard.challenge.paymentsapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

/* Classe que representa o Cartão de Crédito utilizado nos pagamentos,
pelos compradores */

@Entity
public class CreditCard {

	@Id 
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	//Bandeira do cartão, ex: Visa, MasterCard, etc..//
	
	@Column(name="brand")
	private String brand;
	
	//Proprietário do cartão de crédito (nome impresso) //
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "holder_id")
	private Holder holder;
	
	//Número do cartão de crédito//
	
	@NotBlank(message="Favor preencher o número do cartão. ")
	@Column(name="cardNumber")
	private String cardNumber;
	
	//Data de validade do cartão de crédito//
	
	@Column(name="expirationDate")
	private String expirationDate;
	
	//Código verificador do cartão//
	
	@NotBlank(message="Favor preencher o CVV")
	@Column(name="cvv")
	private String cvv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Holder getHolder() {
		return holder;
	}

	public void setHolder(Holder holder) {
		this.holder = holder;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", brand=" + brand + ", cardNumber=" + cardNumber + ", expirationDate="
				+ expirationDate + ", cvv=" + cvv + "]";
	}
	
	
}
