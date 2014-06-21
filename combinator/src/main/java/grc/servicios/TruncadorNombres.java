package grc.servicios;

public class TruncadorNombres 
{
	String nombreMateria;
	public TruncadorNombres(String nombreMateria)
	{
		this.nombreMateria = nombreMateria; //No es necesario tener este atributo. Pero lo 
		                                   //puse para mantener la encapsulacion... 
		                                   //o era al reves? sin atributo? XD
	}	
	
	private String truncar() // Bombardeo de ifs D: 
	{
		String nombreTruncado = nombreMateria; //Si el nombre original fue modificado, agrego un *
		
		if(nombreMateria.contains("Problemas")) //PSEC
			nombreTruncado = "*PSEC";
		
		else if(nombreMateria.contains("Ingles")) // INGLES
			if(nombreMateria.contains("I"))
				nombreTruncado = "*Ingles I";
			else if(nombreMateria.contains("II"))
				nombreTruncado = "*Ingles II";
			else
				nombreTruncado = "*Ingles III";
		
		else if(nombreMateria.contains("Organización")) // ORGA
			if(nombreMateria.contains("I"))
				nombreTruncado = "*ORGA I";
			else
				nombreTruncado = "*ORGA II";
		
		else if(nombreMateria.contains("Lógica")) // LTN
			nombreTruncado = "*LTN";
		
		else if(nombreMateria.contains("Lectoescritura")) //LECTO
			nombreTruncado = "*Lecto";
		
		else if(nombreMateria.contains("Introducción")) //Introducción matematica o programacion
				if(nombreMateria.contains("matemática"))
					nombreTruncado = "*Intro. Matemática";
				else
					nombreTruncado = "*Intro. Programación";
		
		else if(nombreMateria.contains("Sistemas")) //SOR
			if(nombreMateria.contains("I"))
				nombreTruncado = "*SOR I";
			else
				nombreTruncado = "*SOR II";
			
		else if(nombreMateria.contains("Especificación")) // ES
			nombreTruncado = "*Especificación";
		
		else if(nombreMateria.contains("Teoría")) //Teoria de la computacion
			nombreTruncado = "*TC";
		
		else if(nombreMateria.contains("Proyecto")) //PP1 y 2
			if(nombreMateria.contains("I"))
				nombreTruncado = "*PP1";
			else
				nombreTruncado = "*PP2";
		
		else if(nombreMateria.contains("Práctica")) //Practica Profesional Supervisada
			if(nombreMateria.contains("I"))
				nombreTruncado = "*PPS1";
			else
				nombreTruncado = "*PPS2";
		
		else if(nombreMateria.contains("Laboratorio")) //Laboratorio Interdisciplinario
			nombreTruncado = "*Laboratorio";
		
		else if(nombreMateria.contains("Ingeniería")) //Ingenieria de software
			if(nombreMateria.contains("I"))
				nombreTruncado = "*Ingeniería I";
			else
				nombreTruncado = "*Ingeniería II";
		
		return agregarComision(nombreTruncado);
	}
	
	private String agregarComision(String nombre)
	{
		if(nombre.contains("*")) //Si el nombre original fue modificado
		{
			nombre = nombre.substring(1); //Le saco el asterisco
			if(nombre.contains("01")) //y agrego la comision
				nombre+=" com-01";
			else
				nombre+=" com-02";
		}
		
		return nombre;
	}
	
	public String getNombreTruncado()
	{
		return truncar();
	}
}
