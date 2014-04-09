package com.laboratorio.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.laboratorio.dao.CursoDAO;
import com.laboratorio.dao.MateriaAprobadaDAO;
import com.laboratorio.dao.MateriaDAO;
import com.laboratorio.dao.PlanEstudioDAO;
import com.laboratorio.servicios.Combinador;

public class App 
{
    public static void main( String[] args )
    {
        //String act = "PP1 PP2 PP3 Mate Ingles";
        
      //CREO MATERIAS NUEVAS
    	Materia ip = new Materia("Introducción a la Programación");
    	ip.setId(1);
        Materia introALaMatematica = new Materia("Introducción a la Matemática");
        introALaMatematica.setId(2);
        Materia lecto = new Materia("Taller de Lectoescritura");
        lecto.setId(3);
        Materia prog1 = new Materia("Programación I");
        prog1.setId(4);
        Materia logica = new Materia("Lógica y teoría de números");
        logica.setId(5);
        Materia orga1 = new Materia("Organización del computador I");
        orga1.setId(6);
        Materia prog2 = new Materia("Programación II");
        prog2.setId(7);
        Materia algebraLineal = new Materia("Algebra Lineal");
        algebraLineal.setId(8);
        Materia sisto1 = new Materia("Sistemas Operativos y Redes I");
        sisto1.setId(9);
        Materia prog3 = new Materia("Programación III");
        prog3.setId(10);
        Materia calculo1 = new Materia("Calculo I");
        calculo1.setId(11);
        Materia psec = new Materia("Problemas Socioeconómicos contemporáneos");
        psec.setId(12);
        Materia baseDatos1 = new Materia("Base de datos I");
        baseDatos1.setId(13);
        Materia mateDiscreta = new Materia("Matemática Discreta");
        mateDiscreta.setId(14);
        Materia especificacionSoft = new Materia("Especificaciones y verificaciones de Software");
        especificacionSoft.setId(15);
        Materia teoriaDeLaComputacion = new Materia("Teoría de la computación");
        teoriaDeLaComputacion.setId(16);
        Materia ingenieria1 = new Materia("Ingeniería de software I");
        ingenieria1.setId(17);
        Materia probabilidadEstadistica = new Materia("Probabilidad y Estadística");
        probabilidadEstadistica.setId(18);
        Materia pp1 = new Materia("Proyecto Profesional I");
        pp1.setId(19);
        Materia ingenieria2 = new Materia("Ingeniería de software II");
        ingenieria2.setId(20);
        Materia orga2 = new Materia("Organización del computador II");
        orga2.setId(21);
        Materia pp2 = new Materia("Proyecto Profesional II");
        pp2.setId(22);
        Materia baseDatos2 = new Materia("Base de datos II");
        baseDatos2.setId(23);
        Materia sisto2 = new Materia("Sistemas Operativos y Redes II");
        sisto2.setId(24);
        Materia practicaProfSup1 = new Materia("Práctica Profesional Supervisada I");
        practicaProfSup1.setId(25);
        Materia modeladoYOptimizacion = new Materia("Modelado y Optimización");
        modeladoYOptimizacion.setId(26);
        Materia informaticaYSociedad= new Materia("Informática y Sociedad");
        informaticaYSociedad.setId(27);
        Materia practicaProfSup2 = new Materia("Práctica Profesional Supervisada II");
        practicaProfSup2.setId(28);
        Materia gestionProyectos = new Materia("Gestión de Proyectos");
        gestionProyectos.setId(29);
        Materia laboratorioInterdisciplinario = new Materia("Laboratorio interdisciplinario");
        laboratorioInterdisciplinario.setId(30);
        Materia tallerUtilitarios = new Materia("Taller de Utilitarios");
        tallerUtilitarios.setId(31);
        Materia ingles1 = new Materia("Ingles Lectocomprension I");
        ingles1.setId(32);
        Materia ingles2 = new Materia("Ingles Lectocomprension II");
        ingles2.setId(33);
        Materia ingles3 = new Materia("Ingles Lectocomprension III");
        ingles3.setId(34);
        
        
       
        
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
        //Curso cursoCalculo1 = new Curso(calculo1, horar);
        //Curso cursoPP1 = new Curso(pp1, horar2);
        Curso cursoIngles1 = new Curso(ingles1, horar3);
        Curso cursoPP2 = new Curso(pp2,horar4);
        Curso cursoIP = new Curso(ip,horar);
        Curso cursoIntroALaMatematica = new Curso(introALaMatematica,horar5);
        Curso cursoLecto = new Curso(lecto,horar6);
        Curso cursoPsec = new Curso(psec,horar2);
        Curso cursoUtil = new Curso(tallerUtilitarios,horar);
        
        //CREO PLAN DE ESTUDIOS
        Set<Materia> sinCorrelativas = new HashSet<Materia>();
        
        Set<Materia> correlativasProg1 = new HashSet<Materia>();
        correlativasProg1.add(ip);
        
        Set<Materia> correlativasLogica = new HashSet<Materia>();
        correlativasLogica.add(introALaMatematica);
        
        Set<Materia> correlativasProg2 = new HashSet<Materia>();
        correlativasProg2.add(prog1);
        
        Set<Materia> correlativasAlgebraLineal = new HashSet<Materia>();
        correlativasAlgebraLineal.add(introALaMatematica);
        
        Set<Materia> correlativasSisto1 = new HashSet<Materia>();
        correlativasSisto1.add(orga1);
        
        Set<Materia> correlativasProg3 = new HashSet<Materia>();
        correlativasProg3.add(prog2);
        
        Set<Materia> correlativasCalculo1 = new HashSet<Materia>();
        correlativasCalculo1.add(introALaMatematica);
        
        Set<Materia> correlativasBaseDatos1 = new HashSet<Materia>();
        correlativasBaseDatos1.add(logica);
        correlativasBaseDatos1.add(prog2);
        
        Set<Materia> correlativasMateDiscreta = new HashSet<Materia>();
        correlativasMateDiscreta.add(logica);
        correlativasMateDiscreta.add(calculo1);
        correlativasMateDiscreta.add(algebraLineal);
        
        Set<Materia> correlativasEspecificacion = new HashSet<Materia>();
        correlativasEspecificacion.add(logica);
        
        Set<Materia> correlativasTeoriaComputacion = new HashSet<Materia>();
        correlativasTeoriaComputacion.add(prog3);
        correlativasTeoriaComputacion.add(mateDiscreta);
        correlativasTeoriaComputacion.add(orga1);
        
        Set<Materia> correlativasIngeieria1 = new HashSet<Materia>();
        correlativasIngeieria1.add(prog3);
        
        Set<Materia> correlativasProbabilidadEstadistica = new HashSet<Materia>();
        correlativasProbabilidadEstadistica.add(calculo1);
        correlativasProbabilidadEstadistica.add(mateDiscreta);
        
        Set<Materia> correlativasPP1 = new HashSet<Materia>();
        correlativasPP1.add(prog3);
        correlativasPP1.add(baseDatos1);
        correlativasPP1.add(ingenieria1);
        correlativasPP1.add(especificacionSoft);
        
        Set<Materia> correlativasIngenieria2 = new HashSet<Materia>();
        correlativasIngenieria2.add(ingenieria1);
        
        Set<Materia> correlativasOrga2 = new HashSet<Materia>();
        correlativasOrga2.add(orga1);
        
        Set<Materia> correlativasPP2 = new HashSet<Materia>();
        correlativasPP2.add(pp1);
        
        Set<Materia> correlativasBaseDatos2 = new HashSet<Materia>();
        correlativasBaseDatos2.add(baseDatos1);
        correlativasBaseDatos2.add(prog3);
        
        Set<Materia> correlativasSisto2 = new HashSet<Materia>();
        correlativasSisto2.add(sisto1);
        
        Set<Materia> correlativasPracticaProfSup1 = new HashSet<Materia>();
        correlativasPracticaProfSup1.add(pp2);
        correlativasPracticaProfSup1.add(baseDatos2);
        
        Set<Materia> correlativasModeladoOptim = new HashSet<Materia>();
        correlativasModeladoOptim.add(probabilidadEstadistica);
        
        Set<Materia> correlativasInformaticaSociedad = new HashSet<Materia>();
        correlativasInformaticaSociedad.add(ingenieria1);
        
        Set<Materia> correlativasPracticaProfSup2 = new HashSet<Materia>();
        correlativasPracticaProfSup2.add(practicaProfSup1);
        correlativasPracticaProfSup2.add(modeladoYOptimizacion);
        
        Set<Materia> correlativasGestionProyectos = new HashSet<Materia>();
        correlativasGestionProyectos.add(ingenieria2);
        
        //TODO CASO ESPECIAL!! necesita 11 materias cualquiera!!
//        Set<Materia> correlativasLaboratorioInterdisciplinario = new HashSet<Materia>();
        
        Set<Materia> correlativasIngles2 = new HashSet<Materia>();
        correlativasIngles2.add(ingles1);
        
        Set<Materia> correlativasIngles3 = new HashSet<Materia>();
        correlativasIngles2.add(ingles2);
        
        HashMap<Materia,Set<Materia>> correlativas = new HashMap<Materia, Set<Materia>>();
        correlativas.put(ip, sinCorrelativas);
        correlativas.put(introALaMatematica, sinCorrelativas);
        correlativas.put(lecto, sinCorrelativas);
        correlativas.put(prog1, correlativasProg1);
        correlativas.put(logica, correlativasLogica);
        correlativas.put(orga1, sinCorrelativas);
        correlativas.put(prog2, correlativasProg2);
        correlativas.put(algebraLineal, correlativasAlgebraLineal);
        correlativas.put(sisto1, correlativasSisto1);
        correlativas.put(prog3, correlativasProg3);
        correlativas.put(calculo1, correlativasCalculo1);
        correlativas.put(psec, sinCorrelativas);
        correlativas.put(baseDatos1, correlativasBaseDatos1);
        correlativas.put(mateDiscreta, correlativasMateDiscreta);
        correlativas.put(especificacionSoft, correlativasEspecificacion);
        correlativas.put(teoriaDeLaComputacion, correlativasTeoriaComputacion);
        correlativas.put(ingenieria1, correlativasIngeieria1);
        correlativas.put(probabilidadEstadistica, correlativasProbabilidadEstadistica);
        correlativas.put(pp1, correlativasPP1);
        correlativas.put(ingenieria2, correlativasIngenieria2);
        correlativas.put(orga2, correlativasOrga2);
        correlativas.put(pp2, correlativasPP2);
        correlativas.put(baseDatos2, correlativasBaseDatos2);
        correlativas.put(sisto2, correlativasSisto2);
        correlativas.put(practicaProfSup1, correlativasPracticaProfSup1);
        correlativas.put(modeladoYOptimizacion, correlativasModeladoOptim);
        correlativas.put(informaticaYSociedad, correlativasInformaticaSociedad);
        correlativas.put(practicaProfSup2, correlativasPracticaProfSup2);
        correlativas.put(gestionProyectos, correlativasGestionProyectos);
        //TODO CASO ESPECIAL!!! 
//      correlativas.put(laboratorioInterdisciplinario, );
        correlativas.put(ingles1, sinCorrelativas);
        correlativas.put(ingles2, correlativasIngles2);
        correlativas.put(ingles3, correlativasIngles3);
        
        
        PlanEstudio planEstudio = new PlanEstudio(correlativas);
        
        
      /*//CREO MATERIA APROBADA
      MateriaAprobada matAprobCalculo1 = new MateriaAprobada(calculo1,10.0);
      MateriaAprobada matAprobIngles1 = new MateriaAprobada(ingles1,10.0);
      MateriaAprobada matAprobPP1 = new MateriaAprobada(pp1,10.0);
      MateriaAprobada matAprobIP = new MateriaAprobada(ip,10.0);
      MateriaAprobada matAprobIntroALaMatematica = new MateriaAprobada(introALaMatematica,10.0);
      MateriaAprobada matAprobLecto = new MateriaAprobada(lecto,10.0);
      MateriaAprobada matAprobTallerUtilitarios = new MateriaAprobada(tallerUtilitarios,10.0);*/
        
        try 
        
        {
			//System.out.println("Materia que trajo: "+MateriaDAO.getInstancia().getMateria(1).getNombre());
			MateriaDAO.getInstancia().alta(calculo1);
			MateriaDAO.getInstancia().alta(pp1);
			MateriaDAO.getInstancia().alta(ingles1);
			MateriaDAO.getInstancia().alta(pp2);
			MateriaDAO.getInstancia().alta(ip);
	        MateriaDAO.getInstancia().alta(introALaMatematica);
	        MateriaDAO.getInstancia().alta(lecto);
	        MateriaDAO.getInstancia().alta(logica);
	        MateriaDAO.getInstancia().alta(psec);
	        
	      //  CursoDAO.getInstancia().alta(cursoCalculo1);
			//CursoDAO.getInstancia().alta(cursoPP1);
			CursoDAO.getInstancia().alta(cursoIngles1);
			CursoDAO.getInstancia().alta(cursoPP2);
			CursoDAO.getInstancia().alta(cursoIP);
			CursoDAO.getInstancia().alta(cursoIntroALaMatematica);
			CursoDAO.getInstancia().alta(cursoLecto);
			CursoDAO.getInstancia().alta(cursoPsec);
			CursoDAO.getInstancia().alta(cursoUtil);
			
			/*MateriaAprobadaDAO.getInstancia().alta(matAprobIngles1);
			MateriaAprobadaDAO.getInstancia().alta(matAprobIP);
			MateriaAprobadaDAO.getInstancia().alta(matAprobIntroALaMatematica);*/
			
			
			PlanEstudioDAO.getInstancia().alta(planEstudio);

			/*ArrayList<Curso> cursosACursar = new ArrayList<Curso>();
			cursosACursar.add(cursoCalculo1);
			cursosACursar.add(cursoPP1);
			cursosACursar.add(cursoIngles1);
			cursosACursar.add(cursoPP2);
			cursosACursar.add(cursoIP);
			cursosACursar.add(cursoIntroALaMatematica7);
			cursosACursar.add(cursoLecto);
			
			Set<Materia> materiasAprobadas = new HashSet<Materia>();
			materiasAprobadas.add(calculo1);
			materiasAprobadas.add(ingles1);
			materiasAprobadas.add(pp1);
			materiasAprobadas.add(ip);
			materiasAprobadas.add(introALaMatematica);
			materiasAprobadas.add(lecto);
			materiasAprobadas.add(tallerUtilitarios);*/
			
			Combinador com = new Combinador();
			Set<Curso> cursosDisponiblesTurnoNoche = com.getCursosDisponibles(18);
			System.out.println("Cursos disponibles a cursar despues de ser filtrados");
			for(Curso c : cursosDisponiblesTurnoNoche){
				System.out.println(c.getMateria().getNombre());
			}
			System.out.println();
			System.out.println();
			
//			ArrayList<Recomendacion> recomendaciones = CursoDAO.getInstancia().combinaciones(cursosDisponiblesTurnoNoche);
//			ArrayList<String> r = Recomendacion.armarRecomendacion(recomendaciones);
//			for(int i = 0 ; i < r.size(); i++)
//			{
//				System.out.println(i +")" + r.get(i));
//			}
			
			
			/*for (List<Curso> listacur : CursoDAO.getInstancia().getCursosCombinados()) //Pasa al siguiente ciclo un subconjunto a la vez
			{
				System.out.println("PRIMER CICLO " + listacur);
				for (Curso cur: listacur) //Recorre los cursos del subconjunto pasado.
				{
				}
			}*/
			
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
        	
			
        	
						//Recomendacion r = new Recomendacion();
//			System.out.println("Recomendación 1: ");
//			Recomendacion r = CursoDAO.getInstancia().combinaciones(materiasAprobadas);
//			r.mostrarRecomendacion(r);
			/*r.getLunes()[3] = "Mate1";
			for (int i = 0; i < 4; i ++)
			{

				System.out.println(r.getLunes()[i]);
			}*/
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        if(true)
        	return;
        
        //ALGUNAS MATERIAS
        
		//CREO UN ALUMNO Y CARGO SUS MATERIAS APROBADAS
       // Alumno alu = new Alumno("Javi", aprobMaterias );
        
        //LISTA DE MATERIAS A DICTARSE
        ArrayList<Materia> mat = new ArrayList<Materia>();
        mat.add(pp1);
        mat.add(pp2);
        mat.add(calculo1);
        mat.add(algebraLineal);
        mat.add(ingles2);
        
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
