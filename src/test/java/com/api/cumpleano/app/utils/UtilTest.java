package com.api.cumpleano.app.utils;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.cumpleano.app.entity.Persona;

@SpringBootTest
public class UtilTest {

	String mustAnull = "Must a null";
	String mustBeANotnull = "Must be a not null";

	@Autowired
	Util util;

	@Test
	public void getEdadTest() {

		Persona persona = new Persona();
		Date fechaNacimiento = new Date();
		persona.setFechaNacimiento(fechaNacimiento);

		int rs = util.getEdad(fechaNacimiento);
		assertNotNull(mustBeANotnull, rs);

	}

	@Test
	public void calcularCumpleTest() {

		Persona persona = new Persona();
		Date fechaNacimiento = new Date();
		persona.setNombre("Andres");
		persona.setApellido("Varela");
		persona.setFechaNacimiento(fechaNacimiento);
		persona.setEdad(28);

		Persona newPersona = new Persona();
		newPersona = util.calcularCumple(persona, fechaNacimiento);
		assertNotNull(mustBeANotnull, newPersona);

	}
}
