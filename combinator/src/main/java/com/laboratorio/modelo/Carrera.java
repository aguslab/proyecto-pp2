package com.laboratorio.modelo;

public class Carrera {
	private int id;
	private String nombre;
	private PlanEstudio planEstudios;
	
	
	public Carrera(int id, String nombre, PlanEstudio planEstudios) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.planEstudios = planEstudios;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public PlanEstudio getPlanEstudios() {
		return planEstudios;
	}


	public void setPlanEstudios(PlanEstudio planEstudios) {
		this.planEstudios = planEstudios;
	}
	
}
