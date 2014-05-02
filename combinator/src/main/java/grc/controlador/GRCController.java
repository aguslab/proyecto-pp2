package grc.controlador;

import grc.dao.MateriaAprobadaDAO;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.MateriaAprobada;
import grc.servicios.Filtrador;
import grc.servicios.Recomendacion;
import grc.vista.GRCView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

public class GRCController implements ActionListener
{
	private GRCView vista;
	private boolean filtroManiana;
	private boolean filtroTarde;
	private boolean filtroNoche;

	public GRCController()
	{
		filtroManiana = true;
		filtroTarde = true;
		filtroNoche = true;
	}

	public DefaultTableModel cambiarTablaDias(DefaultTableModel tablaDias, int posItemLista)
			throws Exception
	{
		String nombreMateria = "";
		List<Recomendacion> recomendaciones = this.vista.getModelo().getRecomendaciones();
		if (recomendaciones.isEmpty())
			return tablaDias;
		Recomendacion r = recomendaciones.get(posItemLista);
		for (Curso c : r.getRecomendacion())
		{
			nombreMateria = c.getMateria().getNombre();
			for (Horario horario : c.getHorario()) 
			{
				String dia = horario.getDia();
				int horaInicio = horario.getHoraInicio();
				int horaFin = horario.getHoraFin();
				if (dia.equalsIgnoreCase("Lunes")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8,1);
					}
				} else if (dia.equalsIgnoreCase("Martes")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 2);
					}
				} else if (dia.equalsIgnoreCase("Miercoles")) {
					System.out.println("HORAi" + horaInicio);
					System.out.println("HORA F" + horaFin);
					for (int i = horaInicio; i < horaFin; i++) {
						System.out.println(i);
						tablaDias.setValueAt(nombreMateria,  i-8, 3);
					}
				} else if (dia.equalsIgnoreCase("Jueves")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 4);
					}
				} else if (dia.equalsIgnoreCase("Viernes")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 5);
					}
				} else if (dia.equalsIgnoreCase("Sabado")) {
					for (int i = horaInicio; i < horaFin; i++) {
						tablaDias.setValueAt(nombreMateria,  i-8, 6);
					}
				}
			}
		}
		return tablaDias;
	}

	public ArrayList<String> getRecomendaciones() throws Exception
	{
		return armarRecomendacion(this.vista.getModelo().getRecomendaciones());
	}

	public DefaultTableModel getMateriasAprobadas(DefaultTableModel tablaDias) throws Exception
	{
		List<MateriaAprobada> matAprobadas = MateriaAprobadaDAO.getInstancia().obtenerTodo();
		String nombreMateria;
		double nota;
		for (int i = 0; i < matAprobadas.size(); i++)
		{
			nombreMateria = matAprobadas.get(i).getMateriaAprobada().getNombre();
			nota = matAprobadas.get(i).getNota();

			Object nuevaFilaDatos[] = {nombreMateria, nota};
			tablaDias.addRow(nuevaFilaDatos);
		}
		return tablaDias;
	}

	public DefaultTableModel borrarValores(DefaultTableModel tablaDias)
	{
		tablaDias.setRowCount(14);
		tablaDias.setValueAt("8 a 9", 0, 0);
		tablaDias.setValueAt("9 a 10", 1, 0);
		tablaDias.setValueAt("10 a 11", 2, 0);
		tablaDias.setValueAt("11 a 12", 3, 0);
		tablaDias.setValueAt("12 a 13", 4, 0);
		tablaDias.setValueAt("13 a 14", 5, 0);
		tablaDias.setValueAt("14 a 15", 6, 0);
		tablaDias.setValueAt("15 a 16", 7, 0);
		tablaDias.setValueAt("16 a 17", 8, 0);
		tablaDias.setValueAt("17 a 18", 9, 0);
		tablaDias.setValueAt("18 a 19", 10, 0);
		tablaDias.setValueAt("19 a 20", 11, 0);
		tablaDias.setValueAt("20 a 21", 12, 0);
		tablaDias.setValueAt("21 a 22", 13, 0);
		
		return tablaDias;
	}
	
	public ArrayList<String> armarRecomendacion(List<Recomendacion> recomendaciones)
	{
		ArrayList<String> recomendacionesParaLista = new ArrayList<String>();
		for (Recomendacion r : recomendaciones)
		{
			String recoParaLista = "";
			for (Curso c : r.getRecomendacion())
			{
				recoParaLista += " " + c.getMateria().getNombre();
				for (int j = 0; j < c.getHorario().size(); j++)
				{
					recoParaLista += " Dia: " + c.getHorario().get(j).getDia();
					recoParaLista += " De: " + c.getHorario().get(j).getHoraInicio();
					recoParaLista += "hs a " + c.getHorario().get(j).getHoraFin() + " hs";
				}
				recoParaLista += "; ";
			}
			recomendacionesParaLista.add(recoParaLista);
		}
		if (recomendaciones.isEmpty())
		{
			recomendacionesParaLista
					.add("NO HAY CURSOS DISPONIBLES PARA CURSAR CON ESTOS CRITERIOS");
		}
		return recomendacionesParaLista;
	}

	// public static void main(String args[]) throws Exception
	// {
	// /*
	// * Alta_mat_cur_matApr a = new Alta_mat_cur_matApr(); a.init();
	// *
	// * // ALTAAAAAAAAAAAAAA
	// *
	// * a.altaMaterias();
	// *
	// * // a.altaHorarios(); NO alta!!!
	// *
	// * a.altaCursos();
	// *
	// * a.altaMateriasAprobadas();
	// *
	// * a.altaPlanEstudio();
	// */
	//
	// /*
	// *
	// * //filtra por turno, materias aprobadas, correlatividades //Despues
	// * con todo eso hace las combinaciones
	// *
	// * //CREO MATERIAS NUEVAS Materia ip = new
	// * Materia("Introducción a la Programación"); ip.setId(1); Materia
	// * introALaMatematica = new Materia("Introducción a la Matemática");
	// * introALaMatematica.setId(2); Materia lecto = new
	// * Materia("Taller de Lectoescritura"); lecto.setId(3); Materia prog1 =
	// * new Materia("Programación I"); prog1.setId(4); Materia logica = new
	// * Materia("Lógica y teoría de números"); logica.setId(5); Materia orga1
	// * = new Materia("Organización del computador I"); orga1.setId(6);
	// * Materia prog2 = new Materia("Programación II"); prog2.setId(7);
	// * Materia algebraLineal = new Materia("Algebra Lineal");
	// * algebraLineal.setId(8); Materia sisto1 = new
	// * Materia("Sistemas Operativos y Redes I"); sisto1.setId(9); Materia
	// * prog3 = new Materia("Programación III"); prog3.setId(10); Materia
	// * calculo1 = new Materia("Calculo I"); calculo1.setId(11); Materia psec
	// * = new Materia("Problemas Socioeconómicos contemporáneos");
	// * psec.setId(12); Materia baseDatos1 = new Materia("Base de datos I");
	// * baseDatos1.setId(13); Materia mateDiscreta = new
	// * Materia("Matemática Discreta"); mateDiscreta.setId(14); Materia
	// * especificacionSoft = new
	// * Materia("Especificaciones y verificaciones de Software");
	// * especificacionSoft.setId(15); Materia teoriaDeLaComputacion = new
	// * Materia("Teoría de la computación"); teoriaDeLaComputacion.setId(16);
	// * Materia ingenieria1 = new Materia("Ingeniería de software I");
	// * ingenieria1.setId(17); Materia probabilidadEstadistica = new
	// * Materia("Probabilidad y Estadística");
	// * probabilidadEstadistica.setId(18); Materia pp1 = new
	// * Materia("Proyecto Profesional I"); pp1.setId(19); Materia ingenieria2
	// * = new Materia("Ingeniería de software II"); ingenieria2.setId(20);
	// * Materia orga2 = new Materia("Organización del computador II");
	// * orga2.setId(21); Materia pp2 = new
	// * Materia("Proyecto Profesional II"); pp2.setId(22); Materia baseDatos2
	// * = new Materia("Base de datos II"); baseDatos2.setId(23); Materia
	// * sisto2 = new Materia("Sistemas Operativos y Redes II");
	// * sisto2.setId(24); Materia practicaProfSup1 = new
	// * Materia("Práctica Profesional Supervisada I");
	// * practicaProfSup1.setId(25); Materia modeladoYOptimizacion = new
	// * Materia("Modelado y Optimización"); modeladoYOptimizacion.setId(26);
	// * Materia informaticaYSociedad= new Materia("Informática y Sociedad");
	// * informaticaYSociedad.setId(27); Materia practicaProfSup2 = new
	// * Materia("Práctica Profesional Supervisada II");
	// * practicaProfSup2.setId(28); Materia gestionProyectos = new
	// * Materia("Gestión de Proyectos"); gestionProyectos.setId(29); Materia
	// * laboratorioInterdisciplinario = new
	// * Materia("Laboratorio interdisciplinario");
	// * laboratorioInterdisciplinario.setId(30); Materia tallerUtilitarios =
	// * new Materia("Taller de Utilitarios"); tallerUtilitarios.setId(31);
	// * Materia ingles1 = new Materia("Ingles Lectocomprension I");
	// * ingles1.setId(32); Materia ingles2 = new
	// * Materia("Ingles Lectocomprension II"); ingles2.setId(33); Materia
	// * ingles3 = new Materia("Ingles Lectocomprension III");
	// * ingles3.setId(34);
	// *
	// * //CREO HORARIOS DISPONIBLES Horario n1 = new Horario("Lunes", 18,
	// * 22); Horario n2 = new Horario("Martes", 18, 22); Horario n3 = new
	// * Horario("Miercoles", 18, 20); Horario n4 = new Horario("Jueves", 18,
	// * 22); Horario n5 = new Horario("Miercoles", 20, 22); Horario n6 = new
	// * Horario("Viernes", 18, 22);
	// *
	// * ArrayList<Horario> horarLunMierc = new ArrayList<Horario>();
	// * horarLunMierc.add(n1); horarLunMierc.add(n3); ArrayList<Horario>
	// * horarMartJuev = new ArrayList<Horario>(); horarMartJuev.add(n2);
	// * horarMartJuev.add(n4); ArrayList<Horario> horar3 = new
	// * ArrayList<Horario>(); horar3.add(n5); horar3.add(n6);
	// *
	// * //CREO CURSOS (materia q se dicta y en que turno) //Curso
	// * cursoCalculo1 = new Curso(calculo1, horar); //Curso cursoPP1 = new
	// * Curso(pp1, horar2); // Curso cursoIngles1 = new Curso(ingles1,
	// * horar3); // Curso cursoPP2 = new Curso(pp2,horarLunMierc); // Curso
	// * cursoIP = new Curso(ip,horarLunMierc); Curso cursoIntroALaMatematica
	// * = new Curso(introALaMatematica,horar3); // Curso cursoPsec = new
	// * Curso(psec,horarMartJuev); Curso cursoUtil = new
	// * Curso(tallerUtilitarios,horarMartJuev); Curso cursoProg1 = new
	// * Curso(prog1,horarLunMierc); Curso cursoProg2 = new
	// * Curso(prog2,horarLunMierc); Curso cursoProg3 = new
	// * Curso(prog3,horarMartJuev);
	// *
	// *
	// *
	// *
	// * //CREO PLAN DE ESTUDIOS Set<Materia> sinCorrelativas = new
	// * HashSet<Materia>();
	// *
	// * Set<Materia> correlativasProg1 = new HashSet<Materia>();
	// * correlativasProg1.add(ip);
	// *
	// * Set<Materia> correlativasLogica = new HashSet<Materia>();
	// * correlativasLogica.add(introALaMatematica);
	// *
	// * Set<Materia> correlativasProg2 = new HashSet<Materia>();
	// * correlativasProg2.add(prog1);
	// *
	// * Set<Materia> correlativasAlgebraLineal = new HashSet<Materia>();
	// * correlativasAlgebraLineal.add(introALaMatematica);
	// *
	// * Set<Materia> correlativasSisto1 = new HashSet<Materia>();
	// * correlativasSisto1.add(orga1);
	// *
	// * Set<Materia> correlativasProg3 = new HashSet<Materia>();
	// * correlativasProg3.add(prog2);
	// *
	// * Set<Materia> correlativasCalculo1 = new HashSet<Materia>();
	// * correlativasCalculo1.add(introALaMatematica);
	// *
	// * Set<Materia> correlativasBaseDatos1 = new HashSet<Materia>();
	// * correlativasBaseDatos1.add(logica);
	// * correlativasBaseDatos1.add(prog2);
	// *
	// * Set<Materia> correlativasMateDiscreta = new HashSet<Materia>();
	// * correlativasMateDiscreta.add(logica);
	// * correlativasMateDiscreta.add(calculo1);
	// * correlativasMateDiscreta.add(algebraLineal);
	// *
	// * Set<Materia> correlativasEspecificacion = new HashSet<Materia>();
	// * correlativasEspecificacion.add(logica);
	// *
	// * Set<Materia> correlativasTeoriaComputacion = new HashSet<Materia>();
	// * correlativasTeoriaComputacion.add(prog3);
	// * correlativasTeoriaComputacion.add(mateDiscreta);
	// * correlativasTeoriaComputacion.add(orga1);
	// *
	// * Set<Materia> correlativasIngeieria1 = new HashSet<Materia>();
	// * correlativasIngeieria1.add(prog3);
	// *
	// * Set<Materia> correlativasProbabilidadEstadistica = new
	// * HashSet<Materia>();
	// * correlativasProbabilidadEstadistica.add(calculo1);
	// * correlativasProbabilidadEstadistica.add(mateDiscreta);
	// *
	// * Set<Materia> correlativasPP1 = new HashSet<Materia>();
	// * correlativasPP1.add(prog3); correlativasPP1.add(baseDatos1);
	// * correlativasPP1.add(ingenieria1);
	// * correlativasPP1.add(especificacionSoft);
	// *
	// * Set<Materia> correlativasIngenieria2 = new HashSet<Materia>();
	// * correlativasIngenieria2.add(ingenieria1);
	// *
	// * Set<Materia> correlativasOrga2 = new HashSet<Materia>();
	// * correlativasOrga2.add(orga1);
	// *
	// * Set<Materia> correlativasPP2 = new HashSet<Materia>();
	// * correlativasPP2.add(pp1);
	// *
	// * Set<Materia> correlativasBaseDatos2 = new HashSet<Materia>();
	// * correlativasBaseDatos2.add(baseDatos1);
	// * correlativasBaseDatos2.add(prog3);
	// *
	// * Set<Materia> correlativasSisto2 = new HashSet<Materia>();
	// * correlativasSisto2.add(sisto1);
	// *
	// * Set<Materia> correlativasPracticaProfSup1 = new HashSet<Materia>();
	// * correlativasPracticaProfSup1.add(pp2);
	// * correlativasPracticaProfSup1.add(baseDatos2);
	// *
	// * Set<Materia> correlativasModeladoOptim = new HashSet<Materia>();
	// * correlativasModeladoOptim.add(probabilidadEstadistica);
	// *
	// * Set<Materia> correlativasInformaticaSociedad = new
	// * HashSet<Materia>(); correlativasInformaticaSociedad.add(ingenieria1);
	// *
	// * Set<Materia> correlativasPracticaProfSup2 = new HashSet<Materia>();
	// * correlativasPracticaProfSup2.add(practicaProfSup1);
	// * correlativasPracticaProfSup2.add(modeladoYOptimizacion);
	// *
	// * Set<Materia> correlativasGestionProyectos = new HashSet<Materia>();
	// * correlativasGestionProyectos.add(ingenieria2);
	// *
	// * //TODO CASO ESPECIAL!! necesita 11 materias cualquiera!! //
	// * Set<Materia> correlativasLaboratorioInterdisciplinario = new
	// * HashSet<Materia>();
	// *
	// * Set<Materia> correlativasIngles2 = new HashSet<Materia>();
	// * correlativasIngles2.add(ingles1);
	// *
	// * Set<Materia> correlativasIngles3 = new HashSet<Materia>();
	// * correlativasIngles2.add(ingles2);
	// *
	// * HashMap<Materia,Set<Materia>> correlativas = new HashMap<Materia,
	// * Set<Materia>>(); correlativas.put(ip, sinCorrelativas);
	// * correlativas.put(introALaMatematica, sinCorrelativas);
	// * correlativas.put(lecto, sinCorrelativas); correlativas.put(prog1,
	// * correlativasProg1); correlativas.put(logica, correlativasLogica);
	// * correlativas.put(orga1, sinCorrelativas); correlativas.put(prog2,
	// * correlativasProg2); correlativas.put(algebraLineal,
	// * correlativasAlgebraLineal); correlativas.put(sisto1,
	// * correlativasSisto1); correlativas.put(prog3, correlativasProg3);
	// * correlativas.put(calculo1, correlativasCalculo1);
	// * correlativas.put(psec, sinCorrelativas); correlativas.put(baseDatos1,
	// * correlativasBaseDatos1); correlativas.put(mateDiscreta,
	// * correlativasMateDiscreta); correlativas.put(especificacionSoft,
	// * correlativasEspecificacion); correlativas.put(teoriaDeLaComputacion,
	// * correlativasTeoriaComputacion); correlativas.put(ingenieria1,
	// * correlativasIngeieria1); correlativas.put(probabilidadEstadistica,
	// * correlativasProbabilidadEstadistica); correlativas.put(pp1,
	// * correlativasPP1); correlativas.put(ingenieria2,
	// * correlativasIngenieria2); correlativas.put(orga2, correlativasOrga2);
	// * correlativas.put(pp2, correlativasPP2); correlativas.put(baseDatos2,
	// * correlativasBaseDatos2); correlativas.put(sisto2,
	// * correlativasSisto2); correlativas.put(practicaProfSup1,
	// * correlativasPracticaProfSup1);
	// * correlativas.put(modeladoYOptimizacion, correlativasModeladoOptim);
	// * correlativas.put(informaticaYSociedad,
	// * correlativasInformaticaSociedad); correlativas.put(practicaProfSup2,
	// * correlativasPracticaProfSup2); correlativas.put(gestionProyectos,
	// * correlativasGestionProyectos); //TODO CASO ESPECIAL!!! //
	// * correlativas.put(laboratorioInterdisciplinario, );
	// * correlativas.put(tallerUtilitarios, sinCorrelativas);
	// * correlativas.put(ingles1, sinCorrelativas); correlativas.put(ingles2,
	// * correlativasIngles2); correlativas.put(ingles3, correlativasIngles3);
	// *
	// *
	// * PlanEstudio planEstudio = new PlanEstudio(correlativas);
	// *
	// * /////CREO MATERIA APROBADA MateriaAprobada matAprobProg1 = new
	// * MateriaAprobada(prog1, 8); // MateriaAprobada matAprobProg2 = new
	// * MateriaAprobada(prog2, 7); // MateriaAprobada matAprobCalculo1 = new
	// * MateriaAprobada(calculo1,10.0); // MateriaAprobada matAprobIngles1 =
	// * new MateriaAprobada(ingles1,10.0); // MateriaAprobada matAprobPP1 =
	// * new MateriaAprobada(pp1,10.0); // MateriaAprobada matAprobIP = new
	// * MateriaAprobada(ip,10.0); // MateriaAprobada
	// * matAprobIntroALaMatematica = new
	// * MateriaAprobada(introALaMatematica,10.0); // MateriaAprobada
	// * matAprobLecto = new MateriaAprobada(lecto,10.0); // MateriaAprobada
	// * matAprobTallerUtilitarios = new
	// * MateriaAprobada(tallerUtilitarios,10.0);
	// *
	// * try
	// *
	// * { MateriaDAO.getInstancia().alta(calculo1);
	// * MateriaDAO.getInstancia().alta(prog1);
	// * MateriaDAO.getInstancia().alta(prog2);
	// * MateriaDAO.getInstancia().alta(prog3);
	// * MateriaDAO.getInstancia().alta(pp1);
	// * MateriaDAO.getInstancia().alta(ingles1);
	// * MateriaDAO.getInstancia().alta(pp2);
	// * MateriaDAO.getInstancia().alta(ip);
	// * MateriaDAO.getInstancia().alta(introALaMatematica);
	// * MateriaDAO.getInstancia().alta(lecto);
	// * MateriaDAO.getInstancia().alta(logica);
	// * MateriaDAO.getInstancia().alta(psec);
	// *
	// * // CursoDAO.getInstancia().alta(cursoCalculo1);
	// * //CursoDAO.getInstancia().alta(cursoPP1);
	// * CursoDAO.getInstancia().alta(cursoProg1);
	// * CursoDAO.getInstancia().alta(cursoProg2);
	// * CursoDAO.getInstancia().alta(cursoIntroALaMatematica);
	// * CursoDAO.getInstancia().alta(cursoProg3);
	// * CursoDAO.getInstancia().alta(cursoUtil);
	// *
	// * MateriaAprobadaDAO.getInstancia().alta(matAprobProg1); //
	// * MateriaAprobadaDAO.getInstancia().alta(matAprobProg2);
	// *
	// *
	// * PlanEstudioDAO.getInstancia().alta(planEstudio);
	// */
	//
	// // PROBRAR!!!!
	// // Filtrador fil = new Filtrador();
	// // 18 es la hora de inicio del turno que quiere filtrar (18 hs para
	// // turno noche)
	// // Set<Curso> cursosDisponiblesTurnoNoche =
	// // fil.getCursosDisponibles(18);
	//
	// // ArrayList<Curso> cursos = new
	// // ArrayList<Curso>(cursosDisponiblesTurnoNoche);
	// // Recomendacion reco = new Recomendacion();
	// // List<Recomendacion> recomendaciones;
	// // reco.backtracking(cursos);
	// // int i = 1;
	// // for(Recomendacion r : recomendaciones){
	// // System.out.println();
	// // System.out.println();
	// // System.out.println("Recomendacion " + i);
	// // for(Curso c : r.getRecomendacion()){
	// // System.out.println("Materia: " + c.getMateria().getNombre());
	// // for(int j=0;j<c.getHorario().size();j++){
	// // System.out.println("---Dia: " + c.getHorario().get(j).getDia());
	// // System.out.print("---De: " + c.getHorario().get(j).getHoraInicio());
	// // System.out.print("hs a " + c.getHorario().get(j).getHoraFin()+ " hs")
	// // ;
	// // System.out.println();
	// // }
	// //
	// // }
	// // i++;
	// // }
	//
	// new Escritorio();
	// // }
	// // catch (Exception e)
	// // {
	// // e.printStackTrace();
	// // }
	// }

	public void filtrarTurnos(boolean filtro, String turno) throws Exception
	{
		List<Horario> horarios = new ArrayList<Horario>();
		Horario horarTmp;
		switch (turno) {
			case "M" :
				filtroManiana = filtro;
				break;
			case "T" :
				filtroTarde = filtro;
				break;
			case "N" :
				filtroNoche = filtro;
				break;
			default :
				break;
		}
		if (filtroManiana)
		{
			horarTmp = new Horario(8, 12);
			horarios.add(horarTmp);
		}
		if (filtroTarde)
		{
			horarTmp = new Horario(13, 17);
			horarios.add(horarTmp);
		}
		if (filtroNoche)
		{
			horarTmp = new Horario(18, 22);
			horarios.add(horarTmp);
		}

		Filtrador f = new Filtrador();
		Set<Curso> cursos = f.getCursosDisponibles(this.vista.getModelo().getCursosDisponibles(),
				horarios);
		List<Curso> cursosDisp = new ArrayList<Curso>(cursos);
		this.vista.getModelo().calcularRecomendaciones(cursosDisp);
	}

	public void actionPerformed(ActionEvent arg0)
	{

	}

	public void actionListener(ActionListener escuchador)
	{
		vista.cbManiana.addActionListener(escuchador);

	}

	public GRCView getVista()
	{
		return vista;
	}

	public void setVista(GRCView vista)
	{
		this.vista = vista;
	}

	public void cambioFiltros(boolean filtro, String turno)
	{
		try
		{
			filtrarTurnos(filtro, turno);
		} catch (Exception e)
		{
			System.out.println("ERROR AL FILTRAR!!!");
			e.printStackTrace();
		}

	}

}
