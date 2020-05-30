package com.api.cumpleano.app.service;

import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.cumpleano.app.entity.Persona;
import com.api.cumpleano.app.repository.PersonaRepository;
import com.api.cumpleano.app.utils.Util;

@SpringBootTest
public class PersonaServiceImplTest {

	String mustAnull = "Must a null";
	String mustBeANotnull = "Must be a not null";
	
	@Mock
	private PersonaRepository personaRepository;

	@InjectMocks
	PersonaServiceImpl personaServiceImpl;

	@Mock
	private Util util;

	@Test
	public void savePersonaTest() {

		Persona persona = new Persona();
		Date fechaNacimiento = new Date();
		Persona newPersona = new Persona();
		persona.setFechaNacimiento(fechaNacimiento);
		
		Mockito.when((personaRepository.save(Mockito.any(Persona.class)))).thenReturn(persona);
				
		newPersona = personaServiceImpl.savePersona(persona);
		assertNull(mustAnull, newPersona);

	}
}
