package com.wirecard.challenge.paymentsapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

//Classe que representa o comprador//

@Entity
public class Buyer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="buyer_id")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="nome")
	private String nome;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Buyer [id=" + id + ", email=" + email + ", cpf=" + cpf + ", nome=" +" nome] ";
	}
	
	
	

}
