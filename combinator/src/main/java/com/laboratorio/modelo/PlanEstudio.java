package com.laboratorio.modelo;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PlanEstudios")
public class PlanEstudio 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "PlanEstudios")
	List<Materia> materias;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "PlanEstudios")
	List<Materia> correlativas;
	
	public PlanEstudio(){
		
	}
	
	public PlanEstudio(List<Materia> materias, List<Materia> correlativas) //HashMap<Materia, Set<Materia>> correlativas 
	{
		super();
		this.materias = materias;
		this.correlativas = correlativas;
	}

	public List<Materia> getCorrelativas() 
	{
		return correlativas;
	}

	public void setCorrelativas(List<Materia> correlativas) 
	{
		this.materias = correlativas;
	}
	
	public List<Materia> getMaterias() 
	{
		return materias;
	}

	public void setMaterias(List<Materia> materias) 
	{
		this.materias = materias;
	}
	
}
