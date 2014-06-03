package grc.dao;

import grc.servicios.CriterioOrden;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class CriterioOrdenDAO
{
	private static CriterioOrdenDAO instancia = null;
	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;
	public static CriterioOrdenDAO getInstancia() throws Exception
	{
		if (instancia == null)
		{
			instancia = new CriterioOrdenDAO();
		}
		em = EntityManagerUtil.getNewEM();
		return instancia;
	}

	public void alta(CriterioOrden CO) throws Exception
	{
		int id = obtenerTodo().size();
		if(CO.getId()<=id)
			CO.setId(id+1);
		try
		{
			em.getTransaction().begin();
			em.merge(CO);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e)
		{
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<CriterioOrden> obtenerTodo()
	{
		List<CriterioOrden> a = null;
		Query query = em.createQuery("from CriterioOrden");
		a = query.getResultList();
		return a;
	}

	public CriterioOrden getCriterioOrden(int id)
	{
		CriterioOrden S = em.find(CriterioOrden.class, id);
		return S;
	}
}
