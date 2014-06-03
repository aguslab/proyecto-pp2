package grc.servicios;

public class CriterioOrdenPorMaterias extends CriterioOrden
{
	Boolean ordenAscendente;
	
	public CriterioOrdenPorMaterias(int id, Boolean ordenAscendente)
	{
		super(id);
		this.ordenAscendente = ordenAscendente;
	}
	
	public Integer contarCantidadMaterias(Recomendacion recomendacion)
	{
		return recomendacion.getRecomendacion().size();
	}
	
	@Override
	public int compare(Recomendacion o1, Recomendacion o2) 
	{
		Integer cantidadRecomendacion1 = contarCantidadMaterias(o1);
		Integer cantidadRecomendacion2 = contarCantidadMaterias(o2);
		if(ordenAscendente)
			return cantidadRecomendacion2 - cantidadRecomendacion1; //Mayor a menor
		else
			return cantidadRecomendacion1 - cantidadRecomendacion2; //Menor a mayor
	}
}
