package com.laboratorio.combinator;

public class Curso {
	private Materia materia;
	private Turno horario;
	//TODO: falta el horario o cambiar turno por el verdadero horario que se dicta la meteria!!!

	public Curso(Materia materia, Turno horario) {
		this.materia = materia;
		this.horario = horario;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Turno getHorario() {
		return horario;
	}

	public void setHorario(Turno horario) {
		this.horario = horario;
	}
	
	
	
	
}
