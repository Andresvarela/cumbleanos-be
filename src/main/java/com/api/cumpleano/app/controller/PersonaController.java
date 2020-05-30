package com.api.cumpleano.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.cumpleano.app.entity.Persona;
import com.api.cumpleano.app.service.PersonaService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PersonaController {

	@Autowired
	private PersonaService service;

	public PersonaController(PersonaService service) {
		this.service = service;
	}

	@PostMapping("/persona")
	public ResponseEntity<Persona> agregarPersona(@Valid @RequestBody Persona persona) {

		Persona personaNueva = new Persona();

		try {
			personaNueva = service.savePersona(persona);

		} catch (Exception e) {
			return new ResponseEntity<Persona>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Persona>(personaNueva, HttpStatus.CREATED);
	}

}
