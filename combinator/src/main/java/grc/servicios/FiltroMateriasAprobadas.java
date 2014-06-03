package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Materia;

import java.util.HashSet;
import java.util.Set;

public class FiltroMateriasAprobadas implements IFiltro
{
	Set<Materia> materiasAprobadas;
	
	public FiltroMateriasAprobadas(Set<Materia> materiasAprobadas)
	{
		this.materiasAprobadas = materiasAprobadas;
	}

	@Override
	public  Set<Curso> filtrar(Set<Curso> cursos)
	{
		Set<Curso> cursosSinMateriasAprobadas = new HashSet<Curso>(cursos);
		for (Curso c : cursos)
		{
			for (Materia m : this.materiasAprobadas)
			{
				if (c.getMateria().equals(m))
				{
					cursosSinMateriasAprobadas.remove(c);
					break;
				}
			}
		}
		return cursosSinMateriasAprobadas;
	}
	
}
