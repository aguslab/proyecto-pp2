package grc.servicios;

import grc.dominio.PlanEstudio;
import grc.modelo.GRCModel;

import java.util.ArrayList;
import java.util.List;

public class FiltroMateriasyPoscorrelativas extends FiltroRecomendaciones
{
	List<RecomendacionComparable> rComparables = new ArrayList<RecomendacionComparable>();
	ArrayList<Integer> cantidad;
	List<Recomendacion> recomendaciones = null;
	
	public void ordenarRecomendaciones(List<Recomendacion> recomendaciones, PlanEstudio planEstudio)
	{
		
		/*FiltroMaterias fm = new FiltroMaterias();
		cantidad = fm.contar(recomendaciones);
		rComparables = GRCController.crearRecomendacionesComparables(recomendaciones, cantidad);
		fm.ordenar(rComparables);

		FiltroPoscorrelativas fp = new FiltroPoscorrelativas();
		cantidad = fp.contar(recomendaciones, planEstudio);
		rComparables = crearRecomendacionesComparables(recomendaciones, cantidad);
		fp.ordenar(rComparables);
		
		recomendaciones = armarRecomendaciones(rComparables);*/
	}
}
