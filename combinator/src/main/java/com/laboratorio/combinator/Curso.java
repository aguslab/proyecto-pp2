package com.laboratorio.combinator;

import java.util.HashMap;

public class Curso {
	private int id;
	private Carrera carrera;
	private Materia materia;
	private HashMap<String, Turno> dia_Hor;

	
	public Curso(Materia materia, HashMap<String, Turno> dia_Hor) {
		super();
		this.materia = materia;
		this.dia_Hor = dia_Hor;
	}

	public HashMap<String, Turno> getDia_Hor() {
		return dia_Hor;
	}

	public void setDia_Hor(HashMap<String, Turno> dia_Hor) {
		this.dia_Hor = dia_Hor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	
	
	
	
}
