package com.wirecard.challenge.paymentsapi.controller;

import com.wirecard.challenge.paymentsapi.model.Boleto;
import org.springframework.web.bind.annotation.RestController;

/** Classe responsável por controlar operações e requisições referentes aos Boletos
 *
 *
 */

@RestController
public class BoletoController {
	
	public Boleto createBoleto(String code, String expDate) {
		Boleto boleto = new Boleto();
		boleto.setCode(code);
		boleto.setExpirationDate(expDate);
		
		return boleto;
		
	}

}
