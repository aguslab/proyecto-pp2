package grc.servicios;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class CriterioOrden implements Comparator<Recomendacion>
{
	@Id
	private int id;

	public CriterioOrden() {}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
}
