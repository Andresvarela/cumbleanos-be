package com.api.cumpleano.app.controller;

import java.util.Date;

import javax.validation.Valid;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.api.cumpleano.app.entity.Persona;
import com.api.cumpleano.app.repository.PersonaRepository;
import com.api.cumpleano.app.service.PersonaServiceImpl;
import com.api.cumpleano.app.utils.Util;

@SpringBootTest
public class PersonaControllerTest {

	@InjectMocks
	PersonaController controller;

	@Mock
	Util util;

	@Mock
	PersonaServiceImpl personaServiceImpl;

	@Mock
	PersonaRepository personaRepository;

	String mustAnull = "Must a null";
	String mustBeANotnull = "Must be a not null";

	@Test
	public void personaControllerTest() {

		@Valid
		Persona persona = new Persona();

		Date fechaN = new Date();
		int edad = 28;
		persona.setNombre("Andres");
		persona.setId(1);
		persona.setApellido("Varela");
		persona.setEdad(28);
		persona.setFechaNacimiento(fechaN);

		Mockito.when(util.getEdad(Mockito.any(Date.class))).thenReturn(edad);
		Mockito.when(util.calcularCumple(Mockito.any(Persona.class), Mockito.any(Date.class))).thenReturn(persona);
		Mockito.when(personaRepository.save(Mockito.any(Persona.class))).thenReturn(persona);
		Mockito.when(personaServiceImpl.savePersona(Mockito.any(Persona.class))).thenReturn(persona);

		ResponseEntity<Persona> rs = controller.agregarPersona(persona);
		Assert.assertNotNull(mustBeANotnull, rs);
	}
}
