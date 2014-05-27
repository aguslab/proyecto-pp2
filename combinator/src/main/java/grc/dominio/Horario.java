package grc.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="horario")
public class Horario implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_horario;
	@Column(nullable = false)
	private int horaInicio;
	@Column(nullable = false)
	private int horaFin;
	@Column(nullable = false)
	private Dia dia;//TODO: cambiar por enum??
	
	
	public Horario()
	{
	}
	public Horario(Dia dia, int horaInicio, int horaFin)
	{
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public Horario(int horaInicio, int horaFin)
	{
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public int getId() 
	{
		return id_horario;
	}

	public void setId(int id) 
	{
		this.id_horario = id;
	}
	
	public int getHoraInicio() 
	{
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) 
	{
		this.horaInicio = horaInicio;
	}

	public int getHoraFin() 
	{
		return horaFin;
	}

	public void setHoraFin(int horaFin) 
	{
		this.horaFin = horaFin;
	}
	
	public Dia getDia()
	{
		return dia;
	}
	
	public void setDia(Dia dia)
	{
		this.dia = dia;
	}
	
	
}
