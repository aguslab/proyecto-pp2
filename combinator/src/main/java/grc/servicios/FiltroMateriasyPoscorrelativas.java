package grc.servicios;

import grc.dominio.PlanEstudio;

import java.util.List;

public class FiltroMateriasyPoscorrelativas
{
	public List<Recomendacion> ordenarRecomendaciones(List<Recomendacion> recomendaciones, PlanEstudio pe)
	{
		FiltroMaterias fm = new FiltroMaterias();
		fm.ordenar(recomendaciones);
		FiltroPoscorrelativas fp = new FiltroPoscorrelativas();
		fp.ordenar(recomendaciones, pe);
		return recomendaciones;
	}
}
