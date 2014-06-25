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

    public void testHorario()
    {
    	Horario h = new Horario();
    	Dia lun = Dia.LUNES;
    	h.setDia(lun);
    	h.setHoraFin(22.);
    	h.setHoraInicio(18.);
    	
    	assertEquals("LUNES", h.getDia().name());
    }
    
    public void testHorarioHora()
    {
    	Horario h = new Horario();
    	h.setHoraFin(20.);
    	h.setHoraInicio(18.);
    	
    	assertEquals(2.0, h.getHoraFin()-h.getHoraInicio());
    }
    
    public void testHorarioHoraIniFin()
    {
    	Horario h = new Horario(18., 22.);
    	
    	assertEquals(4.0, h.getHoraFin()-h.getHoraInicio());
    }
    
    public void testHorarioId()
    {
    	Horario h = new Horario();
    	h.setHoraFin(20.);
    	h.setHoraInicio(18.);
    	h.setId(10);
    	assertEquals(10, h.getId());
    }

    public void testHorarioSeSolapaCon1()
    {
    	Horario h = new Horario(18., 22.);
    	Horario h2 = new Horario(18., 20.);
    	
    	assertEquals(true,h.seSolapaCon(h2));
    }
    
    public void testHorarioSeSolapaCon2()
    {
    	Horario h = new Horario(9., 10.);
    	Horario h2 = new Horario(8., 12.);
    	
    	assertEquals(true,h.seSolapaCon(h2));
    }
    
    public void testHorarioSeSolapaCon3()
    {
    	Horario h = new Horario(9., 10.);
    	Horario h2 = new Horario(9., 10.);
    	
    	assertEquals(true,h.seSolapaCon(h2));
    }
    
    public void testHorarioSeSolapaCon4()
    {
    	Horario h = new Horario(9., 12.);
    	Horario h2 = new Horario(8., 10.);
    	
    	assertEquals(true,h.seSolapaCon(h2));
    }
    
    public void testHorarioSeSolapaCon5()
    {
    	Horario h = new Horario(9., 11.);
    	Horario h2 = new Horario(9., 12.);
    	
    	assertEquals(true,h.seSolapaCon(h2));
    }
    
    public void testHorarioSeSolapaCon6()
    {
    	Horario h = new Horario(15., 18.);
    	Horario h2 = new Horario(15., 17.);
    	
    	assertEquals(true,h.seSolapaCon(h2));
    }

    public void testHorarioSeSolapaCon7()
    {
    	Horario h = new Horario(10., 12.);
    	Horario h2 = new Horario(12., 12.3);
    	
    	assertEquals(false,h.seSolapaCon(h2) && h2.seSolapaCon(h));
    }
    
    public void testHorarioSeSolapaCon8()
    {
    	Horario h = new Horario(12., 12.3);
    	Horario h2 = new Horario(8., 12.);
    	
    	assertEquals(false,h.seSolapaCon(h2) && h2.seSolapaCon(h));
    }
    
    public void testHorarioSeSolapaCon9()
    {
    	Horario h = new Horario(12., 12.3);
    	Horario h2 = new Horario(8., 12.2);
    	
    	assertEquals(true,h.seSolapaCon(h2) && h2.seSolapaCon(h));
    }
    
    public void testHorarioSeSolapaCon10()
    {
    	Horario h = new Horario(10., 12.);
    	Horario h2 = new Horario(8., 10.);
    	
    	assertFalse(h.seSolapaCon(h2) && h2.seSolapaCon(h));
    }
    
    public void testHorarioSeSolapaCon11()
    {
    	Horario h = new Horario(8., 10.);
    	Horario h2 = new Horario(8.3, 9.3);
    	
    	assertEquals(true,h.seSolapaCon(h2) && h2.seSolapaCon(h));
    }
    
    public void testHorarioSeSolapaCon12()
    {
    	Horario h = new Horario(8., 12.);
    	Horario h2 = new Horario(8., 10.);
    	
    	assertEquals(true,h.seSolapaCon(h2));
    }
    
    public void testHorarioNoSeSolapaCon()
    {
    	Horario h = new Horario(18.30, 20.30);
    	Horario h2 = new Horario(20.35, 22.);
    	
    	assertFalse(h.seSolapaCon(h2));
    }
}
