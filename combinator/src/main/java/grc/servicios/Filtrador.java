package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Horario;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Filtrador
{

	public Set<Curso> getCursosDisponibles(List<Curso> cursos, List<Horario> horarios)
			throws Exception
	{
		Set<Curso> cursosFiltrados = new HashSet<Curso>();

		for (Curso c : cursos)
		{
			List<Horario> horas = c.getHorario();
			for (Horario hc : horas){
				for (Horario h : horarios)
				{
					if(hc.getHoraInicio() >= h.getHoraInicio() && hc.getHoraFin() <= h.getHoraFin()){
						cursosFiltrados.add(c);
					}
				}
			}
		}
		
		return cursosFiltrados;
	}

}
