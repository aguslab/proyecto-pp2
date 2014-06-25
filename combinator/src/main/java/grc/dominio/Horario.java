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
	private Double horaInicio;
	@Column(nullable = false)
	private Double horaFin;
	@Column(nullable = false)
	private Dia dia;
	public static final Horario MAÑANA = new Horario(8.0, 12.0);
	public static final Horario TARDE = new Horario(13.0, 17.0);
	public static final Horario NOCHE = new Horario(18.0, 22.0);
	
	public Horario()
	{
	}
	public Horario(Dia dia, Double horaInicio, Double horaFin)
	{
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}
	
	public Horario(Double horaInicio, Double horaFin)
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
	
	public Double getHoraInicio() 
	{
		return horaInicio;
	}

	public void setHoraInicio(Double horaInicio) 
	{
		this.horaInicio = horaInicio;
	}

	public Double getHoraFin() 
	{
		return horaFin;
	}

	public void setHoraFin(Double horaFin) 
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
	
	public boolean seSolapaCon(Horario h)
	{
		return (this.horaInicio.compareTo(h.getHoraInicio()) >= 0 && this.horaFin.compareTo(h.getHoraFin()) <= 0 || (h.getHoraInicio().compareTo(this.getHoraInicio()) >= 0 && h.getHoraFin().compareTo(this.horaFin) <= 0));
	}
	
	
}
