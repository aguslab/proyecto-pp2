package grc.modelo;

import grc.dominio.Curso;
import grc.dominio.PlanEstudio;
import grc.servicios.ComparadorMaterias;
import grc.servicios.ComparadorPoscorrelativas;
import grc.servicios.Criterio;
import grc.servicios.Recomendacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

public class GRCModel extends Observable
{
	private List<Curso> cursosDisponibles;
	private List<Recomendacion> recomendaciones;
	private boolean finishRecoOK;
	private PlanEstudio planEstudio;
	private long timeToWait;
	private Recomendacion recomendacionActual;
	// private List<Observer> vistaObserver;

	public GRCModel(List<Curso> cursosDisponibles, PlanEstudio planEstudio, long timeToWait)
	{
		this.cursosDisponibles = cursosDisponibles;
		this.planEstudio = planEstudio;
		this.timeToWait = timeToWait;
		this.recomendaciones = new ArrayList<Recomendacion>();
	}

	public List<Curso> getCursosDisponibles()
	{
		return cursosDisponibles;
	}
	
	public PlanEstudio getPlanEstudio()
	{
		return this.planEstudio;
	}
	
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

	public void actualizarRecomendaciones(List<Curso> cursos, boolean puedeEsperar) throws ClassNotFoundException,
			IOException
	{
		Recomendacion reco = new Recomendacion(this.timeToWait);
		reco.setPuedeEsperar(puedeEsperar);
		List<Recomendacion> recomendaciones = reco.backtracking(cursos);
		this.finishRecoOK = reco.isFinishRecoOK();
		this.setRecomendaciones(recomendaciones);
	}
	
	public void actualizarOrdenamiento(Criterio criterio)
	{
		if(criterio.getCriterio() instanceof Boolean)
		{
			System.out.println("ORDENAR POR MATERIA");
			Collections.sort(recomendaciones, new ComparadorMaterias());
		}
		else if (criterio.getCriterio() instanceof Integer)
		{
			System.out.println("ORDENAR POR POSCORRELATIVA");
			ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas();
			comparadorPoscorrelativas.setPlanEstudio(planEstudio);
			Collections.sort(recomendaciones, comparadorPoscorrelativas);
		}
		else if (criterio.getCriterio() instanceof List<?>) 
		{
			System.out.println("ORDENAR POR AMBAS");
			Collections.sort(recomendaciones, new ComparadorMaterias());
			ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas();
			comparadorPoscorrelativas.setPlanEstudio(planEstudio);
			Collections.sort(recomendaciones, comparadorPoscorrelativas);
		}
		this.finishRecoOK = true;
		this.setRecomendaciones(recomendaciones);
	}
	
	public boolean isFinishRecomendacionOK()
	{
		return finishRecoOK;
	}

	public void actualizarRecomendacionActual(int posElegida)
	{
		// TODO Auto-generated method stub
	}
}
