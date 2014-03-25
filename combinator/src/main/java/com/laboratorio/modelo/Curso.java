package com.laboratorio.modelo;

import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Cursos")
public class Curso 
{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}) // Sirve para borrar, se puede sacar creo
	private Materia materia;
//	@ElementCollection
//    @MapKeyColumn(name="name")
//    @Column(name="value")
//    @CollectionTable(name="Cursos", joinColumns=@JoinColumn(name="dia_horario"))
	private HashMap<String, Turno> dia_horario;

	public Curso() {

	}
	
	public Curso(Materia materia, HashMap<String, Turno> dia_Hor) 
	{
		super();
		this.materia = materia;
		this.dia_horario = dia_Hor;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public HashMap<String, Turno> getDia_Hor() 
	{
		return dia_horario;
	}

	public void setDia_Hor(HashMap<String, Turno> dia_Hor) 
	{
		this.dia_horario = dia_Hor;
	}

	public Materia getMateria() 
	{
		return materia;
	}

	public void setMateria(Materia materia) 
	{
		this.materia = materia;
	}

	
	
	
	
}
