package grc.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Carrera")
public class Carrera implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Column(nullable = false)
	private String nombre;

	public Carrera()
	{
	}

	public Carrera(String nombre)
	{
		this.nombre = nombre;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

}
