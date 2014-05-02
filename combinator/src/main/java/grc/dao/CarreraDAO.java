package grc.dao;

import grc.dominio.Carrera;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CarreraDAO
{
	private static CarreraDAO instancia = null;
	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;
	public static CarreraDAO getInstancia() throws Exception
	{
		if (instancia == null)
		{
			instancia = new CarreraDAO();
		}
		em = EntityManagerUtil.getNewEM();
		return instancia;
	}

	public void alta(Carrera C) throws Exception
	{
		try
		{
			em.getTransaction().begin();
			em.merge(C);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e)
		{
			em.getTransaction().rollback();
			throw e;
		}
	}

	public Carrera getCarrera(int id)
	{
		return em.find(Carrera.class, id);
	}


}
