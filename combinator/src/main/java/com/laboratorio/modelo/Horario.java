package com.laboratorio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_horario;
	
	private int horaInicio;
	private int horaFin;
	private String dia;
	
	
	public Horario(){
		
	}
	public Horario(String dia, String turno)
	{
		this.dia = dia;
		 if(turno.equals("M"))
		 {
			 this.horaInicio = 8;
			 this.horaFin = 12;
		 }
		 else if(turno.equals("T"))
		 {
			 this.horaInicio = 13;
			 this.horaFin = 17;
		 }
		 else
		 {
			 this.horaInicio = 18;
			 this.horaFin = 22;
		 }
		 
	}

	public int getId() 
	{
		return id_horario;
	}

	public void setId(int id) 
	{
		this.id_horario = id;
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
	
	public String getDia()
	{
		return dia;
	}
	
	public void setDia(String dia)
	{
		this.dia = dia;
	}
	
	
	
	
}
