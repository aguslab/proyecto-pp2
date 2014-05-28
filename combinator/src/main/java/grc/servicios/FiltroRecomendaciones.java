package grc.servicios;

import java.util.Collections;
import java.util.List;

class FiltroRecomendaciones
{
	/*public List<Recomendacion> ordenar(List<Recomendacion> recomendaciones, ArrayList<Integer> cantidad)
	{
		System.out.println("cantidad de recos" + recomendaciones.size());
		// ordeno segun las cantidades de poscorrelativas de cada recomendacion
		Recomendacion rTemp;
		int temp, j;
		for (int i = 1; i < cantidad.size(); i++)
		{
			temp = cantidad.get(i);
			rTemp = recomendaciones.get(i);
			j = i;
			while (j > 0 && cantidad.get(j - 1) < temp)
			{
				cantidad.set(j, cantidad.get(j - 1));
				recomendaciones.set(j, recomendaciones.get(j - 1));
				j--;
			}
			cantidad.set(j, temp);
			recomendaciones.set(j, rTemp);
		}
		return recomendaciones;
	}
*/
	public void ordenar (List<RecomendacionComparable> rComparables)
	{
		Collections.sort(rComparables, new Comparador());
	}
}
