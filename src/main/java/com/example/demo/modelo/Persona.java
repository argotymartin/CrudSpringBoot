package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String persona_identificacion;
	private String persona_nombre1;
	private String persona_nombre2;
	private String persona_apellido1;
	private String persona_apellido2;
	private String persona_telefono;
	private String persona_arl_ruta;
	private String persona_arl_archivo;
	private String persona_eps_ruta;
	private String persona_eps_archivo;


	public Persona() {
		super();
	}

	public Persona(int id, String persona_identificacion, String persona_nombre1, String persona_nombre2,String persona_apellido1, String persona_apellido2,
			String persona_telefono, String persona_arl_ruta, String persona_arl_archivo, String persona_eps_ruta, String persona_eps_archivo) {
		super();
		this.id = id;
		this.persona_identificacion = persona_identificacion;
		this.persona_nombre1 = persona_nombre1;
		this.persona_nombre2 = persona_nombre2;

		this.persona_apellido1 = persona_apellido1;
		this.persona_apellido2 = persona_apellido2;
		this.persona_arl_ruta = persona_arl_ruta;
		this.persona_arl_archivo = persona_arl_archivo;
		this.persona_eps_ruta = persona_eps_ruta;
		this.persona_eps_archivo = persona_eps_archivo;


		this.persona_telefono = persona_telefono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPersona_identificacion() {
		return persona_identificacion;
	}
	public void setPersona_identificacion(String persona_identificacion) {
		this.persona_identificacion = persona_identificacion;
	}
	public String getPersona_nombre1() {
		return persona_nombre1;
	}
	public void setPersona_nombre1(String persona_nombre1) {
		this.persona_nombre1 = persona_nombre1;
	}
	public String getPersona_nombre2() {
		return persona_nombre2;
	}
	public void setPersona_nombre2(String persona_nombre2) {
		this.persona_nombre2 = persona_nombre2;
	}
	public String getPersona_apellido1() {
		return persona_apellido1;
	}
	public void setPersona_apellido1(String persona_apellido1) {
		this.persona_apellido1 = persona_apellido1;
	}
	public String getPersona_apellido2() {
		return persona_apellido2;
	}
	public void setPersona_apellido2(String persona_apellido2) {
		this.persona_apellido2 = persona_apellido2;
	}

	public String getPersona_telefono() {
		return persona_telefono;
	}

	public void setPersona_telefono(String persona_telefono) {
		this.persona_telefono = persona_telefono;
	}

	public String getPersona_arl_ruta() {
		return persona_arl_ruta;
	}

	public void setPersona_arl_ruta(String persona_arl_ruta) {
		this.persona_arl_ruta = persona_arl_ruta;
	}

	public String getPersona_arl_archivo() {
		return persona_arl_archivo;
	}

	public void setPersona_arl_archivo(String persona_arl_archivo) {
		this.persona_arl_archivo = persona_arl_archivo;
	}

	public String getPersona_eps_ruta() {
		return persona_eps_ruta;
	}

	public void setPersona_eps_ruta(String persona_eps_ruta) {
		this.persona_eps_ruta = persona_eps_ruta;
	}

	public String getPersona_eps_archivo() {
		return persona_eps_archivo;
	}

	public void setPersona_eps_archivo(String persona_eps_archivo) {
		this.persona_eps_archivo = persona_eps_archivo;
	}




}
