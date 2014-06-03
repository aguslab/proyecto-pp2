package grc.servicios;

import java.util.Comparator;

import javax.persistence.Id;

public abstract class CriterioOrden implements Comparator<Recomendacion>
{
	@Id
	private int id;

	public CriterioOrden() {}
	
	public CriterioOrden(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
