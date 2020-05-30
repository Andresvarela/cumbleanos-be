/**
 * 
 */
package com.api.cumpleano.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cumpleano.app.entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	Persona findByNombre(String nombre);
	

}
