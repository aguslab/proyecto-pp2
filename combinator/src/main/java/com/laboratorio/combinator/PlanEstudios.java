package com.laboratorio.combinator;

import java.util.HashMap;
import java.util.Set;

public class PlanEstudios {
	private HashMap<Materia,Set<Materia>> correlativas;

	public PlanEstudios(HashMap<Materia, Set<Materia>> correlativas) {
		super();
		this.correlativas = correlativas;
	}

	public HashMap<Materia, Set<Materia>> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(HashMap<Materia, Set<Materia>> correlativas) {
		this.correlativas = correlativas;
	}
	
	
}
