package grc.modelo;

import grc.dominio.Curso;
import grc.dominio.PlanEstudio;
import grc.servicios.CriterioOrden;
import grc.servicios.GeneradorRecomendaciones;
import grc.servicios.CriterioOrdenSecuenciales;
import grc.servicios.CriterioOrdenPorMaterias;
import grc.servicios.CriterioOrdenPorPoscorrelativas;
import grc.servicios.Recomendacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Set;

public class GRCModel extends Observable
{
	private List<Curso> cursosDisponibles;
	private List<Recomendacion> recomendaciones;
	private boolean finishRecoOK;
	private PlanEstudio planEstudio;
	private long timeOut;
	private Recomendacion recomendacionActual;
	private CriterioOrden co;
	// private List<Observer> vistaObserver;

	public GRCModel(Set<Curso> cursosDisponibles, PlanEstudio planEstudio, CriterioOrden co, long timeOut)
	{
		this.cursosDisponibles = new ArrayList<Curso>(cursosDisponibles);
		this.planEstudio = planEstudio;
		this.timeOut = timeOut;
		this.co = co;
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
		Collections.sort(recomendaciones, this.co);
		this.finishRecoOK = generadosRecom.seCompletoLaGeneracionDeRecomendaciones();
		this.setRecomendaciones(recomendaciones);
	}
	
	public void actualizarOrdenamiento(CriterioOrden criterio)
	{
		Collections.sort(recomendaciones, criterio);
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
