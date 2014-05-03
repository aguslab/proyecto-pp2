package grc.dominio;

import java.sql.Timestamp;
import java.util.Date;

import grc.dominio.Materia;
import grc.dominio.MateriaAprobada;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MateriaAprobadaTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MateriaAprobadaTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MateriaAprobadaTest.class );
    }

    public void testMateriaAprobada(){
    	MateriaAprobada m = new MateriaAprobada();
    	m.setId(1);
    	m.setNota(7.5);
    	
    	assertEquals(1, m.getId());
    }
    
    public void testMateriaAprobadasetMateria(){
    	Materia m = new Materia("M");
    	Timestamp f = new Timestamp(new Date().getTime());
    	MateriaAprobada ma = new MateriaAprobada(m, 8.0, f);
    	
    	assertEquals("M", ma.getMateriaAprobada().getNombre());
    }
    
    public void testMateriaAprobadaNota(){
    	Materia m = new Materia("M");
    	Timestamp f = new Timestamp(new Date().getTime());
    	MateriaAprobada ma = new MateriaAprobada(m, 8.0, f);
    	assertEquals(8.0, ma.getNota());
    }
    
    public void testMateriaAprobadaFecha(){
    	Materia m = new Materia("M");
    	Timestamp f = new Timestamp(new Date().getTime());
    	MateriaAprobada ma = new MateriaAprobada();
    	ma.setMateriaAprobada(m);
    	ma.setFechaAprobado(f);
    	assertEquals(f, ma.getFechaAprobado());
    }
    
}
