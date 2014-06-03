package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Horario;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FiltroHorarios implements IFiltro
{
	List<Horario> horarios;
	public FiltroHorarios(List<Horario> horarios)
	{
		this.horarios = horarios;
	}

	@Override
	public Set<Curso> filtrar(Set<Curso> cursos)
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
	
}
