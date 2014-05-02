package grc.app;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grc.dao.CursoDAO;
import grc.dao.HorarioDAO;
import grc.dao.MateriaAprobadaDAO;
import grc.dao.MateriaDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.MateriaAprobada;
import grc.dominio.PlanEstudio;

public class Alta_mat_cur_matApr
{

	private PlanEstudio planEstudio;
	private Carrera licenSistemas;
	// /////////MATERIAS
	// CREO MATERIAS NUEVAS
	Materia ip;
	Materia introALaMatematica;
	Materia lecto;
	Materia prog1;
	Materia logica;
	Materia orga1;
	Materia prog2;
	Materia algebraLineal;
	Materia sisto1;
	Materia prog3;
	Materia calculo1;
	Materia psec;
	Materia baseDatos1;
	Materia mateDiscreta;
	Materia especificacionSoft;
	Materia teoriaDeLaComputacion;
	Materia ingenieria1;
	Materia probabilidadEstadistica;
	Materia pp1;
	Materia ingenieria2;
	Materia orga2;
	Materia pp2;
	Materia baseDatos2;
	Materia sisto2;
	Materia practicaProfSup1;
	Materia modeladoYOptimizacion;
	Materia informaticaYSociedad;
	Materia practicaProfSup2;
	Materia gestionProyectos;
	Materia laboratorioInterdisciplinario;
	Materia tallerUtilitarios;
	Materia ingles1;
	Materia ingles2;
	Materia ingles3;

	// MATERIAS APROBADAS
	MateriaAprobada maIngles1;
	MateriaAprobada maIP;
	MateriaAprobada maProg1;

	// //////////Horarios
	Horario lun18a22;
	Horario mar18a22;
	Horario jue18a20;
	Horario vier18a22;
	Horario lun18a20;
	Horario mar18a20;
	Horario mier18a20;
	Horario mier20a22;
	Horario vier20a22;
	Horario sab08a12;

	// ///////////CURSOS
	Curso curIngles1;
	Curso curIngles2;
	Curso curIngles3;
	Curso curProg1;
	Curso curProg2;
	Curso curProg3;
	Curso curTallerLecto;
	Curso curIntroALaMat;
	Curso curCalculo1;

	public PlanEstudio getPlanEstudios()
	{
		return planEstudio;
	}

	public void init()
	{
		// //////////Horarios
		lun18a22 = new Horario(Dia.LUNES.name(), 18, 22);
//		 lun18a22.setId(1);
		mar18a22 = new Horario(Dia.MARTES.name(), 18, 22);
//		 mar18a22.setId(2);
		jue18a20 = new Horario(Dia.JUEVES.name(), 18, 20);
//		 jue18a20.setId(3);
		vier18a22 = new Horario(Dia.VIERNES.name(), 18, 22);
//		 vier18a22.setId(4);
		lun18a20 = new Horario(Dia.LUNES.name(), 18, 20);
//		 lun18a20.setId(5);
		mar18a20 = new Horario(Dia.MARTES.name(), 18, 20);
//		 mar18a20.setId(6);
		mier18a20 = new Horario(Dia.MIERCOLES.name(), 18, 20);
//		 mier18a20.setId(7);
		mier20a22 = new Horario(Dia.MIERCOLES.name(), 20, 22);
//		 mier20a22.setId(8);
		vier20a22 = new Horario(Dia.VIERNES.name(), 20, 22);
//		 vier20a22.setId(9);
		sab08a12 = new Horario(Dia.SABADO.name(), 8, 12);
//		 sab08a12.setId(10);

		// /////////MATERIAS
		// CREO MATERIAS NUEVAS
		ip = new Materia("Introducción a la Programación");
		ip.setId(1);
		introALaMatematica = new Materia("Introducción a la Matemática");
		introALaMatematica.setId(2);
		lecto = new Materia("Taller de Lectoescritura");
		lecto.setId(3);
		prog1 = new Materia("Programación I");
		prog1.setId(4);
		logica = new Materia("Lógica y teoría de números");
		logica.setId(5);
		orga1 = new Materia("Organización del computador I");
		orga1.setId(6);
		prog2 = new Materia("Programación II");
		prog2.setId(7);
		algebraLineal = new Materia("Algebra Lineal");
		algebraLineal.setId(8);
		sisto1 = new Materia("Sistemas Operativos y Redes I");
		sisto1.setId(9);
		prog3 = new Materia("Programación III");
		prog3.setId(10);
		calculo1 = new Materia("Calculo I");
		calculo1.setId(11);
		psec = new Materia("Problemas Socioeconómicos contemporáneos");
		psec.setId(12);
		baseDatos1 = new Materia("Base de datos I");
		baseDatos1.setId(13);
		mateDiscreta = new Materia("Matemática Discreta");
		mateDiscreta.setId(14);
		especificacionSoft = new Materia("Especificaciones y verificaciones de Software");
		especificacionSoft.setId(15);
		teoriaDeLaComputacion = new Materia("Teoría de la computación");
		teoriaDeLaComputacion.setId(16);
		ingenieria1 = new Materia("Ingeniería de software I");
		ingenieria1.setId(17);
		probabilidadEstadistica = new Materia("Probabilidad y Estadística");
		probabilidadEstadistica.setId(18);
		pp1 = new Materia("Proyecto Profesional I");
		pp1.setId(19);
		ingenieria2 = new Materia("Ingeniería de software II");
		ingenieria2.setId(20);
		orga2 = new Materia("Organización del computador II");
		orga2.setId(21);
		pp2 = new Materia("Proyecto Profesional II");
		pp2.setId(22);
		baseDatos2 = new Materia("Base de datos II");
		baseDatos2.setId(23);
		sisto2 = new Materia("Sistemas Operativos y Redes II");
		sisto2.setId(24);
		practicaProfSup1 = new Materia("Práctica Profesional Supervisada I");
		practicaProfSup1.setId(25);
		modeladoYOptimizacion = new Materia("Modelado y Optimización");
		modeladoYOptimizacion.setId(26);
		informaticaYSociedad = new Materia("Informática y Sociedad");
		informaticaYSociedad.setId(27);
		practicaProfSup2 = new Materia("Práctica Profesional Supervisada II");
		practicaProfSup2.setId(28);
		gestionProyectos = new Materia("Gestión de Proyectos");
		gestionProyectos.setId(29);
		laboratorioInterdisciplinario = new Materia("Laboratorio interdisciplinario");
		laboratorioInterdisciplinario.setId(30);
		tallerUtilitarios = new Materia("Taller de Utilitarios");
		tallerUtilitarios.setId(31);
		ingles1 = new Materia("Ingles Lectocomprension I");
		ingles1.setId(32);
		ingles2 = new Materia("Ingles Lectocomprension II");
		ingles2.setId(33);
		ingles3 = new Materia("Ingles Lectocomprension III");
		ingles3.setId(34);

		// /////////CARRERA
		licenSistemas = new Carrera("Licenciatura en Sistemas");
		List<Carrera> carreras = new ArrayList<Carrera>();
		carreras.add(licenSistemas);

		// ///////////CURSOS
		List<Horario> listHor = new ArrayList<Horario>();
		listHor.add(lun18a22);
		listHor.add(mar18a22);
		curIngles1 = new Curso(carreras, ingles1, listHor);
		// curIngles1.setId(1);
		curIngles3 = new Curso(carreras, ingles3, listHor);
		// curIngles3.setId(2);
		listHor = new ArrayList<Horario>();
		listHor.add(sab08a12);
		curIngles2 = new Curso(carreras, ingles2, listHor);
		// curIngles2.setId(3);
		listHor = new ArrayList<Horario>();
		listHor.add(lun18a20);
		listHor.add(mar18a20);
		listHor.add(mier18a20);
		curProg1 = new Curso(carreras, prog1, listHor);
		// curProg1.setId(4);
		listHor = new ArrayList<Horario>();
		listHor.add(mar18a22);
		listHor.add(vier18a22);
		curProg2 = new Curso(carreras, prog2, listHor);
		// curProg2.setId(5);
		curProg3 = new Curso(carreras, prog3, listHor);
		// curProg3.setId(6);
		listHor = new ArrayList<Horario>();
		listHor.add(mier18a20);
		curTallerLecto = new Curso(carreras, lecto, listHor);
		// curTallerLecto.setId(7);
		listHor = new ArrayList<Horario>();
		listHor.add(mier18a20);
		listHor.add(vier18a22);
		curIntroALaMat = new Curso(carreras, introALaMatematica, listHor);
		// curIntroALaMat.setId(8);
		listHor = new ArrayList<Horario>();
		listHor.add(mier20a22);
		listHor.add(vier20a22);
		curCalculo1 = new Curso(carreras, calculo1, listHor);
		// curCalculo1.setId(9);

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
		correlativasIngles3.add(ingles2);

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
		// TODO CASO ESPECIAL!!!
		correlativas.put(laboratorioInterdisciplinario, sinCorrelativas);
		correlativas.put(tallerUtilitarios, sinCorrelativas);
		correlativas.put(ingles1, sinCorrelativas);
		correlativas.put(ingles2, correlativasIngles2);
		correlativas.put(ingles3, correlativasIngles3);

		planEstudio = new PlanEstudio(licenSistemas, correlativas);

		// MATERIAS APROBADAS
		Timestamp fecha = new Timestamp(new Date().getTime());
		maIngles1 = new MateriaAprobada(ingles1, 7, fecha);
		maIP = new MateriaAprobada(ip, 10, fecha);
		maProg1 = new MateriaAprobada(prog1, 9, fecha);
	}

	public void altaMaterias() throws Exception
	{
		// MATERIAS
		MateriaDAO.getInstancia().alta(prog1);
		MateriaDAO.getInstancia().alta(prog2);
		MateriaDAO.getInstancia().alta(prog3);
		MateriaDAO.getInstancia().alta(ingles1);
		MateriaDAO.getInstancia().alta(ingles2);
		MateriaDAO.getInstancia().alta(ingles3);
		MateriaDAO.getInstancia().alta(ip);
		MateriaDAO.getInstancia().alta(introALaMatematica);
		MateriaDAO.getInstancia().alta(lecto);
		MateriaDAO.getInstancia().alta(calculo1);
	}

	public void altaHorarios() throws Exception
	{
		HorarioDAO.getInstancia().alta(lun18a22);
		HorarioDAO.getInstancia().alta(mar18a22);
		HorarioDAO.getInstancia().alta(jue18a20);
		HorarioDAO.getInstancia().alta(vier18a22);
		HorarioDAO.getInstancia().alta(lun18a20);
		HorarioDAO.getInstancia().alta(mar18a20);
		HorarioDAO.getInstancia().alta(mier18a20);
		HorarioDAO.getInstancia().alta(mier20a22);
		HorarioDAO.getInstancia().alta(vier20a22);
		HorarioDAO.getInstancia().alta(sab08a12);
	}

	public void altaCursos() throws Exception
	{
		// CURSOS
		CursoDAO.getInstancia().alta(curIngles1);
		CursoDAO.getInstancia().alta(curIngles2);
		CursoDAO.getInstancia().alta(curIngles3);
		CursoDAO.getInstancia().alta(curProg1);
		CursoDAO.getInstancia().alta(curProg2);
		CursoDAO.getInstancia().alta(curProg3);
		CursoDAO.getInstancia().alta(curTallerLecto);
		CursoDAO.getInstancia().alta(curIntroALaMat);
		CursoDAO.getInstancia().alta(curCalculo1);

	}

	public void altaMateriasAprobadas() throws Exception
	{
		// MATERIAS APROBADAS
		MateriaAprobadaDAO.getInstancia().alta(maIngles1);
		MateriaAprobadaDAO.getInstancia().alta(maIP);
		MateriaAprobadaDAO.getInstancia().alta(maProg1);
	}

	public void altaPlanEstudio() throws Exception
	{
		// PLAN ESTUDIOS
		PlanEstudioDAO.getInstancia().alta(planEstudio);
	}

}
