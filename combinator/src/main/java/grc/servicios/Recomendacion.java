package grc.servicios;

import grc.dominio.Curso;
import java.util.List;

public class Recomendacion
{

	List<Curso> recomendacion;
	
	public Recomendacion(List<Curso> cursos)
	{
		this.recomendacion = cursos;
	}
	
	public List<Curso> getRecomendacion()
	{
		return recomendacion;
	}

}
