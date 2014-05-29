package grc.servicios;

import java.util.ArrayList;
import java.util.List;

public class ComparadorMaterias extends Comparador
{
	public ArrayList<Integer> contarCantMaterias(List<Recomendacion> recomendaciones) 
	{
		ArrayList<Integer> cantidadMaterias = new ArrayList<Integer>();
		// Cuento la cantidad de poscorrelativas de cada recomendacion
		for (Recomendacion r : recomendaciones)
		{
			Integer cantMaterias = r.getRecomendacion().size();
			cantidadMaterias.add(cantMaterias);
		}
		return cantidadMaterias;
	}
	
	private Integer contarCantidadMaterias(Recomendacion recomendacion)
	{
		return recomendacion.getRecomendacion().size();
	}
	
	@Override
	public int compare(Recomendacion o1, Recomendacion o2) 
	{
		Integer cantidadRecomendacion1 = contarCantidadMaterias(o1);
		Integer cantidadRecomendacion2 = contarCantidadMaterias(o2);
		return cantidadRecomendacion2 - cantidadRecomendacion1;
	}
	

}
