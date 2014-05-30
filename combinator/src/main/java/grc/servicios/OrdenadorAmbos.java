package grc.servicios;

import grc.dominio.PlanEstudio;

import java.util.Collections;
import java.util.List;

public class OrdenadorAmbos
{
	List<Recomendacion> recomendaciones;
	Integer criterio;
	PlanEstudio planEstudio;
	
	public OrdenadorAmbos(List<Recomendacion> recomendaciones, Integer criterio)
	{
		this.recomendaciones = recomendaciones;
		this.criterio = criterio;
	}
	
	public void ordenar() 
	{
		if(criterio.equals(0)) //Ordenar por mayor cantidad materias y mayor cantidad poscorrelativas
		{
			Collections.sort(recomendaciones, new ComparadorMaterias(true));
			ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas();
			comparadorPoscorrelativas.setPlanEstudio(planEstudio);
			Collections.sort(recomendaciones, comparadorPoscorrelativas);
		}
		else if(criterio.equals(1)) //Ordenar por menor cantidad materias y mayor cantidad poscorrelativas
		{
			Collections.sort(recomendaciones, new ComparadorMaterias(false));
			ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas();
			comparadorPoscorrelativas.setPlanEstudio(planEstudio);
			Collections.sort(recomendaciones, comparadorPoscorrelativas);
		}
		else if(criterio.equals(2)) //Ordenar por mayor cantidad poscorrelativas y mayor cantidad de materias
		{
			ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas();
			comparadorPoscorrelativas.setPlanEstudio(planEstudio);
			Collections.sort(recomendaciones, comparadorPoscorrelativas);
			Collections.sort(recomendaciones, new ComparadorMaterias(true));
		}
		else if(criterio.equals(3)) //Ordenar por mayor cantidad poscorrelativas y menor cantidad de materias
		{
			ComparadorPoscorrelativas comparadorPoscorrelativas = new ComparadorPoscorrelativas();
			comparadorPoscorrelativas.setPlanEstudio(planEstudio);
			Collections.sort(recomendaciones, comparadorPoscorrelativas);
			Collections.sort(recomendaciones, new ComparadorMaterias(false));
		}
	}
	
	
	public void setPlanEstudio(PlanEstudio planEstudio)
	{
		this.planEstudio = planEstudio;
	}
	
}
