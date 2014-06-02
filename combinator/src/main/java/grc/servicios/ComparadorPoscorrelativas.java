package grc.servicios;

import grc.dominio.Curso;
import grc.dominio.PlanEstudio;

public class ComparadorPoscorrelativas extends Comparador
{
	PlanEstudio planEstudio;
	
	@Override
	public int compare(Recomendacion o1, Recomendacion o2) 
	{
		Integer cantidadRecomendacion1 = contarCantidadPoscorrelativas(o1, planEstudio);
		Integer cantidadRecomendacion2 = contarCantidadPoscorrelativas(o2, planEstudio);
		return cantidadRecomendacion2 - cantidadRecomendacion1;
	}
	
	public Integer contarCantidadPoscorrelativas(Recomendacion recomendacion, PlanEstudio planEstudio)
	{
		Integer cantidadPoscorrelativas = 0;
		for (Curso c : recomendacion.getRecomendacion()) // Por cada curso en la recomendacion
		{
			cantidadPoscorrelativas+=planEstudio.getCantidadPoscorrelativas(c.getMateria());
		}
		return cantidadPoscorrelativas;
	}
	
	public void setPlanEstudio(PlanEstudio planEstudio)
	{
		this.planEstudio = planEstudio;
	}
}
