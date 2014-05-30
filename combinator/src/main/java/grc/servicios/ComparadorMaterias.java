package grc.servicios;

public class ComparadorMaterias extends Comparador
{
	Boolean criterio;
	
	public  ComparadorMaterias(Boolean criterio)
	{
		this.criterio = criterio;
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
		if(criterio)
			return cantidadRecomendacion2 - cantidadRecomendacion1; //Mayor a menor
		else
			return cantidadRecomendacion1 - cantidadRecomendacion2; //Menor a mayor
	}
	

	/*public ArrayList<Integer> contarCantMaterias(List<Recomendacion> recomendaciones) 
	{
		ArrayList<Integer> cantidadMaterias = new ArrayList<Integer>();
		// Cuento la cantidad de poscorrelativas de cada recomendacion
		for (Recomendacion r : recomendaciones)
		{
			Integer cantMaterias = r.getRecomendacion().size();
			cantidadMaterias.add(cantMaterias);
		}
		return cantidadMaterias;
	}*/
	
}
