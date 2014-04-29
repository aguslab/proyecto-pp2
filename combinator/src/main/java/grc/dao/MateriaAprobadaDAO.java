package grc.dao;

import grc.modelo.MateriaAprobada;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class MateriaAprobadaDAO 
{
	private static MateriaAprobadaDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static MateriaAprobadaDAO getInstancia() throws Exception 
	{
		if (instancia == null)
		{
			instancia = new MateriaAprobadaDAO();
		}
		em = grc.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}
	
	
	public void alta(MateriaAprobada MA) throws Exception 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(MA);
			em.flush();
			em.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<MateriaAprobada> obtenerTodo() 
	{
		List<MateriaAprobada> a = null;
		Query query = em.createQuery("from MateriaAprobada");
		a = query.getResultList();
		return a;
	}

}
