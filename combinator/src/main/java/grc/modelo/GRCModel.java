package grc.modelo;

import grc.dominio.Curso;
import grc.dominio.PlanEstudio;
import grc.servicios.GeneradorRecomendaciones;
import grc.servicios.ComparadorAmbos;
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
	private long timeOut;
	private Recomendacion recomendacionActual;
	// private List<Observer> vistaObserver;

	public GRCModel(List<Curso> cursosDisponibles, PlanEstudio planEstudio, long timeOut)
	{
		this.cursosDisponibles = cursosDisponibles;
		this.planEstudio = planEstudio;
		this.timeOut = timeOut;
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
		this.notifyObservers(recomendaciones);
	}
	
	public Recomendacion getRecomendacionActual()
	{
		return recomendacionActual;
	}

	public void setRecomendacionActual(Recomendacion recomendacionActual)
	{
		this.recomendacionActual = recomendacionActual;
		this.setChanged();
		this.notifyObservers(recomendacionActual);
	}

	public void actualizarRecomendaciones(List<Curso> cursos, boolean puedeEsperar) throws ClassNotFoundException,
			IOException
	{
		GeneradorRecomendaciones generadosRecom = new GeneradorRecomendaciones(timeOut, puedeEsperar);
		List<Recomendacion> recomendaciones = generadosRecom.generarRecomendaciones(cursos);
		this.finishRecoOK = generadosRecom.isFinishRecoOK();
		this.setRecomendaciones(recomendaciones);
	}
	
	public void actualizarOrdenamiento(Criterio criterio)
	{
		Object tipoCriterio = criterio.getTipoCriterio();
		if(tipoCriterio instanceof Boolean)
		{
			//ORDENAR POR MATERIA
			Collections.sort(recomendaciones, new ComparadorMaterias((Boolean) tipoCriterio));
		}
		else if (tipoCriterio instanceof String)
		{
			//ORDENAR POR POSCORRELATIVA
			ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas();
			comparadorPoscorrelativas.setPlanEstudio(planEstudio); //Hay que hacer algo con esto
			Collections.sort(recomendaciones, comparadorPoscorrelativas);
		}
		else if (tipoCriterio instanceof List<?>) 
		{
			//ORDENAR POR AMBAS
			ComparadorAmbos comparadorAmbos = new ComparadorAmbos((List<Character>) tipoCriterio);
			comparadorAmbos.setPlanEstudio(planEstudio);
			Collections.sort(recomendaciones, comparadorAmbos);
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
		this.recomendacionActual = this.recomendaciones.get(posElegida);
		this.setRecomendacionActual(recomendacionActual);
	}
}
