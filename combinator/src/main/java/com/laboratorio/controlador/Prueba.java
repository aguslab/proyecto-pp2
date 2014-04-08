package com.laboratorio.controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.laboratorio.modelo.Curso;
import com.laboratorio.modelo.Horario;
import com.laboratorio.modelo.Materia;

public class Prueba 
{

	static HashSet<List<Curso>> powerSet = new HashSet<List<Curso>>();
	private static void buildPowerSet(List<Curso> mainList, int count)
	{
	    powerSet.add(mainList);

	    for(int i=0; i<mainList.size(); i++)
	    {
	        List<Curso> temp = new ArrayList<Curso>(mainList);
	        temp.remove(i);
	        buildPowerSet(temp, temp.size());
	    }
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

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
        Curso cursoIP = new Curso(ip,horar7);
        Curso cursoIntroALaMatematica = new Curso(introALaMatematica,horar5);
        Curso cursoLecto = new Curso(lecto,horar6);
        Curso cursoPsec = new Curso(psec,horar2);
        Curso cursoUtil = new Curso(tallerUtilitarios,horar);

		Set<Curso> cursos = new HashSet<Curso>();
		cursos.add(cursoIngles1);
		cursos.add(cursoPP2);
		cursos.add(cursoIP);
		cursos.add(cursoIntroALaMatematica);
		cursos.add(cursoLecto);
		cursos.add(cursoPsec);
		cursos.add(cursoUtil);
		
		List<Curso> mainList = new ArrayList<Curso>(cursos);
		buildPowerSet(mainList,mainList.size());
		/*for (List<Curso> listacur : powerSet) //Pasa al siguiente ciclo un subconjunto a la vez
		{
			System.out.println("PRIMER CICLO" + listacur);
			for (Curso cur: listacur) //Recorre los cursos del subconjunto pasado.
			{
				System.out.println("SEGUNDO CICLO" + cur.getMateria().getNombre());
			}
		}	*/
		
		for (List<Curso> listacur : powerSet) //Pasa al siguiente ciclo un subconjunto a la vez
		{
			for (Curso cur: listacur) //Recorre los cursos del subconjunto pasado.
			{
				System.out.println("SEGUNDO CICLO" + cur.getMateria().getNombre());
			}
		}	
	}	
}
