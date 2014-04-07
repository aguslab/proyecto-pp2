package com.laboratorio.modelo;

import java.util.HashMap;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PlanEstudios")
public class PlanEstudio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false, columnDefinition = "blob")
	private HashMap<Materia, Set<Materia>> correlativas;

	public PlanEstudio(){
		
	}
	
	public PlanEstudio(HashMap<Materia, Set<Materia>> correlativas) {
		super();
		this.correlativas = correlativas;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public HashMap<Materia, Set<Materia>> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(HashMap<Materia, Set<Materia>> correlativas) {
		this.correlativas = correlativas;
	}
	
	public boolean tieneCorrelativas(Materia materiaACursar, Set<Materia> materiasAprobadas){
    	//SIEMPRE deberia tenerlo, si no es algun problema nuestro
    	if(this.correlativas.containsKey(materiaACursar)){
    		if(materiaACursar.getNombre().equals("Laboratorio Interdisciplinario")){
    			return materiasAprobadas.size() >= 11;
    		}
    		return materiasAprobadas.containsAll(this.correlativas.get(materiaACursar));
    	}
    	
    	return false;
    }

}
