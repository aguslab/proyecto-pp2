package grc.dominio;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Materias_Aprobadas")
public class MateriaAprobada
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	private Materia materia;
	private double nota;
	private Timestamp fechaAprobado;
	// TODO: agregar variable aprobado? A, H, algo de eso?

	public MateriaAprobada()
	{
	}

	public MateriaAprobada(Materia materia, double nota, Timestamp fechaAprobado)
	{
		this.materia = materia;
		this.nota = nota;
		this.fechaAprobado = fechaAprobado;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public double getNota()
	{
		return nota;
	}

	public void setNota(double nota)
	{
		this.nota = nota;
	}

	public Materia getMateriaAprobada()
	{
		return materia;
	}

	public void setMateriaAprobada(Materia materia)
	{
		this.materia = materia;
	}

	public Timestamp getFechaAprobado()
	{
		return fechaAprobado;
	}

	public void setFechaAprobado(Timestamp fechaAprobado)
	{
		this.fechaAprobado = fechaAprobado;
	}

}
