package grc.servicios;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CriterioOrdenSecuenciales extends CriterioOrden
{
	@OneToMany
	List<CriterioOrden> criterios;

	public CriterioOrdenSecuenciales()
	{
	}

	public CriterioOrdenSecuenciales(List<CriterioOrden> criterios)
	{
		this.criterios = criterios;
	}

	@Override
	public int compare(Recomendacion o1, Recomendacion o2)
	{
		for (CriterioOrden co : this.criterios)
		{
			if (co.compare(o1, o2) != 0)
			{
				return co.compare(o1, o2);
			}
		}
		return 0;
	}
}
