package com.laboratorio.modelo;

import java.util.ArrayList;
import java.util.List;

public class Recomendacion 
{
	String[] lunes = new String[4];
	String[] martes = new String[4];
	String[] miercoles = new String[4];
	String[] jueves = new String[4];
	String[] viernes = new String[4];
	String[] sabado = new String[4];
	
	public Recomendacion ()
	{
		
	}

	public Recomendacion(String[] l, String[] m, String[] mi, String[] j, String[] v, String[] s)
	{
		this.lunes = l;
		this.martes = m;
		this.miercoles = mi;
		this.jueves = j;
		this.viernes = v;
		this.sabado = s;
	}
	
	
	
	public String[] getLunes() 
	{
		return lunes;
	}

	public void setLunes(String[] lunes) 
	{
		this.lunes = lunes;
	}

	public String[] getMartes() 
	{
		return martes;
	}

	public void setMartes(String[] martes) 
	{
		this.martes = martes;
	}

	public String[] getMiercoles() 
	{
		return miercoles;
	}

	public void setMiercoles(String[] miercoles) 
	{
		this.miercoles = miercoles;
	}

	public String[] getJueves() 
	{
		return jueves;
	}

	public void setJueves(String[] jueves) 
	{
		this.jueves = jueves;
	}

	public String[] getViernes() 
	{
		return viernes;
	}

	public void setViernes(String[] viernes) 
	{
		this.viernes = viernes;
	}

	public String[] getSabado() 
	{
		return sabado;
	}

	public void setSabado(String[] sabado) 
	{
		this.sabado = sabado;
	}

	public void mostrarRecomendacion(Recomendacion recomendacion)
	{
		//Lunes
		if(recomendacion.getLunes()[0] != null)
		{
			System.out.println("Lunes " + recomendacion.getLunes()[0] + " Horario: " + recomendacion.getLunes()[1]);
		}
		if(recomendacion.getLunes()[2] != null) //Si es un horario partido
		{
			System.out.println("Lunes " + recomendacion.getLunes()[2] + " Horario: " + recomendacion.getLunes()[3]);
		}
		//Martes
		if(recomendacion.getMartes()[0] != null)
		{
			System.out.println("Martes " + recomendacion.getMartes()[0] + " Horario: " + recomendacion.getMartes()[1]);
		}
		if(recomendacion.getMartes()[2] != null) //Si es un horario partido
		{
			System.out.println("Martes " + recomendacion.getMartes()[2] + "Horario: " + recomendacion.getMartes()[3]);
		}
		//Miercoles
		if(recomendacion.getMiercoles()[0] != null)
		{
			System.out.println("Miercoles " + recomendacion.getMiercoles()[0] + " Horario: " + recomendacion.getMiercoles()[1]);
		}
		if(recomendacion.getMiercoles()[2] != null) //Si es un horario partido
		{
			System.out.println("Miercoles " + recomendacion.getMiercoles()[2] + " Horario: " + recomendacion.getMiercoles()[3]);
		}
		//Jueves
		if(recomendacion.getJueves()[0] != null)
		{
			System.out.println("Jueves " + recomendacion.getJueves()[0] + " Horario: " + recomendacion.getJueves()[1]);
		}
		if(recomendacion.getJueves()[2] != null) //Si es un horario partido
		{
			System.out.println("Jueves " + recomendacion.getJueves()[2] + " Horario: " + recomendacion.getJueves()[3]);
		}
		//Viernes
		if(recomendacion.getViernes()[0] != null)
		{
			System.out.println("Viernes " + recomendacion.getViernes()[0] + " Horario: " + recomendacion.getViernes()[1]);
		}
		if(recomendacion.getViernes()[2] != null) //Si es un horario partido
		{
			System.out.println("Viernes " + recomendacion.getViernes()[2] + " Horario: " + recomendacion.getViernes()[3]);
		}
		//Sabado
		if(recomendacion.getSabado()[0] != null)
		{
			System.out.println("Sabado " + recomendacion.getSabado()[0] + " Horario: " + recomendacion.getSabado()[1]);
		}
		if(recomendacion.getSabado()[2] != null) //Si es un horario partido
		{
			System.out.println("Sabado " + recomendacion.getSabado()[2 ] + " Horario: " + recomendacion.getLunes()[3]);
		}
	}
	
	@SuppressWarnings("null")
	public static ArrayList<String> armarRecomendacion(ArrayList<Recomendacion> recomendaciones)
	{
		ArrayList<String> recomendacionesParaLista = new ArrayList<String>();
		for (Recomendacion r : recomendaciones)
		{
			String recoParaLista = "";
			//Lunes
			if(r.getLunes()[0] != null)
			{
				recoParaLista += " Lunes " + r.getLunes()[0] + " Horario: " + r.getLunes()[1] + " " + "/";
			}
			if(r.getLunes()[2] != null) //Si es un horario partido
			{
				recoParaLista += " Lunes " + r.getLunes()[2] + " Horario: " + r.getLunes()[3] + " " + "/";
			}
			//Martes
			if(r.getMartes()[0] != null)
			{
				recoParaLista += " Martes " + r.getMartes()[0] + " Horario: " + r.getMartes()[1] + " " + "/";
			}
			if(r.getMartes()[2] != null) //Si es un horario partido
			{
				recoParaLista += " Martes " + r.getMartes()[2] + "Horario: " + r.getMartes()[3] + " " + "/";
			}
			//Miercoles
			if(r.getMiercoles()[0] != null)
			{
				recoParaLista += " Miercoles " + r.getMiercoles()[0] + " Horario: " + r.getMiercoles()[1] + " " + "/";
			}
			if(r.getMiercoles()[2] != null) //Si es un horario partido
			{
				recoParaLista += " Miercoles " + r.getMiercoles()[2] + " Horario: " + r.getMiercoles()[3] + " " + "/";
			}
			//Jueves
			if(r.getJueves()[0] != null)
			{
				recoParaLista += " Jueves " + r.getJueves()[0] + " Horario: " + r.getJueves()[1] + " " + "/";
			}
			if(r.getJueves()[2] != null) //Si es un horario partido
			{
				recoParaLista += " Jueves " + r.getJueves()[2] + " Horario: " + r.getJueves()[3] + " " + "/";
			}
			//Viernes
			if(r.getViernes()[0] != null)
			{
				recoParaLista += " Viernes " + r.getViernes()[0] + " Horario: " + r.getViernes()[1] + " " + "/";
			}
			if(r.getViernes()[2] != null) //Si es un horario partido
			{
				recoParaLista += " Viernes " + r.getViernes()[2] + " Horario: " + r.getViernes()[3] + " " + "/";
			}
			//Sabado
			if(r.getSabado()[0] != null)
			{
				recoParaLista += " Sabado " + r.getSabado()[0] + " Horario: " + r.getSabado()[1] + " " + "/";
			}
			if(r.getSabado()[2] != null) //Si es un horario partido
			{
				recoParaLista += " Sabado " + r.getSabado()[2] + " Horario: " + r.getLunes()[3] + " " + "/";
			}
			recomendacionesParaLista.add(recoParaLista);
		}
		return recomendacionesParaLista;
	}
	
	public Boolean isMateriaAsignada(Curso curso)
	{
		Boolean materiaAsignada = false;
		//Lunes
		if(getLunes()[0] != null)
		{
			if(curso.getMateria().getNombre().equals(this.getLunes()[0]))
			{
				materiaAsignada = true;
			}
		}
		else if(getLunes()[2] != null) //Si es un horario partido
		{
			if(curso.getMateria().getNombre().equals(this.getLunes()[2]))
			{
				materiaAsignada = true;
			}
		}
		//Martes
		else if(getMartes()[0] != null)
		{
			if(curso.getMateria().getNombre().equals(this.getMartes()[0]))
			{
				materiaAsignada = true;
			}
		}
		else if(this.getMartes()[2] != null) //Si es un horario partido
		{
			if(curso.getMateria().getNombre().equals(this.getMartes()[2]))
			{
				materiaAsignada = true;
			}
		}
		//Miercoles
		else if(this.getMiercoles()[0] != null)
		{
			if(curso.getMateria().getNombre().equals(this.getMiercoles()[0]))
			{
				materiaAsignada = true;
			}
		}
		else if(this.getMiercoles()[2] != null) //Si es un horario partido
		{
			if(curso.getMateria().getNombre().equals(this.getMiercoles()[2]))
			{
				materiaAsignada = true;
			}
		}
		//Jueves
		else if(this.getJueves()[0] != null)
		{
			if(curso.getMateria().getNombre().equals(this.getJueves()[0]))
			{
				materiaAsignada = true;
			}
		}
		else if(this.getJueves()[2] != null) //Si es un horario partido
		{
			if(curso.getMateria().getNombre().equals(this.getJueves()[2]))
			{
				materiaAsignada = true;
			}
		}
		//Viernes
		else if(this.getViernes()[0] != null)
		{
			if(curso.getMateria().getNombre().equals(this.getViernes()[0]))
			{
				materiaAsignada = true;
			}
		}
		else if(this.getViernes()[2] != null) //Si es un horario partido
		{
			if(curso.getMateria().getNombre().equals(this.getViernes()[2]))
			{
				materiaAsignada = true;
			}
		}
		//Sabado
		else if(this.getSabado()[0] != null)
		{
			if(curso.getMateria().getNombre().equals(this.getSabado()[0]))
			{
				materiaAsignada = true;
			}
		}
		else if(this.getSabado()[2] != null) //Si es un horario partido
		{
			if(curso.getMateria().getNombre().equals(this.getSabado()[2]))
			{
				materiaAsignada = true;
			}
		}
		return materiaAsignada;
	}
}