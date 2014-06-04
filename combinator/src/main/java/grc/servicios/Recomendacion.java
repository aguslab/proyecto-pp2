package grc.servicios;

import grc.dominio.Curso;

import java.util.Set;

public class Recomendacion
{
	Set<Curso> cursosRecomendados;
	
	public Recomendacion(Set<Curso> cursos)
	{
		this.cursosRecomendados = cursos;
	}
	
	public Set<Curso> getRecomendacion()
	{
		return cursosRecomendados;
	}

}
