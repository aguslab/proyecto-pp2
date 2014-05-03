package grc.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cursos")
public class Curso implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
	// TODO: cambiar a manyToOne cuando hayas mas carreras?
	private Materia materia;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Horario> horarios;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Carrera> carreras;

	public Curso()
	{

	}

	public Curso(List<Carrera> carreras, Materia materia, List<Horario> horario)
	{
		this.carreras = carreras;
		this.materia = materia;
		this.horarios = horario;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Materia getMateria()
	{
		return materia;
	}

	public void setMateria(Materia materia)
	{
		this.materia = materia;
	}

	public List<Horario> getHorario()
	{
		return horarios;
	}

	public void setHorario(List<Horario> horario)
	{
		this.horarios = horario;
	}

//	public List<Carrera> getCarreras()
//	{
//		return carreras;
//	}
//
//	public void setCarreras(List<Carrera> carreras)
//	{
//		this.carreras = carreras;
//	}

}
