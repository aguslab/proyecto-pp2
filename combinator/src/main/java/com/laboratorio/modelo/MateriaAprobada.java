package com.laboratorio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Materias_Aprobadas")
public class MateriaAprobada 
{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	@OneToOne
	/*<class name="MateriaAprobada" table="Materias_Aprobadas">
	<set name="id_materia" table="Materias_Aprobadas"> 
	<key column="fk_mat_aprobada"/>
	<one-to-one name="matAprobada" class="mx.model.Materia" /></class>*/
	private Materia matAprobada;
	private double nota;

	public MateriaAprobada()
	{
		
	}
	
	public MateriaAprobada(Materia materia, double nota) 
	{
		this.matAprobada = materia;
		this.nota= nota;
	}
	
	public MateriaAprobada(int i, double nota) 
	{
		this.nota = nota;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public double getNota() 
	{
		return nota;
	}

	public void setNota(double nota)
	{
		this.nota = nota;
	}

	public Materia getMateriaAprobada() 
	{
		return matAprobada;
	}

	public void setNota(Materia matAprobada)
	{
		this.matAprobada = matAprobada;
	}
}
