package com.laboratorio.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="PlanEstudios")
public class PlanEstudio 
{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
//	@ElementCollection  
//    @MapKeyColumn(name="name")
//    @Column(name="value")
//    @CollectionTable(name="PlanEstudios", joinColumns=@JoinColumn(name="id_planEstudio"))
	@OneToMany
    @JoinTable(name = "PlanEstudios")
	List<Materia> materias;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "PlanEstudios")
	List<Materia> correlativas;
	
	public PlanEstudio()
	{
		
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
