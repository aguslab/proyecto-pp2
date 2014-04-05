package com.laboratorio.dao;

import org.mockito.Mockito;

import com.laboratorio.modelo.Horario;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HorarioDAOTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HorarioDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HorarioDAOTest.class );
    }
    
    private Horario h = Mockito.mock(Horario.class);
    private HorarioDAO hdao = Mockito.mock(HorarioDAO.class);
    
    public void testAltaHorario(){
    	h.setDia("LUNES");
    	h.setHoraInicio(18);
    	h.setHoraFin(22);
    	try {
			hdao.alta(h);
		} catch (Exception e1) {
			assertTrue(false);
		}
    	
    	Mockito.verify(h).setDia(Mockito.anyString());
    	Mockito.verify(h).setHoraInicio(Mockito.anyInt());
    	Mockito.verify(h).setHoraFin(Mockito.anyInt());
    	
    	try {
			Mockito.verify(hdao).alta(h);
		} catch (Exception e) {
			assertTrue(false);
		}
    	
    	assertTrue(true);
    }
    
	public void testAltaHorarioFail() throws Exception {
		hdao.alta(h);
		Mockito.verify(hdao).alta(h);
		
		assertTrue(false);
	}
    
}
