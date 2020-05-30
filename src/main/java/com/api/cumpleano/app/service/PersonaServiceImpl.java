package com.api.cumpleano.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.cumpleano.app.entity.Persona;
import com.api.cumpleano.app.repository.PersonaRepository;
import com.api.cumpleano.app.utils.Util;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private Util util;

	public Persona savePersona(Persona persona) {

		int edad = util.getEdad(persona.getFechaNacimiento());
		persona.setEdad(edad);
		Persona newPersona = util.calcularCumple(persona, persona.getFechaNacimiento());

		return personaRepository.save(newPersona);
	}
}
