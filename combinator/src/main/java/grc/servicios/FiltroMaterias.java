package grc.servicios;

import java.util.ArrayList;
import java.util.List;

public class FiltroMaterias extends FiltroRecomendaciones
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
}
