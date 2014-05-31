package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.Horario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecomendacionParcial
{

	List<Curso> recomendacion;
	private Map<String, List<Horario>> horariosOcupados;

	public RecomendacionParcial()
	{
		this.recomendacion = new ArrayList<Curso>();
		this.horariosOcupados = new HashMap<String, List<Horario>>();
	}

	public RecomendacionParcial(List<Curso> cursos)
	{
		this.recomendacion = cursos;
	}

	public List<Curso> getRecomendacion()
	{
		return recomendacion;
	}

	public void agregarCurso(Curso curso)
	{
		this.recomendacion.add(curso);
		this.agregarAHorariosOcupados(curso.getHorario());
	}

	public void eliminarCurso(Curso curso)
	{
		this.recomendacion.remove(curso);
		this.limpiarHorariosOcupados(curso.getHorario());
	}

	private void limpiarHorariosOcupados(List<Horario> horarios)
	{
		for (Horario h : horarios)
		{
			this.horariosOcupados.get(h.getDia().name()).remove(h);
		}
	}

	private void agregarAHorariosOcupados(List<Horario> horarios)
	{

		for (Horario h : horarios)
		{
			if (this.horariosOcupados.containsKey(h.getDia()))
			{
				this.horariosOcupados.get(h.getDia().name()).add(h);
			} else
			{
				List<Horario> nuevoHorario = new ArrayList<Horario>();
				nuevoHorario.add(h);
				this.horariosOcupados.put(h.getDia().name(), nuevoHorario);
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
			String horarioDia = h.getDia().name();
			if (horariosOcupados.containsKey(horarioDia))
			{
				for (Horario horario : horariosOcupados.get(horarioDia))
				{
					if (horario.seSolapaCon(h))
					{
						horarioDisponible = false;
						break;
					}
				}
			}
		}
		if (horarioDisponible)
		{
			agregarAHorariosOcupados(curso.getHorario());
		}

		return horarioDisponible;
	}

	@Override
	public RecomendacionParcial clone()
	{
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.addAll(this.recomendacion);

		return new RecomendacionParcial(cursos);
	}

}
