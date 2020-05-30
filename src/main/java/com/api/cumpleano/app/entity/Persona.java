package com.api.cumpleano.app.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "El Campo nombre es Requerido")
	private String nombre;

	@NotBlank(message = "El Campo apellido es Requerido")
	private String apellido;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	private int edad;

	@Column(length = 3000)
	private String mensajeCumpleano;

	public Persona() {

	}

	public Persona(@NotBlank(message = "El Campo nombre es Requerido") String nombre,
			@NotBlank(message = "El Campo apellido es Requerido") String apellido, @NotNull Date fechaNacimiento) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getmensajeCumpleano() {
		return mensajeCumpleano;
	}

	public void setmensajeCumpleano(String mensajeCumpleano) {
		this.mensajeCumpleano = mensajeCumpleano;
	}

}
