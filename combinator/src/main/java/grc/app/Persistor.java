package grc.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.servicios.CriterioOrden;
import grc.servicios.CriterioOrdenPorMaterias;

public class Persistor
{
	static Logger logger = Logger.getLogger(Persistor.class);
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

	// //////////Horarios
	Horario lun18a22;
	Horario mar18a22;
	Horario jue18a20;
	Horario jue18a22;
	Horario vier18a22;
	Horario lun18a20;
	Horario mar18a20;
	Horario mier18a20;
	Horario mier20a22;
	Horario vier20a22;
	Horario sab08a12;
	Horario lun08a12;
	Horario mier08a12;
	Horario mar15a17;
	Horario lun15a17;
	Horario mier15a17;
	Horario jue15a17;
	Horario sab10a12;


	// ///////////CURSOS
	Curso curIngles1;
	Curso curIngles2;
	Curso curIngles2_c2;
	Curso curIngles3;
	Curso curProg1;
	Curso curProg2;
	Curso curProg3;
	Curso curTallerLecto;
	Curso curIntroALaMat;
	Curso curCalculo1;
	Curso curPsec;
	Curso curTallerUtilitarios;
	Curso curLogYTeoDeNum;
	Curso curOrga1;
	Curso curOrga1_c2;
	Curso curOrga2;
	Curso curAlgebraLineal;
	
	CriterioOrden criterioOrden;

	public PlanEstudio getPlanEstudios()
	{
		return planEstudio;
	}

	public void init()
	{
		// //////////Horarios
		lun18a22 = new Horario(Dia.LUNES, 18.0, 22.0);
		// lun18a22.setId(1);
		mar18a22 = new Horario(Dia.MARTES, 18., 22.);
		// mar18a22.setId(2);
		jue18a20 = new Horario(Dia.JUEVES, 18., 20.);
		jue18a22 = new Horario(Dia.JUEVES, 18., 22.);
		// jue18a20.setId(3);
		vier18a22 = new Horario(Dia.VIERNES, 18., 22.);
		// vier18a22.setId(4);
		lun18a20 = new Horario(Dia.LUNES, 18., 20.);
		// lun18a20.setId(5);
		mar18a20 = new Horario(Dia.MARTES, 18., 20.);
		// mar18a20.setId(6);
		mier18a20 = new Horario(Dia.MIERCOLES, 18., 20.);
		// mier18a20.setId(7);
		mier20a22 = new Horario(Dia.MIERCOLES, 20., 22.);
		// mier20a22.setId(8);
		vier20a22 = new Horario(Dia.VIERNES, 20., 22.);
		// vier20a22.setId(9);
		sab08a12 = new Horario(Dia.SABADO, 8.3, 11.3);
		// sab08a12.setId(10);
		lun08a12 = new Horario(Dia.LUNES, 8., 12.);
		mier08a12 = new Horario(Dia.MIERCOLES, 8., 12.);
		mar15a17 = new Horario(Dia.MARTES, 15., 17.);
		lun15a17 = new Horario(Dia.LUNES, 15., 17.);
		mier15a17 = new Horario(Dia.MIERCOLES, 15., 17.);
		jue15a17 = new Horario(Dia.JUEVES, 15., 17.);
		sab10a12 = new Horario(Dia.SABADO, 10., 12.);

		// /////////MATERIAS
		// CREO MATERIAS NUEVAS
		ip = new Materia("Introducción a la Programación", "Intro. Programación");
//		ip.setId(1);
		introALaMatematica = new Materia("Introducción a la Matemática", "Intro. Matemática");
//		introALaMatematica.setId(2);
		lecto = new Materia("Taller de Lectoescritura", "LECTO");
//		lecto.setId(3);
		prog1 = new Materia("Programación I", "P1");
//		prog1.setId(4);
		logica = new Materia("Lógica y teoría de números", "LTN");
//		logica.setId(5);
		orga1 = new Materia("Organización del computador I", "ORGA1");
//		orga1.setId(6);
		prog2 = new Materia("Programación II", "P2");
//		prog2.setId(7);
		algebraLineal = new Materia("Algebra Lineal", "Álgebra Lineal");
//		algebraLineal.setId(8);
		sisto1 = new Materia("Sistemas Operativos y Redes I", "SOR1");
//		sisto1.setId(9);
		prog3 = new Materia("Programación III", "P3");
//		prog3.setId(10);
		calculo1 = new Materia("Calculo I", "Cálculo I");
//		calculo1.setId(11);
		psec = new Materia("Problemas Socioeconómicos contemporáneos", "PSEC");
//		psec.setId(12);
		baseDatos1 = new Materia("Base de datos I", "BD1");
//		baseDatos1.setId(13);
		mateDiscreta = new Materia("Matemática Discreta", "Mate Discreta");
//		mateDiscreta.setId(14);
		especificacionSoft = new Materia("Especificaciones y verificaciones de Software", "ES");
//		especificacionSoft.setId(15);
		teoriaDeLaComputacion = new Materia("Teoría de la computación", "TC");
//		teoriaDeLaComputacion.setId(16);
		ingenieria1 = new Materia("Ingeniería de software I", "IS1");
//		ingenieria1.setId(17);
		probabilidadEstadistica = new Materia("Probabilidad y Estadística","Probabilidad" );
//		probabilidadEstadistica.setId(18);
		pp1 = new Materia("Proyecto Profesional I", "PP1");
//		pp1.setId(19);
		ingenieria2 = new Materia("Ingeniería de software II", "IS2");
//		ingenieria2.setId(20);
		orga2 = new Materia("Organización del computador II", "ORGA2");
//		orga2.setId(21);
		pp2 = new Materia("Proyecto Profesional II", "PP2");
//		pp2.setId(22);
		baseDatos2 = new Materia("Base de datos II", "BD2");
//		baseDatos2.setId(23);
		sisto2 = new Materia("Sistemas Operativos y Redes II", "SOR2");
//		sisto2.setId(24);
		practicaProfSup1 = new Materia("Práctica Profesional Supervisada I", "PPS1");
//		practicaProfSup1.setId(25);
		modeladoYOptimizacion = new Materia("Modelado y Optimización", "Modelado");
//		modeladoYOptimizacion.setId(26);
		informaticaYSociedad = new Materia("Informática y Sociedad", "Info y Soc.");
//		informaticaYSociedad.setId(27);
		practicaProfSup2 = new Materia("Práctica Profesional Supervisada II", "PPS2");
//		practicaProfSup2.setId(28);
		gestionProyectos = new Materia("Gestión de Proyectos", "Gestión");
//		gestionProyectos.setId(29);
		laboratorioInterdisciplinario = new Materia("Laboratorio interdisciplinario","Laboratorio");
//		laboratorioInterdisciplinario.setId(30);
		tallerUtilitarios = new Materia("Taller de Utilitarios","Utilitarios");
//		tallerUtilitarios.setId(31);
		ingles1 = new Materia("Ingles Lectocomprension I", "Inglés 1");
//		ingles1.setId(32);
		ingles2 = new Materia("Ingles Lectocomprension II", "Inglés 2");
//		ingles2.setId(33);
		ingles3 = new Materia("Ingles Lectocomprension III", "Inglés 3");
//		ingles3.setId(34);

		// /////////CARRERA
		licenSistemas = new Carrera("Licenciatura en Sistemas");

		// ///////////CURSOS
		List<Horario> listHor = new ArrayList<Horario>();
		listHor.add(lun18a22);
		listHor.add(mar18a22);
		curIngles1 = new Curso(licenSistemas, ingles1, listHor, "01");
		curIngles3 = new Curso(licenSistemas, ingles3, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(sab08a12);
		curIngles2 = new Curso(licenSistemas, ingles2, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(sab08a12);
		curIngles2_c2 = new Curso(licenSistemas, ingles2, listHor, "02");
		listHor = new ArrayList<Horario>();
		listHor.add(lun18a20);
		listHor.add(mar18a20);
		listHor.add(mier18a20);
		curProg1 = new Curso(licenSistemas, prog1, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(mar18a22);
		listHor.add(vier18a22);
		curProg2 = new Curso(licenSistemas, prog2, listHor, "01");
		curProg3 = new Curso(licenSistemas, prog3, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(mier18a20);
		curTallerLecto = new Curso(licenSistemas, lecto, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(mier18a20);
		listHor.add(vier18a22);
		curIntroALaMat = new Curso(licenSistemas, introALaMatematica, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(mier20a22);
		listHor.add(vier20a22);
		curCalculo1 = new Curso(licenSistemas, calculo1, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(lun08a12);
		listHor.add(mier08a12);
		curPsec = new Curso(licenSistemas, psec, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(mar15a17);
		curTallerUtilitarios= new Curso(licenSistemas, tallerUtilitarios, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(lun15a17);
		listHor.add(mier15a17);
		curLogYTeoDeNum= new Curso(licenSistemas, logica, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(jue15a17);
		listHor.add(sab10a12);
		curOrga1= new Curso(licenSistemas, orga1, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(lun18a20);
		listHor.add(jue18a22);
		curOrga1_c2= new Curso(licenSistemas, orga1, listHor, "02");
		listHor = new ArrayList<Horario>();
		listHor.add(jue18a20);
		listHor.add(vier18a22);
		curOrga2 = new Curso(licenSistemas, orga2, listHor, "01");
		listHor = new ArrayList<Horario>();
		listHor.add(jue18a20);
		listHor.add(lun18a20);
		curAlgebraLineal = new Curso(licenSistemas, algebraLineal, listHor, "01");
		
		
		
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

		criterioOrden = new CriterioOrdenPorMaterias(true);
	}
}
