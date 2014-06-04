package grc.modelo;

import java.util.Observable;

public class EstadoFiltros extends Observable
{
	private boolean filtroMañana;
	private boolean filtroTarde;
	private boolean filtroNoche;
	private boolean filtroPuedeEsperar;

	public EstadoFiltros(boolean filtroMañana, boolean filtroTarde, boolean filtroNoche,
			boolean filtroPuedeEsperar)
	{
		super();
		this.filtroMañana = filtroMañana;
		this.filtroTarde = filtroTarde;
		this.filtroNoche = filtroNoche;
		this.filtroPuedeEsperar = filtroPuedeEsperar;
	}

	public boolean isFiltroMañana()
	{
		return filtroMañana;
	}

	public void setFiltroMañana(boolean filtroMañana)
	{
		this.filtroMañana = filtroMañana;
		setChanged();
		notifyObservers();
	}

	public boolean isFiltroTarde()
	{
		return filtroTarde;
	}

	public void setFiltroTarde(boolean filtroTarde)
	{
		this.filtroTarde = filtroTarde;
		setChanged();
		notifyObservers();
	}

	public boolean isFiltroNoche()
	{
		return filtroNoche;
	}

	public void setFiltroNoche(boolean filtroNoche)
	{
		this.filtroNoche = filtroNoche;
		setChanged();
		notifyObservers();
	}

	public boolean isFiltroPuedeEsperar()
	{
		return filtroPuedeEsperar;
	}

	public void setFiltroPuedeEsperar(boolean filtroPuedeEsperar)
	{
		this.filtroPuedeEsperar = filtroPuedeEsperar;
		setChanged();
		notifyObservers();
	}
}
