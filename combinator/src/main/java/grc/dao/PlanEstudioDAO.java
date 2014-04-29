package grc.dao;

import grc.modelo.PlanEstudio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class PlanEstudioDAO 
{
	private static PlanEstudioDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static PlanEstudioDAO getInstancia() throws Exception 
	{
		if (instancia == null)
		{
			instancia = new PlanEstudioDAO();
		}
		em = grc.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}
	
	
	public void alta(PlanEstudio PE) throws Exception 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(PE);
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
	public List<PlanEstudio> obtenerTodo() 
	{
		List<PlanEstudio> a = null;
		Query query = em.createQuery("from PlanEstudio");
		a = query.getResultList();
		return a;
	}

}
