package grc.modelo;

import grc.dominio.Curso;
import grc.dominio.PlanEstudio;
import grc.servicios.FiltroMaterias;
import grc.servicios.FiltroMateriasyPoscorrelativas;
import grc.servicios.FiltroPoscorrelativas;
import grc.servicios.Comparador;
import grc.servicios.Recomendacion;
import grc.servicios.RecomendacionComparable;

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

	public void actualizarRecomendaciones(List<Curso> cursos, boolean puedeEsperar) throws ClassNotFoundException,
			IOException
	{
		Recomendacion reco = new Recomendacion(this.timeToWait);
		reco.setPuedeEsperar(puedeEsperar);
		List<Recomendacion> recomendaciones = reco.backtracking(cursos);
		
		/*//Ordenamos por cantidad de materias
		ArrayList<Integer> cantMaterias = reco.cantMaterias(recomendaciones);
		reco.ordenarRecomendaciones(recomendaciones, cantMaterias);
		//Una vez ordenado por cantidad de materias ordenamos por cantidades de poscorrelativas
		ArrayList<Integer> cantPosCorrelativas = reco.cantPosCorrelativas(recomendaciones, planEstudio);
		reco.ordenarRecomendaciones(recomendaciones, cantPosCorrelativas);*/
		//reco.ordenarRecomendaciones(recomendaciones, planEstudio);
		
		this.finishRecoOK = reco.isFinishRecoOK();
		this.setRecomendaciones(recomendaciones);
	}
	
	public void actualizarOrdenamiento(boolean filtroMaterias, boolean filtroPoscorrelativas)
	{
		List<RecomendacionComparable> rComparables = new ArrayList<RecomendacionComparable>();
		ArrayList<Integer> cantidad;
		
		if(filtroMaterias && !filtroPoscorrelativas)
		{
			FiltroMaterias fm = new FiltroMaterias();
			cantidad = fm.contar(recomendaciones);
			rComparables = crearRecomendacionesComparables(recomendaciones, cantidad);
			fm.ordenar(rComparables);
		}
		else if (filtroPoscorrelativas && !filtroMaterias)
		{
			FiltroPoscorrelativas fp = new FiltroPoscorrelativas();
			cantidad = fp.contar(recomendaciones, planEstudio);
			rComparables = crearRecomendacionesComparables(recomendaciones, cantidad);
			fp.ordenar(rComparables);
		}
		else if (filtroPoscorrelativas && filtroMaterias)
		{
			System.out.println("Filtro ambos");
		//	FiltroMateriasyPoscorrelativas fmp = new FiltroMateriasyPoscorrelativas();
			//fmp.ordenarRecomendaciones(recomendaciones, planEstudio);
		}

		recomendaciones = armarRecomendaciones(rComparables); // Paso las recoComparables ordenadas a recomendaciones comunes
		this.finishRecoOK = true;
		this.setRecomendaciones(recomendaciones);
	}

	public List<RecomendacionComparable> crearRecomendacionesComparables(
			List<Recomendacion> recomendaciones, ArrayList<Integer> cantidad) 
	{
		List<RecomendacionComparable> recomendacionesComparables = new ArrayList<RecomendacionComparable>();
		int i = 0;
		for(Recomendacion r: recomendaciones)
		{
			RecomendacionComparable rc = new RecomendacionComparable(r,cantidad.get(i));
			recomendacionesComparables.add(rc);
			i++;
		}
		return recomendacionesComparables;
	}
	
	private List<Recomendacion> armarRecomendaciones(List<RecomendacionComparable> rComparables)
	{
		List<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();
		for(RecomendacionComparable rc : rComparables)
		{
			Recomendacion r = rc.getRecomendacion();
			recomendaciones.add(r);
		}
		return recomendaciones;
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
