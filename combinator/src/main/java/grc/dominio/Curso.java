package grc.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cursos")
public class Curso implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	// TODO: cambiar a manyToOne cuando hayas mas carreras?
	private Materia materia;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Horario> horarios;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Carrera> carreras;
	private String comision;

	public Curso()
	{

	}

	public Curso(List<Carrera> carreras, Materia materia, List<Horario> horario, String comision)
	{
		this.carreras = carreras;
		this.materia = materia;
		this.horarios = horario;
		this.comision = comision;
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
	
	public String getNombreCurso()
	{
		return this.materia.getNombre() + " com-" + this.comision;
	}

	public String getComision()
	{
		return comision;
	}

	public void setComision(String comision)
	{
		this.comision = comision;
	}
	
//	public List<Carrera> getCarreras()
//	{
//		return carreras;
//	}
//

}
