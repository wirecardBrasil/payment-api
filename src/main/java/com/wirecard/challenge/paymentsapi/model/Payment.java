package com.wirecard.challenge.paymentsapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

//Classe que representa o pagamento realizado //

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//Quantia R$ do pagamento//
	
	@NotNull
	@Column(name="amount")
	private Double amount;
	
	//Define e armazena o método de pagamento//
	
	@NotNull
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "paymentMethod_id")
	private PaymentMethod paymentMethod;
	
	//Define o Status do pagamento//
	
	@Column(name="status")
	private PaymentStatus status;
	

	@ManyToOne
	@JoinColumn(name="buyer_id", referencedColumnName="buyer_id")
	private Buyer buyer;
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="client_id")
	private Client client;
	
	public enum PaymentStatus {

		CREATED,
		IN_ANALYSIS,
		AUTHORIZED,
		CANCELLED,
		SETTLED;
			
	}
	

	public Payment() {
		super();
	}

	public Payment(Double amount, @NotNull PaymentMethod paymentMethod, PaymentStatus status, Buyer buyer,
			Client client) {
		super();

		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.buyer = buyer;
		this.client = client;
	}

	public Payment(double d, PaymentStatus created, Buyer buyer2, Client client2) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	// Adicionar o Amount //
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	// Pegar o Buyer //
	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", status=" + status
				+ ", buyer=" + buyer + ", client=" + client + "]";
	}
	
	
}
