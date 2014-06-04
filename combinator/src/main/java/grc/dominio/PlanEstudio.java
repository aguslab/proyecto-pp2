package grc.dominio;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PlanEstudios")
public class PlanEstudio
{

	@Id
	private int id;
	@Column(name="correlativas", nullable = false, columnDefinition = "blob")
	private HashMap<Materia, Set<Materia>> correlatividades;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Carrera carrera;

	public PlanEstudio()
	{
	}

	public PlanEstudio(Carrera carrera, HashMap<Materia, Set<Materia>> correlatividades)
	{
		this.carrera = carrera;
		this.correlatividades = correlatividades;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Carrera getCarrera()
	{
		return carrera;
	}

	public Set<Materia> getCorrelativas(Materia materia)
	{
		assert perteneceAPlanEstudio(materia);

		return this.correlatividades.get(materia);
	}

	public boolean perteneceAPlanEstudio(Materia materia)
	{
		return this.correlatividades.containsKey(materia);
	}

	/**
	 * 
	 * @param materia
	 * @return cantidad de veces que aparece la materia pasada como parámetro como
	 * correlativa de otras materias
	 */
	public Integer getCantidadPoscorrelativas(Materia materia)
	{
		Integer cantidadPoscorrelativas = 0;
		Collection<Set<Materia>> materiasCorrelativas = this.correlatividades.values();
		for (Set<Materia> materias : materiasCorrelativas) 
		{
			for (Materia m : materias) 
			{
				if (m.equals(materia))
				{
					cantidadPoscorrelativas++;
				}
			}
		}
		return cantidadPoscorrelativas;
	}
}
