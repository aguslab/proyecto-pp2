package grc.modelo;

import grc.dominio.Curso;
import grc.servicios.CriterioOrden;
import grc.servicios.GeneradorRecomendaciones;
import grc.servicios.Recomendacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

public class GRCModelo extends Observable
{
	private List<Curso> cursosDisponibles;
	private List<Recomendacion> recomendaciones;
	private boolean seCompletoLaGeneracionDeRecomendaciones;
	private long timeOut;
	private Recomendacion recomendacionActual;
	private CriterioOrden criterioOrden;
	private ArrayList<String> listaRecomendacionesSugeridas;

	public GRCModelo(Set<Curso> cursosDisponibles, CriterioOrden co,
			long timeOut)
	{
		this.cursosDisponibles = new ArrayList<Curso>(cursosDisponibles);
		listaRecomendacionesSugeridas = new ArrayList<String>();
		this.timeOut = timeOut;
		this.criterioOrden = co;
		this.recomendaciones = new ArrayList<Recomendacion>();
	}

	public List<Curso> getCursosDisponibles()
	{
		return cursosDisponibles;
	}

	public List<Recomendacion> getRecomendaciones()
	{
		return recomendaciones;
	}

	public void setRecomendaciones()
	{
		// this.recomendaciones = recomendaciones;
		this.setChanged();
		this.notifyObservers(recomendaciones);
	}

	public Recomendacion getRecomendacionActual()
	{
		return recomendacionActual;
	}

	private void setRecomendacionActual()
	{
		this.setChanged();
		this.notifyObservers(recomendacionActual);
	}

	public void actualizarRecomendaciones(Set<Curso> cursosDisponibles, boolean puedeEsperar)
	{
		List<Curso> cursosFiltrados = new ArrayList<Curso>(cursosDisponibles);
		GeneradorRecomendaciones generadorRecom = new GeneradorRecomendaciones(timeOut,
				puedeEsperar);
		this.recomendaciones = generadorRecom.generarRecomendaciones(cursosFiltrados);
		 Collections.sort(recomendaciones, this.criterioOrden);
		this.seCompletoLaGeneracionDeRecomendaciones = generadorRecom
				.generacionRecomendacionesCompletada();
		armarRecomendaciones();
		this.setRecomendaciones();
	}

	public void ordenarPorCriterio(CriterioOrden criterio)
	{
		Collections.sort(recomendaciones, criterio);
		armarRecomendaciones();
		this.seCompletoLaGeneracionDeRecomendaciones = true;//TODO ver!!!
		this.setRecomendaciones();
	}

	public void armarRecomendaciones()
	{
		ArrayList<String> recomendacionesParaLista = new ArrayList<String>();
		for (Recomendacion r : this.recomendaciones)
		{
			String recoParaLista = "";
			for (Curso c : r.getRecomendacion())
			{
				String nombreMateria = c.getNombreCurso();
				String apodoMateria = c.getApodoCurso();
				if(!c.getMateria().getApodo().equals(""))
					recoParaLista += apodoMateria;
				else
					recoParaLista += nombreMateria;
				
				for (int j = 0; j < c.getHorario().size(); j++)
				{
					recoParaLista += " Dia: " + c.getHorario().get(j).getDia();
					recoParaLista += " De: " + c.getHorario().get(j).getHoraInicio();
					recoParaLista += "hs a " + c.getHorario().get(j).getHoraFin() + " hs";
				}
				recoParaLista += "; ";
			}
			recomendacionesParaLista.add(recoParaLista);
		}
		
		this.setListaRecomendacionesSugeridas(recomendacionesParaLista);
	}

	public boolean seCompletoLaGeneracionDeRecomendaciones()
	{
		return seCompletoLaGeneracionDeRecomendaciones;
	}

	public void actualizarRecomendacionActual(int posElegida)
	{
		if (this.recomendaciones.isEmpty())
			return;
		this.recomendacionActual = this.recomendaciones.get(posElegida);
		this.setRecomendacionActual();
	}

	public ArrayList<String> getListaRecomendacionesSugeridas()
	{
		return listaRecomendacionesSugeridas;
	}

	private void setListaRecomendacionesSugeridas(ArrayList<String> recomendacionesParaLista)
	{
		this.listaRecomendacionesSugeridas = recomendacionesParaLista;
	}
	
	public GRCModelo clone(){
		Set<Curso> cursos = new HashSet<Curso>();
		cursos.addAll(cursosDisponibles);
		GRCModelo m = new GRCModelo(cursos, this.criterioOrden, timeOut);
		m.recomendaciones = this.recomendaciones;
		m.listaRecomendacionesSugeridas = this.listaRecomendacionesSugeridas;
		m.recomendacionActual = this.recomendacionActual;
		return m;
	}
}
