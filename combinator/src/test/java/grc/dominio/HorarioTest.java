package grc.dominio;

import grc.dominio.Dia;
import grc.dominio.Horario;
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
    	Dia lun = Dia.LUNES;
    	h.setDia(lun);
    	h.setHoraFin(22);
    	h.setHoraInicio(18);
    	
    	assertEquals("LUNES", h.getDia().name());
    }
    
    public void testHorarioHora(){
    	Horario h = new Horario();
    	h.setHoraFin(20);
    	h.setHoraInicio(18);
    	
    	assertEquals(2, h.getHoraFin()-h.getHoraInicio());
    }
    
    public void testHorarioHoraIniFin(){
    	Horario h = new Horario(18, 22);
    	
    	assertEquals(4, h.getHoraFin()-h.getHoraInicio());
    }
    
    public void testHorarioId(){
    	Horario h = new Horario();
    	h.setHoraFin(20);
    	h.setHoraInicio(18);
    	h.setId(10);
    	assertEquals(10, h.getId());
    }
    
}
