package com.laboratorio.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cursos")
public class Curso 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade={CascadeType.ALL}) //TODO: cambiar a manyToOne cuando hayas mas carreras?
	private Materia materia;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Horario> horario;

	public Curso() 
	{

	}
	
	public Curso(Materia materia, List<Horario> horario) 
	{
		super();
		this.materia = materia;
		this.horario = horario;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public Materia getMateria() 
	{
		return materia;
	}

	public void setMateria(Materia materia) 
	{
		this.materia = materia;
	}

	public List<Horario> getHorario()
	{
		return horario;
	}

	public void setHorario(List<Horario> horario)
	{
		this.horario = horario;
	}

	
	
	
	
	
}
