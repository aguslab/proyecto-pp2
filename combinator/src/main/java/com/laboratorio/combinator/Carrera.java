package com.laboratorio.combinator;

public class Carrera {
	private int id;
	private String nombre;
	private PlanEstudios planEstudios;
	
	
	public Carrera(int id, String nombre, PlanEstudios planEstudios) {
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


	public PlanEstudios getPlanEstudios() {
		return planEstudios;
	}


	public void setPlanEstudios(PlanEstudios planEstudios) {
		this.planEstudios = planEstudios;
	}
	
}
