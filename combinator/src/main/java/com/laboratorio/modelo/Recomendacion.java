package com.laboratorio.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Recomendacion 
{
	private String[] dias;
	private String[] horarios;
	
	public Recomendacion(String[] dias, String[] horariosOcupados) 
	{
		this.dias = dias;
		this.horarios = horariosOcupados;
	}

	public String[] getHorarios() 
	{
		return horarios;
	}
	public void setHorarios(String[] horarios) 
	{
		this.horarios = horarios;
	}
	public String[] getDias() 
	{
		return dias;
	}
	public void setDias(String[] dias) 
	{
		this.dias = dias;
	}
}
