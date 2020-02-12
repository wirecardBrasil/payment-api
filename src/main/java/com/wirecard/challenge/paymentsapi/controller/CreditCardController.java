package com.wirecard.challenge.paymentsapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.wirecard.challenge.paymentsapi.model.CreditCard;
import com.wirecard.challenge.paymentsapi.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/** Classe responsável por controlar operações e requisições referentes aos Cartões
 *
 *
 */

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {
	
	@Autowired
	private CreditCardRepository cr;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<CreditCard> listaCreditCards() {
		Iterable<CreditCard> listaCreditCards = cr.findAll();
		return listaCreditCards;
	}

	@PostMapping()
	public CreditCard cadastrarCreditCard(@RequestBody @Valid CreditCard creditCard) {
		return cr.save(creditCard);
	}

	@DeleteMapping()
	public CreditCard deletarCreditCard(@RequestBody CreditCard creditCard) {
		cr.delete(creditCard);
		return creditCard;
	}
	

	public boolean creditCardExists(CreditCard creditCard) {
		List<CreditCard> crl = cr.findAll();
		
		for (CreditCard card : crl) {
			if(card.getCardNumber().equals(creditCard.getCardNumber())) {
				return true;
			}
		}
		return false;
	}

	public boolean validarNumeroCartao(String cartaoNumero) {
		if(cartaoNumero.length()== 16 && cartaoNumero.matches("[0-9]*")) {
			return true;
		} 
		return false;
	}

	public boolean validarDV(String dv) {
		if(dv.length()== 3 && dv.matches("[0-9]*")){
			return true;
			
		}
		return false;
	}
}
