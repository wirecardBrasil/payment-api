package com.wirecard.challenge.paymentsapi.controller;

import javax.validation.Valid;

import com.wirecard.challenge.paymentsapi.model.Holder;
import com.wirecard.challenge.paymentsapi.repository.HolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** Classe responsável por controlar operações e requisições referentes aos Holders
 *
 *
 */

@RestController
@RequestMapping("/holder")
public class HolderController {

	@Autowired
	private HolderRepository hr;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Holder> listaHolders() {
		Iterable<Holder> listaHolders = hr.findAll();
		return listaHolders;
	}

	@PostMapping()
	public Holder cadastrarHolder(@RequestBody @Valid Holder holder) {
		return hr.save(holder);
	}

	@DeleteMapping()
	public Holder deletarHolder(@RequestBody Holder holder) {
		hr.delete(holder);
		return holder;
	}
}
