package com.laboratorio.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.laboratorio.dao.CursoDAO;
import com.laboratorio.dao.HorarioDAO;
import com.laboratorio.dao.MateriaDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("null")
	public static void main( String[] args )
    {
        //String act = "PP1 PP2 PP3 Mate Ingles";
        
      //CREO MATERIAS NUEVAS
        Materia pp1 = new Materia("pp1");
        Materia pp2 = new Materia("pp2");
        Materia pp3 = new Materia("pp3");
        Materia mate1 = new Materia("mate1");
        Materia mate2 = new Materia("mate2");
        Materia ingles = new Materia("ingles");
        Materia ip = new Materia("IP");
        Materia irm = new Materia("IRM");
        Materia lecto = new Materia("Lectoescritura");
        Materia logica = new Materia("Lógica y teoría de números");
        
       
        
      //CREO DÍAS CON SUS TURNOS
//        HashMap<String, Turno> dias = new HashMap<String, Turno>();
//        dias.put("Lunes", man);
//        dias.put("Martes", tar);//TODO cambiar string como clave! puede haber dos dias iguales con distinto horario!!!
//        dias.put("Miercoles", noc);
        

        //CREO HORARIOS DISPONIBLES
        Horario n1 = new Horario("Lunes", 18, 22);
        Horario n2 = new Horario("Martes", 18, 22);
        Horario n3 = new Horario("Miercoles", 18, 20);
        Horario n4 = new Horario("Jueves", 18, 22);
        Horario n5 = new Horario("Miercoles", 20, 22);
        Horario n6 = new Horario("Viernes", 18, 22);
        Horario n7 = new Horario("Lunes", 18, 20);
        Horario n8 = new Horario("Lunes", 20, 22);
        Horario n9 = new Horario("Martes", 18, 20);
        Horario n10 = new Horario("Martes", 20, 22);
        Horario n11 = new Horario("Miercoles", 18, 22);
        Horario n12 = new Horario("Jueves", 18, 20);
        Horario n13 = new Horario("Jueves", 20, 22);
        Horario n14 = new Horario("Viernes", 18, 20);
        Horario n15 = new Horario("Viernes", 20, 22);
        ArrayList<Horario> horar = new ArrayList<Horario>();
        horar.add(n1);
        horar.add(n3);
        ArrayList<Horario> horar2 = new ArrayList<Horario>();
        horar2.add(n2);
        horar2.add(n4);
        ArrayList<Horario> horar3 = new ArrayList<Horario>();
        horar3.add(n5);
        horar3.add(n6);
        ArrayList<Horario> horar4 = new ArrayList<Horario>();
        horar4.add(n4);
        horar4.add(n12);
        ArrayList<Horario> horar5 = new ArrayList<Horario>();
        horar5.add(n13);
        horar5.add(n14);
        ArrayList<Horario> horar6 = new ArrayList<Horario>();
        horar6.add(n11);
        ArrayList<Horario> horar7 = new ArrayList<Horario>();
        horar7.add(n2);
        horar7.add(n15);
        
        //CREO CURSOS (materia q se dicta y en que turno)
        Curso c1 = new Curso(mate1, horar);
        Curso c2 = new Curso(pp1, horar2);
        Curso c3 = new Curso(ingles, horar3);
        Curso c4 = new Curso(pp2,horar4);
        Curso c5 = new Curso(pp2,horar5);
        Curso c6 = new Curso(ip,horar6);
        Curso c7 = new Curso(irm,horar5);
        Curso c8 = new Curso(lecto,horar7);
        
      //CREO MATERIA APROBADA
      //  MateriaAprobada matAprob1 = new MateriaAprobada(mate1,10.0);
        
        //CREO UN PLAN DE ESTUDIOS
       /* ArrayList<Materia> materias = new ArrayList<Materia>();
        materias.add(mate1);
        materias.add(mate2);
        ArrayList<Materia> correlativas = new ArrayList<Materia>();
        correlativas.add(mate1);
        PlanEstudio pe = new PlanEstudio(mate2,mate1);*/
        
        
        try 
        
        {
			//System.out.println("Materia que trajo: "+MateriaDAO.getInstancia().getMateria(1).getNombre());
			MateriaDAO.getInstancia().alta(mate1);
			MateriaDAO.getInstancia().alta(pp1);
			MateriaDAO.getInstancia().alta(ingles);
			MateriaDAO.getInstancia().alta(pp2);
			MateriaDAO.getInstancia().alta(ip);
	        MateriaDAO.getInstancia().alta(irm);
	        MateriaDAO.getInstancia().alta(lecto);
	        MateriaDAO.getInstancia().alta(logica);
			//MateriaAprobadaDAO.getInstancia().alta(matAprob1);
			CursoDAO.getInstancia().alta(c1);
			CursoDAO.getInstancia().alta(c2);
			CursoDAO.getInstancia().alta(c3);
			CursoDAO.getInstancia().alta(c4);
			CursoDAO.getInstancia().alta(c5);
			CursoDAO.getInstancia().alta(c6);
			CursoDAO.getInstancia().alta(c7);
			CursoDAO.getInstancia().alta(c8);
			
			HorarioDAO.getInstancia().alta(n1);
			HorarioDAO.getInstancia().alta(n2);
			HorarioDAO.getInstancia().alta(n3);
			HorarioDAO.getInstancia().alta(n4);
			HorarioDAO.getInstancia().alta(n5);
			HorarioDAO.getInstancia().alta(n6);
			HorarioDAO.getInstancia().alta(n7);
			HorarioDAO.getInstancia().alta(n8);
			HorarioDAO.getInstancia().alta(n9);
			HorarioDAO.getInstancia().alta(n10);
			HorarioDAO.getInstancia().alta(n11);
			HorarioDAO.getInstancia().alta(n12);
			HorarioDAO.getInstancia().alta(n13);
			HorarioDAO.getInstancia().alta(n14);
			HorarioDAO.getInstancia().alta(n15);
			
			
			//PlanEstudioDAO.getInstancia().alta(pe);
        	//System.out.println("cursos filtrados por turno: " + CursoDAO.getInstancia().getCursosPorTurno(8).size());
        	//System.out.println("cursos filtrados por turno: " + CursoDAO.getInstancia().getCursosPorTurno(13).get(0).getMateria().getNombre());
        	//System.out.println("cursos filtrados por turno: " + CursoDAO.getInstancia().getCursosPorTurno(13).get(1).getMateria().getNombre());
        	//System.out.println("cursos filtrados por turno: " + CursoDAO.getInstancia().getCursosPorTurno(13).get(2).getMateria().getNombre());
        	//System.out.println("cursos filtrados por turno: " + CursoDAO.getInstancia().getCursosPorTurno(13).get(3).getMateria().getNombre());
			
			/*
        	pp1.setId(2);
        	pp2.setId(3);
        	mate2.setId(4);
        	System.out.println("el id de pp1 es: " + pp1.getId());
        	System.out.println("el id de pp2 es: " + pp2.getId());
        	System.out.println("el id de mate2 es: " + mate2.getId());*/


			/*ArrayList<Curso> cursos = new ArrayList<Curso>();
			cursos.add(c1);
			cursos.add(c2);
			cursos.add(c3);
			CursoDAO.getInstancia().quitarAprobadas(cursos);
			for(int i = 0; i <cursos.size(); i++)
			{
				System.out.println("CURSOS sin aprobar= " + cursos.get(i).getMateria().getNombre());
			}*/
			
        	/*ArrayList<Curso> cursos = new ArrayList<Curso>();
			cursos.add(c1);
			cursos.add(c2);
			cursos.add(c3);
			CursoDAO.getInstancia().quitarCorrelativasNoCursables(cursos);
			System.out.println("¡");
			for(int i = 0; i <cursos.size(); i++)
			{
				System.out.println("CURSOS sin aprobar= " + cursos.get(i).getMateria().getNombre());
			}*/
        	
			
        	ArrayList<Curso> cursos = new ArrayList<Curso>();
			cursos.add(c1);
			cursos.add(c2);
			cursos.add(c3);
			cursos.add(c4);
			cursos.add(c5);
			cursos.add(c6);
			cursos.add(c7);
			cursos.add(c8);
						//Recomendacion r = new Recomendacion();
			System.out.println("Recomendación 1: ");
			Recomendacion r = CursoDAO.getInstancia().combinaciones(cursos);
			r.mostrarRecomendacion(r);
			/*r.getLunes()[3] = "Mate1";
			for (int i = 0; i < 4; i ++)
			{

				System.out.println(r.getLunes()[i]);
			}*/
		} 
        catch (Exception e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(true)
        	return;
        
        //ALGUNAS MATERIAS
        
        //se usaria para las materias que no tienen correlativas
        HashSet<Materia> Sinmaterias = new HashSet<Materia>();
        
        //vendrian a ser la materias correlativas de pp2
        HashSet<Materia> correlMaterias = new HashSet<Materia>();
        correlMaterias.add(pp1);
        
        //vendrian a ser la materias correlativas de pp3
        HashSet<Materia> correlMaterias2 = new HashSet<Materia>();
        correlMaterias2.add(pp1);
        correlMaterias2.add(pp2);
        
        //vendrian a ser la materias correlativas de mate2
        HashSet<Materia> correlMaterias3 = new HashSet<Materia>();
        correlMaterias3.add(mate1);
        
        //MATERIA (CLAVE) Y SUS CORRELATIVAS (SET)
        HashMap<Materia,Set<Materia>> m =new HashMap<Materia, Set<Materia>>();
        m.put(pp1, Sinmaterias);
        m.put(pp2, correlMaterias);
        m.put(pp3, correlMaterias2);
        m.put(mate1, Sinmaterias);
        m.put(mate2, correlMaterias3);
        m.put(ingles, Sinmaterias);
        
        
        
        
        //materias aprobadas por el alumno
        
        
        Set<Materia> aprobMaterias = null ;
        aprobMaterias.add(mate1);
		//CREO UN ALUMNO Y CARGO SUS MATERIAS APROBADAS
       // Alumno alu = new Alumno("Javi", aprobMaterias );
        
        //LISTA DE MATERIAS A DICTARSE
        ArrayList<Materia> mat = new ArrayList<Materia>();
        mat.add(pp1);
        mat.add(pp2);
        mat.add(pp3);
        mat.add(mate1);
        mat.add(mate2);
        mat.add(ingles);
        
        //Lista de cursos a dictarse
        ArrayList<Curso> cursosADictarse = new ArrayList<Curso>();
      /*  cursosADictarse.add(c1);
        cursosADictarse.add(c2);
        cursosADictarse.add(c3);*/

        //temporal... cursos a los que puede inscribirse, serian las materias sobre las cuales habria que hacer la combinatoria
    /*   String act = filtrarMaterias(cursosADictarse, alu, m);
        
		String[] elem = act.split(" ");
		System.out.println("sasdas"+elem[0]);
		ArrayList<String> permutaciones = new ArrayList<String>(); 
		permutacionesSinRepeticiones(elem, "", elem.length, permutaciones);
		System.out.println(permutaciones.size());
		System.out.println("POSIBLES MATERIAS A ANOTARSE SIN TENER EN CUENTA EL HORARIO");
		for (int i = 0; i < permutaciones.size(); i++) {
			System.out.println(permutaciones.get(i).trim());
		}*/
    }
    
   /* //devuelve materias a las que puede anotarse el alumno (sin tener en cuenta el horario)
    //mat son todas las materias que estan disponibles a dar (en realidad tiene que ser cursos, no materias)
    private static String filtrarMaterias(ArrayList<Curso> cursosADictarse, Alumno alu, HashMap<Materia, Set<Materia>> corr) {
		String materiasAinscribirse = "";
		//de las materias a dictarse, saco las materias que ya tiene aprobadas el alumno
		cursosADictarse.removeAll(alu.getMateriasAprob());
//    	for(Materia m : cursosADictarse){
//    		//de las materias que no tiene aprobadas el alumno, me fijo si tiene las correlativas para poder cursarla
//    		//y las agrego a las posibles materias a inscribirse
//    		if(tieneCorrelativas(alu, m, corr)){
//    			materiasAinscribirse = materiasAinscribirse.isEmpty() ? m.getNombre() : materiasAinscribirse + " " + m.getNombre();
//    		}
//    	}
    	
		return materiasAinscribirse;*/
	}
    
    
    
   /* private static boolean tieneCorrelativas(Alumno alu, Materia m, HashMap<Materia, Set<Materia>> corr){
    	//SIEMPRE deberia tenerlo, si no es algun problema nuestro
    	if(corr.containsKey(m)){
    		return alu.getMateriasAprob().containsAll(corr.get(m));
    	}
    	
    	return false;
    }

	public static void permutacionesSinRepeticiones(String[] elem, String act, int n, ArrayList<String> permutaciones) {
		if (n == 0) {
			permutaciones.add(act);
		} else {
			for (int i = 0; i < elem.length; i++) {
				if (!act.contains(elem[i])) { // Controla que no haya repeticiones
					permutacionesSinRepeticiones(elem, act + elem[i] + " ", n - 1, permutaciones);
				}
			}
		}
	}*/

