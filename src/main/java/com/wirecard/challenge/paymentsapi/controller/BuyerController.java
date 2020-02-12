package com.wirecard.challenge.paymentsapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.wirecard.challenge.paymentsapi.model.Buyer;
import com.wirecard.challenge.paymentsapi.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**Classe responsável por controlar operações e requisições referentes ao Buyer
 *
 *
 */

@RestController
public class BuyerController {
	
	@Autowired
	private BuyerRepository br;
	
	@GetMapping(path="/buyer", produces="application/json")
	public @ResponseBody Iterable<Buyer> listaBuyers() {
		Iterable<Buyer> listaBuyers = br.findAll();
		return listaBuyers;
	}

	@GetMapping("/buyer/{id}")
	public ResponseEntity getBuyer(@PathVariable("id") Long id){
			List<Buyer> listaBuyer = br.findAll();
			Buyer buyerProcurado = null;
			
			for(Buyer buyer: listaBuyer){
				if(buyer.getId()==id) {
					buyerProcurado = buyer;
				}
			}
			
			if(buyerProcurado == null) {
				return new ResponseEntity("No Customer found for ID " + id, HttpStatus.BAD_GATEWAY);
			}
			return new ResponseEntity(buyerProcurado, HttpStatus.OK);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.OK)
	public Buyer cadastrarBuyer(@RequestBody @Valid Buyer buyer) {
		return br.save(buyer);
	}

	
	@DeleteMapping()
	public Buyer deletarBuyer(@RequestBody Buyer buyer) {
		br.delete(buyer);
		return buyer;
	}
}
