package grc.servicios;

import java.util.Comparator;

public class Comparador implements Comparator<RecomendacionComparable>
{
	@Override
	public int compare(RecomendacionComparable o1, RecomendacionComparable o2)
	{
		return o2.getCantidad() - o1.getCantidad();
	}
}
