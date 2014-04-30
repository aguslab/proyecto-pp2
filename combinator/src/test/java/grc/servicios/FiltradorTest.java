package grc.servicios;

import java.util.HashSet;
import java.util.Set;

import grc.modelo.Materia;
import grc.modelo.PlanEstudio;
import grc.servicios.Filtrador;
import grc.tmp.Alta_mat_cur_matApr;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FiltradorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltradorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltradorTest.class );
    }

    public void testFiltradorCursosDisponibles() throws Exception{
    	Filtrador fil = new Filtrador();
    	fil.getCursosDisponibles(12);	
    	assertNotNull(fil);
    }
    
    public void testFiltradorCorrelativas(){
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	PlanEstudio pe = a.getPlanEstudios();
    	Materia materiaACursar = new Materia("Laboratorio interdisciplinario");
    	materiaACursar.setId(30);
    	Set<Materia> materiasAprobadas = new HashSet<Materia>();
    	for(int i=0; i<15;i++){
    		materiasAprobadas.add(new Materia("A"+i));	
    	}
    	
    	Filtrador f = new Filtrador();
    	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    	System.out.println(pe.getCorrelativas().size());
    	boolean puedeCursar = f.tieneCorrelativas(pe, materiaACursar, materiasAprobadas);
    	assertTrue(puedeCursar);
    }
    
}
