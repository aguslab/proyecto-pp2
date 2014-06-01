package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FiltroCursos
{

	public Set<Curso> filtrarPorHorario(List<Curso> cursos, List<Horario> horarios)
			throws Exception
	{
		Set<Curso> cursosFiltrados = new HashSet<Curso>();

		for (Curso c : cursos)
		{
			boolean cumpleFiltroFull = true;
			boolean cumpleFiltroMid = !horarios.isEmpty();
			List<Horario> horasCurso = c.getHorario();
			for (Horario hc : horasCurso)
			{
				cumpleFiltroFull = cumpleFiltroFull && cumpleFiltroMid;
				cumpleFiltroMid = false;
				for (Horario h : horarios)
				{
					if (hc.getHoraInicio() >= h.getHoraInicio()
							&& hc.getHoraFin() <= h.getHoraFin())
					{
						cumpleFiltroMid = true;
						break;
					}
				}
			}
			if (cumpleFiltroFull && cumpleFiltroMid)
			{
				cursosFiltrados.add(c);
			}
		}

		return cursosFiltrados;
	}

	public Set<Curso> filtrarMateriasAprobadas(Set<Curso> cursos, Set<Materia> materiasAprobadas)
	{
		Set<Curso> cursosSinMateriasAprobadas = new HashSet<Curso>(cursos);
		for (Curso c : cursos)
		{
			for (Materia m : materiasAprobadas)
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

	public Set<Curso> filtrarCorrelativas(PlanEstudio planEstudio, Set<Curso> cursos,
			Set<Materia> materiasAprobadas) throws Exception
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
