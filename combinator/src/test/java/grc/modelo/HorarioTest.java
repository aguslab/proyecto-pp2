package grc.modelo;

import grc.modelo.Horario;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HorarioTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HorarioTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HorarioTest.class );
    }

    public void testHorario(){
    	Horario h = new Horario();
    	h.setId(1);
    	h.setDia("Lunes");
    	h.setHoraFin(22);
    	h.setHoraInicio(18);
    	
    	assertEquals("Lunes", h.getDia());
    }
    
    public void testHorarioHora(){
    	Horario h = new Horario();
    	h.setHoraFin(20);
    	h.setHoraInicio(18);
    	
    	assertEquals(2, h.getHoraFin()-h.getHoraInicio());
    }
    
}
