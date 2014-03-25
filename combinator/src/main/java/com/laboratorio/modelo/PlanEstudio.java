package com.laboratorio.modelo;

import java.util.HashMap;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
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
	private HashMap<Materia,Set<Materia>> correlativas;

	public PlanEstudio(HashMap<Materia, Set<Materia>> correlativas) 
	{
		super();
		this.correlativas = correlativas;
	}

	public HashMap<Materia, Set<Materia>> getCorrelativas() 
	{
		return correlativas;
	}

	public void setCorrelativas(HashMap<Materia, Set<Materia>> correlativas) 
	{
		this.correlativas = correlativas;
	}
	
}
