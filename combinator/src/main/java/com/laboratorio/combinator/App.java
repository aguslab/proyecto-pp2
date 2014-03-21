package com.laboratorio.combinator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //String act = "PP1 PP2 PP3 Mate Ingles";
        
        //CREO MATERIAS NUEVAS
        Materia pp1 = new Materia("pp1");
        Materia pp2 = new Materia("pp2");
        Materia pp3 = new Materia("pp3");
        
        //CREO TURNOS DISPONIBLES
        Turno man = new Turno("M");
        Turno tar = new Turno("T");
        Turno noc = new Turno("N");
        
        //CREO CURSOS
        Curso c1 = new Curso(pp1, man);
        Curso c2 = new Curso(pp2, man);
        Curso c3 = new Curso(pp3, tar);
        
        //ALGUNAS MATERIAS
        HashSet<Materia> materias = new HashSet<Materia>();
        materias.add(pp1);
        HashSet<Materia> materias2 = new HashSet<Materia>();
        materias2.add(pp2);
        
        //MATERIA (CLAVE) Y SUS CORRELATIVAS (SET)
        HashMap<Materia,Set<Materia>> m =new HashMap<Materia, Set<Materia>>();
        m.put(pp1, null);
        m.put(pp2, materias);
        m.put(pp3, materias2);
        
        
        //CREO UN PLAN DE ESTUDIOS
        PlanEstudios pe = new PlanEstudios(m);
        
        
        //CREO UN ALUMNO Y SUS MATERIAS APROBADAS
        Alumno alu = new Alumno("Javi", materias);
        
        //LISTA DE MATERIAS
        ArrayList<Materia> mat = new ArrayList<Materia>();
        mat.add(pp1);
        mat.add(pp2);
        mat.add(pp3);
        
        
        //temporal... materias a las que puede inscribirse
        String act = filtrarMaterias(mat, alu, m);
        
		String[] elem = act.split(" ");
		ArrayList<String> permutaciones = new ArrayList<String>(); 
		permutacionesSinRepeticiones(elem, "", elem.length, permutaciones);
		System.out.println(permutaciones.size());
		for (int i = 0; i < permutaciones.size(); i++) {
			System.out.println(permutaciones.get(i).trim());
		}
    }
    
    //devuelve materias a las que puede anotarse el alumno (sin tener en cuenta el horario)
    private static String filtrarMaterias(ArrayList<Materia> mat, Alumno alu, HashMap<Materia, Set<Materia>> corr) {
		String materiasAinscribirse = "";
		System.out.println(mat.size());
		mat.removeAll(alu.getMateriasAprob());
    	mat.size();
    	for(Materia m : mat){
    		if(!faltaCorrelativa(alu, m, corr)){
    			materiasAinscribirse = materiasAinscribirse + " " + m.getNombre();
    		}
    	}
    	
		return materiasAinscribirse;
	}
    
    
    
    private static boolean faltaCorrelativa(Alumno alu, Materia m, HashMap<Materia, Set<Materia>> corr){
    	if(corr.containsKey(m)){
    		if(alu.getMateriasAprob().containsAll(corr.get(m))){
    			System.out.println("contiene todas!!!");
    		}else{
    			System.out.println("NO contiene!");
    		}
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
	}
}
