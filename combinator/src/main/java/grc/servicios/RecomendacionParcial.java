package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecomendacionParcial
{
	Set<Curso> cursos;
	private Map<Dia, List<Horario>> horariosOcupados;

	public RecomendacionParcial()
	{
		this (new HashSet<Curso>());
	}

	public RecomendacionParcial(Set<Curso> cursos)
	{
		this.cursos = cursos;
		this.horariosOcupados = new EnumMap<Dia, List<Horario>>(Dia.class);
	}

	public Set<Curso> getRecomendacion()
	{
		return cursos;
	}

	public void agregarCurso(Curso curso)
	{
		assert puedeAgregarCurso(curso);
		this.cursos.add(curso);
		this.agregarAHorariosOcupados(curso.getHorario());
	}

	public void eliminarCurso(Curso curso)
	{
		this.cursos.remove(curso);
		this.limpiarHorariosOcupados(curso.getHorario());
	}

	private void limpiarHorariosOcupados(List<Horario> horarios)
	{
		for (Horario h : horarios)
		{
			this.horariosOcupados.get(h.getDia()).remove(h);
		}
	}

	private void agregarAHorariosOcupados(Collection<Horario> horarios)
	{
		for (Horario h : horarios)
		{
			if (this.horariosOcupados.containsKey(h.getDia()))
			{
				this.horariosOcupados.get(h.getDia()).add(h);
			} else
			{
				List<Horario> nuevoHorario = new ArrayList<Horario>();
				nuevoHorario.add(h);
				this.horariosOcupados.put(h.getDia(), nuevoHorario);
			}
		}
	}

	public boolean puedeAgregarCurso(Curso curso)
	{
		// verifico que no haya un curso con una materia que ya se haya agregado
		for (Curso c : this.getRecomendacion())
		{
			if (c.getMateria().equals(curso.getMateria()))
			{
				return false;
			}
		}

		boolean horarioDisponible = true;

		for (Horario h : curso.getHorario())
		{
			if (horariosOcupados.containsKey(h.getDia()) && horarioDisponible)
			{
				for (Horario horario : horariosOcupados.get(h.getDia()))
				{
					if (horario.seSolapaCon(h))
					{
						horarioDisponible = false;
						break;
					}
				}
			}
		}
		return horarioDisponible;
	}

	public Set<Curso> getCopiaCursosDeRecomendacion()
	{
		Set<Curso> cursos = new HashSet<Curso>();
		cursos.addAll(this.cursos);

		return cursos;
	}

}
