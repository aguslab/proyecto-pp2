package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;

import java.util.HashSet;
import java.util.Set;

public class FiltroCorrelativas implements IFiltro
{
	Set<Materia> materiasAprobadas;
	PlanEstudio planEstudio;
	
	public FiltroCorrelativas(Set<Materia> materiasAprobadas, PlanEstudio planEstudio)
	{
		this.materiasAprobadas = materiasAprobadas;
		this.planEstudio = planEstudio;
	}

	@Override
	public Set<Curso> filtrar(Set<Curso> cursos)
	{
		Set<Curso> cursosFiltradosPorCorrelativas = new HashSet<Curso>();
		for (Curso c : cursos)
		{
			if (materiasAprobadas.containsAll(planEstudio.getCorrelativas(c.getMateria())))
			{
				cursosFiltradosPorCorrelativas.add(c);
			}
		}
		return cursosFiltradosPorCorrelativas;
	}
	
}
