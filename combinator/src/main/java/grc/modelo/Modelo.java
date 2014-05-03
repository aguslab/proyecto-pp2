package grc.modelo;

import grc.dominio.Curso;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.servicios.Recomendacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Modelo extends Observable
{
	private List<Curso> cursosDisponibles;
	private List<Recomendacion> recomendaciones;
	private boolean finishRecoOK;
	private PlanEstudio planEstudio;
	// private List<Observer> vistaObserver;

	public Modelo(List<Curso> cursosDisponibles, List<Recomendacion> recomendaciones, PlanEstudio planEstudio)
	{
		this.cursosDisponibles = cursosDisponibles;
		this.recomendaciones = recomendaciones;
		this.planEstudio = planEstudio;
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
		List<Recomendacion> recomendaciones = reco.backtracking(cursos);
		ArrayList<Integer> cantMaterias = reco.cantMaterias(recomendaciones);
		//ArrayList<Integer> cantPosCorrelativas = reco.cantPosCorrelativas(recomendaciones, planEstudio);
		reco.ordenarRecomendaciones(recomendaciones, cantMaterias);
		this.finishRecoOK = reco.isFinishRecoOK();
		this.setRecomendaciones(recomendaciones);
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
