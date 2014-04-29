package grc.tmp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grc.dao.CursoDAO;
import grc.dao.MateriaAprobadaDAO;
import grc.dao.MateriaDAO;
import grc.dao.PlanEstudioDAO;
import grc.modelo.Curso;
import grc.modelo.Dia;
import grc.modelo.Horario;
import grc.modelo.Materia;
import grc.modelo.MateriaAprobada;
import grc.modelo.PlanEstudio;

public class Alta_mat_cur_matApr {

	public static void main(String[] args) throws Exception {
		// //////////Horarios
		Horario lun18a22 = new Horario(Dia.LUNES.name(), 18, 22);
		Horario mar18a22 = new Horario(Dia.MARTES.name(), 18, 22);
		Horario jue18a20 = new Horario(Dia.JUEVES.name(), 18, 20);
		Horario vier18a22 = new Horario(Dia.VIERNES.name(), 18, 22);
		Horario lun18a20 = new Horario(Dia.LUNES.name(), 18, 20);
		Horario mar18a20 = new Horario(Dia.MARTES.name(), 18, 20);
		Horario mier18a20 = new Horario(Dia.MIERCOLES.name(), 18, 20);
		Horario mier20a22 = new Horario(Dia.MIERCOLES.name(), 20, 22);
		Horario vier20a22 = new Horario(Dia.VIERNES.name(), 20, 22);

		// /////////MATERIAS
		// CREO MATERIAS NUEVAS
		Materia ip = new Materia("Introducción a la Programación");
		ip.setId(1);
		Materia introALaMatematica = new Materia(
				"Introducción a la Matemática");
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
		Materia especificacionSoft = new Materia(
				"Especificaciones y verificaciones de Software");
		especificacionSoft.setId(15);
		Materia teoriaDeLaComputacion = new Materia(
				"Teoría de la computación");
		teoriaDeLaComputacion.setId(16);
		Materia ingenieria1 = new Materia("Ingeniería de software I");
		ingenieria1.setId(17);
		Materia probabilidadEstadistica = new Materia(
				"Probabilidad y Estadística");
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
		Materia practicaProfSup1 = new Materia(
				"Práctica Profesional Supervisada I");
		practicaProfSup1.setId(25);
		Materia modeladoYOptimizacion = new Materia("Modelado y Optimización");
		modeladoYOptimizacion.setId(26);
		Materia informaticaYSociedad = new Materia("Informática y Sociedad");
		informaticaYSociedad.setId(27);
		Materia practicaProfSup2 = new Materia(
				"Práctica Profesional Supervisada II");
		practicaProfSup2.setId(28);
		Materia gestionProyectos = new Materia("Gestión de Proyectos");
		gestionProyectos.setId(29);
		Materia laboratorioInterdisciplinario = new Materia(
				"Laboratorio interdisciplinario");
		laboratorioInterdisciplinario.setId(30);
		Materia tallerUtilitarios = new Materia("Taller de Utilitarios");
		tallerUtilitarios.setId(31);
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		ingles1.setId(32);
		Materia ingles2 = new Materia("Ingles Lectocomprension II");
		ingles2.setId(33);
		Materia ingles3 = new Materia("Ingles Lectocomprension III");
		ingles3.setId(34);

		// ///////////CURSOS
		List<Horario> listHor = new ArrayList<Horario>();
		listHor.add(lun18a22);
		listHor.add(mar18a22);
		Curso curIngles1 = new Curso(ingles1, listHor);
		Curso curIngles2 = new Curso(ingles2, listHor);
		listHor = new ArrayList<Horario>();
		listHor.add(lun18a20);
		listHor.add(mar18a20);
		listHor.add(mier18a20);
		Curso curProg1 = new Curso(prog1, listHor);
		listHor = new ArrayList<Horario>();
		listHor.add(mar18a22);
		listHor.add(vier18a22);
		Curso curProg2 = new Curso(prog2, listHor);
		Curso curProg3 = new Curso(prog3, listHor);
		listHor = new ArrayList<Horario>();
		listHor.add(mier18a20);
		Curso curTallerLecto = new Curso(lecto, listHor);
		listHor = new ArrayList<Horario>();
		listHor.add(jue18a20);
		Curso curTallerLecto_ = new Curso(lecto, listHor);
		listHor = new ArrayList<Horario>();
		listHor.add(mier18a20);
		listHor.add(vier18a22);
		Curso curIntroALaMat = new Curso(introALaMatematica, listHor);
		listHor = new ArrayList<Horario>();
		listHor.add(mier20a22);
		listHor.add(vier20a22);
		Curso curCalculo1 = new Curso(calculo1, listHor);

		// PLAN ESTUDIOS
		// CREO PLAN DE ESTUDIOS
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

		// TODO CASO ESPECIAL!! necesita 11 materias cualquiera!!
		// Set<Materia> correlativasLaboratorioInterdisciplinario = new
		// HashSet<Materia>();

		Set<Materia> correlativasIngles2 = new HashSet<Materia>();
		correlativasIngles2.add(ingles1);

		Set<Materia> correlativasIngles3 = new HashSet<Materia>();
		correlativasIngles2.add(ingles2);

		HashMap<Materia, Set<Materia>> correlativas = new HashMap<Materia, Set<Materia>>();
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
		correlativas.put(probabilidadEstadistica,
				correlativasProbabilidadEstadistica);
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
		// TODO CASO ESPECIAL!!!
		// correlativas.put(laboratorioInterdisciplinario, );
		correlativas.put(tallerUtilitarios, sinCorrelativas);
		correlativas.put(ingles1, sinCorrelativas);
		correlativas.put(ingles2, correlativasIngles2);
		correlativas.put(ingles3, correlativasIngles3);

		PlanEstudio planEstudio = new PlanEstudio(correlativas);


		// MATERIAS APROBADAS
		MateriaAprobada maIngles1 = new MateriaAprobada(ingles1, 7);
		MateriaAprobada maIP= new MateriaAprobada(ip, 10);
		MateriaAprobada maProg1= new MateriaAprobada(prog1, 9);
		
		/*
		 * ALTAAAAAAAAAAAAAA
		 */

		// MATERIAS
		MateriaDAO.getInstancia().alta(prog1);
		MateriaDAO.getInstancia().alta(prog2);
		MateriaDAO.getInstancia().alta(prog3);
		MateriaDAO.getInstancia().alta(ingles1);
		MateriaDAO.getInstancia().alta(ingles2);
		MateriaDAO.getInstancia().alta(ip);
		MateriaDAO.getInstancia().alta(introALaMatematica);
		MateriaDAO.getInstancia().alta(lecto);
		MateriaDAO.getInstancia().alta(calculo1);

		// CURSOS
		CursoDAO.getInstancia().alta(curIngles1);
		CursoDAO.getInstancia().alta(curIngles2);
		CursoDAO.getInstancia().alta(curProg1);
		CursoDAO.getInstancia().alta(curProg2);
		CursoDAO.getInstancia().alta(curProg3);
		CursoDAO.getInstancia().alta(curTallerLecto);
		CursoDAO.getInstancia().alta(curTallerLecto_);
		CursoDAO.getInstancia().alta(curIntroALaMat);
		CursoDAO.getInstancia().alta(curCalculo1);

		// MATERIAS APROBADAS
		MateriaAprobadaDAO.getInstancia().alta(maIngles1);
		MateriaAprobadaDAO.getInstancia().alta(maIP);
		MateriaAprobadaDAO.getInstancia().alta(maProg1);
		
		
		//PLAN ESTUDIOS
		PlanEstudioDAO.getInstancia().alta(planEstudio);
		
	}

}
