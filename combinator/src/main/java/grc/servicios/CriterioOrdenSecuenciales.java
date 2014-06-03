package grc.servicios;

import java.util.List;

public class CriterioOrdenSecuenciales extends CriterioOrden
{
	List<CriterioOrden> criterios;
	
	public  CriterioOrdenSecuenciales(int id, List<CriterioOrden> criterios)
	{
		super(id);
//		CriterioOrdenPorMaterias copm =  new CriterioOrdenPorMaterias(true);
//		List<CriterioOrden> co = new ArrayList<CriterioOrden>();
//		co.add(copm);
//		CriterioOrdenSecuenciales cos = new CriterioOrdenSecuenciales(co);
		this.criterios = criterios;
	}
	
	@Override
	public int compare(Recomendacion o1, Recomendacion o2) 
	{
		for(CriterioOrden co : this.criterios){
			if(co.compare(o1, o2) != 0){
				return co.compare(o1, o2);
			}
		}
		return 0;	
	}
}
