package grc.servicios;

import java.util.Comparator;

public class RecomendacionComparable  implements Comparable<RecomendacionComparable>
{
	Recomendacion recomendacion;
	Integer cantidad;
	
	public RecomendacionComparable(Recomendacion recomendacion, Integer cantidad)
	{
		this.recomendacion = recomendacion;
		this.cantidad = cantidad;
	}

	public Recomendacion getRecomendacion() 
	{
		return recomendacion;
	}

	public void setRecomendacion(Recomendacion recomendacion) 
	{
		this.recomendacion = recomendacion;
	}

	public Integer getCantidad() 
	{
		return cantidad;
	}

	public void setCantidad(Integer cantidad) 
	{
		this.cantidad = cantidad;
	}

	@Override
	public int compareTo(RecomendacionComparable o) 
	{
		return o.getCantidad() - this.getCantidad();
	}

}