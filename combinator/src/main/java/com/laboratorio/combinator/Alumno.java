package com.laboratorio.combinator;

import java.util.HashSet;
import java.util.Set;

public class Alumno {
	private int id;
	private String nombre;
	private Set<Materia> materiasAprob; //TODO: cambiar! no es el alumno quien almacena las materias aprobadas!
	
	public Alumno(String nombre) {
		this.nombre = nombre;
		this.materiasAprob = new HashSet<Materia>();
	}
	
	public Alumno(String nombre, Set<Materia> materiasAprob) {
		this.nombre = nombre;
		this.materiasAprob = materiasAprob;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Materia> getMateriasAprob() {
		return materiasAprob;
	}
	public void setMateriasAprob(Set<Materia> materiasAprob) {
		this.materiasAprob = materiasAprob;
	}
	
	
}
