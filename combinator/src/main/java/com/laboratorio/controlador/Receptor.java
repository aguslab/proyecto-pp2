package com.laboratorio.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.laboratorio.dao.CursoDAO;
import com.laboratorio.dao.HorarioDAO;
import com.laboratorio.dao.MateriaAprobadaDAO;
import com.laboratorio.dao.MateriaDAO;
import com.laboratorio.modelo.Curso;
import com.laboratorio.modelo.Horario;
import com.laboratorio.modelo.Materia;
import com.laboratorio.modelo.MateriaAprobada;
import com.laboratorio.modelo.Recomendacion;
import com.laboratorio.vista.Escritorio;

public class Receptor
{
	static ArrayList<Curso> cursos;
	public Receptor(ArrayList<Curso> cursos)
	{
		this.cursos = cursos;
	}
	
	public static DefaultTableModel cambiarTablaDias(DefaultTableModel tablaDias, String value)
	{
		String delimiter = "/";
		String[] temp;
		temp = value.split(delimiter);
		for(int i = 0; i < temp.length ; i++)
		{
			//tablaDias.setValueAt(temp[i], 0, i);
			if (temp[i].startsWith(" Lunes"))
			{
				Object nuevaFilaDatos[]= {temp[i],"","","","",""};
				tablaDias.addRow(nuevaFilaDatos);
				//tablaDias.setValueAt(temp[i], 0, 0);
			}
			else if(temp[i].startsWith(" Martes"))
			{
				Object nuevaFilaDatos[]= {"",temp[i],"","","",""};
				tablaDias.addRow(nuevaFilaDatos);
				//tablaDias.setValueAt(temp[i], 0, 1);
			}
			else if(temp[i].startsWith(" Miercoles"))
			{
				Object nuevaFilaDatos[]= {"","",temp[i],"","",""};
				tablaDias.addRow(nuevaFilaDatos);
			}	
			else if(temp[i].startsWith(" Jueves"))
			{
				Object nuevaFilaDatos[]= {"","","",temp[i],"",""};
				tablaDias.addRow(nuevaFilaDatos);
				//tablaDias.setValueAt(temp[i], 0, 3);
			}
			else if(temp[i].startsWith(" Viernes"))
			{
				Object nuevaFilaDatos[]= {"","","","",temp[i],""};
				tablaDias.addRow(nuevaFilaDatos);
				//tablaDias.setValueAt(temp[i], 0, 4);
			}
			else
			{
				//Object nuevaFilaDatos[]= {"","","","","",temp[i]};
				//tablaDias.addRow(nuevaFilaDatos);
				tablaDias.setValueAt(temp[i], 0, 5);
			}
		}
		return tablaDias;
	}
	

	public static void main (String args[]) throws Exception 
	{
		//filtra por turno, materias aprobadas, correlatividades
				//Despues con todo eso hace las combinaciones
				
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
        
      //CREO MATERIAS APROBADAS
        MateriaAprobada ma1 = new MateriaAprobada(ip, 8.5);
        MateriaAprobada ma2 = new MateriaAprobada (irm, 10);
        
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
        
        cursos = new ArrayList<Curso>();
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		cursos.add(c4);
		cursos.add(c5);
		cursos.add(c6);
		cursos.add(c7);
		cursos.add(c8);

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
		
		MateriaAprobadaDAO.getInstancia().alta(ma1);
		MateriaAprobadaDAO.getInstancia().alta(ma2);
		
		//r.mostrarRecomendacion(r);
		new Escritorio ();
		
	}

	public ArrayList<Curso> getCursos() 
	{
		return cursos;
	}


	public void setCursos(ArrayList<Curso> cursos) 
	{
		this.cursos = cursos;
	}
	
	public static String getRecomendacion() throws Exception
	{
		return Recomendacion.armarRecomendacion(CursoDAO.getInstancia().combinaciones(cursos));
	}
	
	public static DefaultTableModel getMateriasAprobadas(DefaultTableModel tablaDias) throws Exception
	{
		List<MateriaAprobada> matAprobadas = MateriaAprobadaDAO.getInstancia().obtenerTodo();
		String nombreMateria;
		double nota;
		for(int i = 0; i < matAprobadas.size() ; i++)
		{
			nombreMateria = matAprobadas.get(i).getMateriaAprobada().getNombre();
			nota = matAprobadas.get(i).getNota();
			
			Object nuevaFilaDatos[]= {nombreMateria,nota};
			tablaDias.addRow(nuevaFilaDatos);
		}
		return tablaDias;
	}
	
}
