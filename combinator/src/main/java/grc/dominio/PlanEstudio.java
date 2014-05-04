package grc.dominio;

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
	@Column(nullable = false, columnDefinition = "blob")
	private HashMap<Materia, Set<Materia>> correlativas;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Carrera carrera;

	public PlanEstudio()
	{
	}

	public PlanEstudio(Carrera carrera, HashMap<Materia, Set<Materia>> correlativas)
	{
		this.carrera = carrera;
		this.correlativas = correlativas;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public HashMap<Materia, Set<Materia>> getCorrelativas()
	{
		return correlativas;
	}

	public void setCorrelativas(HashMap<Materia, Set<Materia>> correlativas)
	{
		this.correlativas = correlativas;
	}

	public Carrera getCarrera()
	{
		return carrera;
	}

	public void setCarrera(Carrera carrera)
	{
		this.carrera = carrera;
	}

}
