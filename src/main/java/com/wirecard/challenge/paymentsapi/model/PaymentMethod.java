package com.wirecard.challenge.paymentsapi.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/* Classe que define e armazena o método de pagamento, assim como o Cartão de Crédito
ou o boleto */

@Entity
public class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="method")
	private Method method;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "creditCard_id")
	private CreditCard creditCard;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "boleto_id")
	private Boleto boleto;
	
	public enum Method{
		CREDIT_CARD,
		BOLETO;
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Method getMethod() {
		return method;
	}



	public void setMethod(Method method) {
		this.method = method;
	}



	public CreditCard getCreditCard() {
		return creditCard;
	}



	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}



	public Boleto getBoleto() {
		return boleto;
	}



	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}



	@Override
	public String toString() {
		return "PaymentMethod [id=" + id + ", method=" + method + ", creditCard=" + creditCard + ", boleto=" + boleto
				+ "]";
	}
	
	
}
