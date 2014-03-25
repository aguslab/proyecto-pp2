package com.laboratorio.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="turnos")
public class Turno implements Serializable
{
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private int id;
	private int horaInicio;
	private int horaFin;
	
	public Turno(){
		
	}
	public Turno(String turno)
	{
		 if(turno.equals("M"))
		 {
			 this.horaInicio = 8;
			 this.horaFin = 13;
		 }
		 else if(turno.equals("T"))
		 {
			 this.horaInicio = 13;
			 this.horaFin = 18;
		 }
		 else
		 {
			 this.horaInicio = 18;
			 this.horaFin = 22;
		 }
		 
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getHoraInicio() 
	{
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) 
	{
		this.horaInicio = horaInicio;
	}

	public int getHoraFin() 
	{
		return horaFin;
	}

	public void setHoraFin(int horaFin) 
	{
		this.horaFin = horaFin;
	}
	
	
}
