package com.wirecard.challenge.paymentsapi.controller;

import javax.validation.Valid;

import com.wirecard.challenge.paymentsapi.model.Client;
import com.wirecard.challenge.paymentsapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/** Classe responsável por controlar as operações e requisições referentes ao Cliente
 *
 *
 */

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientRepository cr;

	@GetMapping(produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Iterable<Client> listaClients() {
		Iterable<Client> listaClients = cr.findAll();
		return listaClients;
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public Client cadastrarClient(@RequestBody @Valid Client client) {
		return cr.save(client);
	}

	@DeleteMapping()
	@ResponseStatus(HttpStatus.OK)
	public Client deletarClient(@RequestBody Client client) {
		cr.delete(client);
		return client;
	}
}
