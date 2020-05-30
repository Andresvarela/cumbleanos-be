package com.api.cumpleano.app.respository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.cumpleano.app.entity.Persona;
import com.api.cumpleano.app.repository.PersonaRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class PesonaRepositoryTest {

	@Autowired
	private PersonaRepository personaRepository;

	@Test
	public void savePersona() {

		Date hoy = new Date();
		Persona persona = new Persona("Andres", "Varela", hoy);
		personaRepository.save(persona);
		Persona personaTest = personaRepository.findByNombre("Andres");
		assertNotNull(persona);
		assertEquals(personaTest.getNombre(), persona.getNombre());
		assertEquals(personaTest.getApellido(), persona.getApellido());
		assertEquals(personaTest.getFechaNacimiento(), persona.getFechaNacimiento());
	}
}
