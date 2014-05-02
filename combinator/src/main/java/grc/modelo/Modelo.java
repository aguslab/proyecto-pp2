package grc.modelo;

import grc.dominio.Curso;
import grc.servicios.Recomendacion;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

public class Modelo extends Observable
{
	private List<Curso> cursosDisponibles;
	private List<Recomendacion> recomendaciones;
	private boolean finishRecoOK;
	// private List<Observer> vistaObserver;

	public Modelo(List<Curso> cursosDisponibles, List<Recomendacion> recomendaciones)
	{
		this.cursosDisponibles = cursosDisponibles;
		this.recomendaciones = recomendaciones;
	}

	public List<Curso> getCursosDisponibles()
	{
		return cursosDisponibles;
	}

	// public void setCursosDisponibles(List<Curso> cursosDisponibles) {
	// this.cursosDisponibles = cursosDisponibles;
	// }

	public List<Recomendacion> getRecomendaciones()
	{
		return recomendaciones;
	}

	public void setRecomendaciones(List<Recomendacion> recomendaciones)
	{
		this.recomendaciones = recomendaciones;
		this.setChanged();
		this.notifyObservers();
	}

	public void calcularRecomendaciones(List<Curso> cursos) throws ClassNotFoundException,
			IOException
	{
		Recomendacion reco = new Recomendacion();
		List<Recomendacion> recomedaciones = reco.backtracking(cursos);
		this.finishRecoOK = reco.isFinishRecoOK();
		this.setRecomendaciones(recomedaciones);
	}

	public boolean isFinishRecomendacionOK()
	{
		return finishRecoOK;
	}

	// public List<Observer> getVistaObserver() {
	// return vistaObserver;
	// }

	// public void setVistaObserver(List<Observer> vistaObserver) {
	// this.vistaObserver = vistaObserver;
	// }
	
	

}
