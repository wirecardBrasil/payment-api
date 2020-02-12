package com.wirecard.challenge.paymentsapi.controller;

import javax.validation.Valid;

import com.wirecard.challenge.paymentsapi.model.PaymentMethod;
import com.wirecard.challenge.paymentsapi.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** Classe responsável por controlar as operações referentes a PaymentMethod
 *
 *
 */

@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodController {
	
	@Autowired
	private PaymentMethodRepository pmr;
	

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<PaymentMethod> listaPaymentMethods() {
		Iterable<PaymentMethod> listaPaymentMethods = pmr.findAll();
		return listaPaymentMethods;
	}
	

	@PostMapping()
	public PaymentMethod cadastrarPaymentMethod(@RequestBody @Valid PaymentMethod paymentMethod) {
		return pmr.save(paymentMethod);
	}
	

	@DeleteMapping()
	public PaymentMethod deletarPayment(@RequestBody PaymentMethod paymentMethod) {
		pmr.delete(paymentMethod);
		return paymentMethod;
	}
}
