package grc.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Materias_Aprobadas")
public class MateriaAprobada 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(optional = false, cascade=CascadeType.ALL)
	private Materia materia;
	private double nota;
	//TODO: agregar variable aprobado? A, H, algo de eso?

	public MateriaAprobada()
	{
	}
	
	public MateriaAprobada(Materia materia, double nota) 
	{
		this.materia = materia;
		this.nota= nota;
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

}
