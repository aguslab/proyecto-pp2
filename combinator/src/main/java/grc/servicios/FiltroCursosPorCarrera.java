package grc.servicios;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import java.util.HashSet;
import java.util.Set;

public class FiltroCursosPorCarrera implements IFiltro
{
	Carrera carrera;
	public FiltroCursosPorCarrera(Carrera carrera)
	{
		this.carrera = carrera;
	}

	@Override
	public Set<Curso> filtrar(Set<Curso> cursos)
	{
		Set<Curso> cursosDeCarrera = new HashSet<Curso>();
		for (Curso c : cursos)
		{
			if (c.getCarrera().getId() == carrera.getId())
			{
				cursosDeCarrera.add(c);
			}
		}
		return cursosDeCarrera;
	}
	
}
