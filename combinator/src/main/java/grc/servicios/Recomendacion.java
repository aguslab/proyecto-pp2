package grc.servicios;

import grc.dominio.Curso;

import java.util.Set;

public class Recomendacion
{

	Set<Curso> recomendacion;
	
	public Recomendacion(Set<Curso> cursos)
	{
		this.recomendacion = cursos;
	}
	
	public Set<Curso> getRecomendacion()
	{
		return recomendacion;
	}

}
