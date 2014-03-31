package com.laboratorio.vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.text.*;

import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class Prototipo 
extends JFrame 
implements 
ActionListener, 
ItemListener
{
	private JDesktopPane escritorio = new JDesktopPane ();
	private JMenuBar barra;
	private JMenu 
		mnuPrototipo;
	
	private	JMenuItem 
	mostrarPrototipo;
	
	private	JMenuItem 
		cerrarAplicacion;

	private JPanel barraDeEstado = new JPanel ();

	private JLabel fechaPie;
	private JLabel propiedadIntelectual;

	private java.util.Date fechaActual= new java.util.Date ();
	
	private SimpleDateFormat fechaFormateada = new SimpleDateFormat ("dd MMMM yyyy", Locale.getDefault());
	
	private String fecha = fechaFormateada.format (fechaActual);
	
	private JTable tablaAprobadas;
	@SuppressWarnings("unused")
	private Integer tabSeleccionado;
	private JTable table;
	
	@SuppressWarnings("deprecation")
	public Prototipo() 
	{
		super ("Recomendaciones de materias a cursar");
		
		escritorio.setBackground(new Color(83, 130, 161));
		UIManager.addPropertyChangeListener (new UISwitchListener ((JComponent)getRootPane()));
		barra = new JMenuBar ();
		setIconImage (getToolkit().getImage ("Imagenes/tabla.png"));
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setJMenuBar (barra);
		
		for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels())
		{
	        if("Nimbus".equals(laf.getName()))
	            try 
	        	{
	            	UIManager.setLookAndFeel(laf.getClassName());
	        	} 
	        	catch (Exception ex) 
	        	{
	        		
	        	}
	    }
		addWindowListener 
		(
				new WindowAdapter () 
				{
					public void windowClosing (WindowEvent we) 
					{
						salirDelPrograma();
					}
				}
		);

		setLocation
		(
				(Toolkit.getDefaultToolkit().getScreenSize().width  - getWidth()) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2
		);
		setVisible (true);
		final JTabbedPane tabOpciones = new JTabbedPane(JTabbedPane.LEFT);
		tabOpciones.addChangeListener(new ChangeListener() 
		{
			public void stateChanged(ChangeEvent arg0) 
			{
				if (tabOpciones.getTitleAt(tabOpciones.getSelectedIndex()).equals("Recomendaciones                         ")) 
			    {
					tabSeleccionado = 0;
			    }
				else if (tabOpciones.getTitleAt(tabOpciones.getSelectedIndex()).equals("Materias aprobadas                         ")) 
			    {
					tabSeleccionado = 1;
			    }
			}
		});
		tabOpciones.setBounds(10, 11, 772, 474);
		getContentPane().add(tabOpciones);
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		DefaultTableModel modelo2 = new DefaultTableModel();
		
		DefaultTableModel modelo3 = new DefaultTableModel();
		
		DefaultTableModel modelo4 = new DefaultTableModel();
			
			// Tabla Recomendaciones
			JPanel panelRecomendaciones = new JPanel();
			panelRecomendaciones.setBorder
			(
				new LineBorder
				(
					new Color(0, 0, 0)
				)
			);
			tabOpciones.addTab("Recomendaciones ",new ImageIcon (""), panelRecomendaciones, null);
			panelRecomendaciones.setLayout(null);
			
				
			JScrollPane spRecomendacion1 = new JScrollPane();
			spRecomendacion1.setBounds(10, 89, 533, 179);
			spRecomendacion1.setEnabled(false);
			panelRecomendaciones.add(spRecomendacion1);
			JTable tablaDias = new JTable(modelo);
			tablaDias.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spRecomendacion1.setViewportView(tablaDias);
			tablaDias.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tablaDias.setRowHeight(25);
			tablaDias.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane spRecomendacion2 = new JScrollPane();
			spRecomendacion2.setEnabled(false);
			spRecomendacion2.setBounds(10, 304, 533, 179);
			panelRecomendaciones.add(spRecomendacion2);
			JTable tablaDias2 = new JTable(modelo2);
			tablaDias2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spRecomendacion2.setViewportView(tablaDias2);
			tablaDias2.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tablaDias2.setRowHeight(25);
			tablaDias2.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane spRecomendacion3 = new JScrollPane();
			spRecomendacion3.setEnabled(false);
			spRecomendacion3.setBounds(610, 89, 533, 179);
			panelRecomendaciones.add(spRecomendacion3);
			JTable tablaDias3 = new JTable(modelo3);
			tablaDias3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spRecomendacion3.setViewportView(tablaDias3);
			tablaDias3.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tablaDias3.setRowHeight(25);
			tablaDias3.getTableHeader().setReorderingAllowed(false);
			
			JScrollPane spRecomendacion4 = new JScrollPane();
			spRecomendacion4.setEnabled(false);
			spRecomendacion4.setBounds(610, 304, 533, 179);
			panelRecomendaciones.add(spRecomendacion4);
			JTable tablaDias4 = new JTable(modelo4);
			tablaDias4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spRecomendacion4.setViewportView(tablaDias4);
			tablaDias4.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				},
				new String[] {
					"Lunes", "Martes", "Mi\u00E9rcoles", "Jueves", "Viernes", "S\u00E1bado"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			tablaDias4.setRowHeight(25);
			tablaDias4.getTableHeader().setReorderingAllowed(false);
			
			JComboBox cbCantidadMaterias = new JComboBox();
			cbCantidadMaterias.setBounds(144, 11, 49, 20);
			cbCantidadMaterias.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
			panelRecomendaciones.add(cbCantidadMaterias);
			
			JLabel lblCantidadDeMaterias = new JLabel("Cantidad de materias:");
			lblCantidadDeMaterias.setBounds(10, 14, 133, 14);
			panelRecomendaciones.add(lblCantidadDeMaterias);
			
			JLabel lblHorarios = new JLabel("Horarios:");
			lblHorarios.setBounds(265, 14, 74, 14);
			panelRecomendaciones.add(lblHorarios);
			
			JLabel lblMaana = new JLabel("Ma\u00F1ana");
			lblMaana.setBounds(340, 14, 57, 14);
			panelRecomendaciones.add(lblMaana);
			
			JCheckBox cbManana = new JCheckBox("");
			cbManana.setBounds(386, 10, 21, 23);
			panelRecomendaciones.add(cbManana);
			
			JLabel lblMaterias = new JLabel("Recomendaciones:");
			lblMaterias.setBounds(10, 64, 112, 14);
			panelRecomendaciones.add(lblMaterias);
			
			JLabel lblTarde = new JLabel("Tarde");
			lblTarde.setBounds(427, 14, 49, 14);
			panelRecomendaciones.add(lblTarde);
			
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setBounds(463, 10, 21, 23);
			panelRecomendaciones.add(checkBox);
			
			JLabel lblNoche = new JLabel("Noche");
			lblNoche.setBounds(508, 14, 49, 14);
			panelRecomendaciones.add(lblNoche);
			
			JCheckBox checkBox_1 = new JCheckBox("");
			checkBox_1.setBounds(548, 10, 21, 23);
			panelRecomendaciones.add(checkBox_1);
			
			JButton btnOk1 = new JButton(new ImageIcon ("Imagenes/ok.png"));
			btnOk1.setBounds(553, 89, 24, 23);
			panelRecomendaciones.add(btnOk1);
			
			JButton btnNo1 = new JButton(new ImageIcon ("Imagenes/no.png"));
			btnNo1.setBounds(553, 115, 24, 23);
			panelRecomendaciones.add(btnNo1);
			
			JButton btnOk2 = new JButton(new ImageIcon ("Imagenes/ok.png"));
			btnOk2.setBounds(553, 304, 24, 23);
			panelRecomendaciones.add(btnOk2);
			
			JButton btnNo2 = new JButton(new ImageIcon ("Imagenes/no.png"));
			btnNo2.setBounds(553, 330, 24, 23);
			panelRecomendaciones.add(btnNo2);
			
			JButton btnOk3 = new JButton(new ImageIcon ("Imagenes/ok.png"));
			btnOk3.setBounds(1153, 89, 24, 23);
			panelRecomendaciones.add(btnOk3);
			
			JButton btnNo3 = new JButton(new ImageIcon ("Imagenes/no.png"));
			btnNo3.setBounds(1153, 115, 24, 23);
			panelRecomendaciones.add(btnNo3);
			
			JButton btnOk4 = new JButton(new ImageIcon ("Imagenes/ok.png"));
			btnOk4.setBounds(1153, 304, 24, 23);
			panelRecomendaciones.add(btnOk4);
			
			JButton btnNo4 = new JButton(new ImageIcon ("Imagenes/no.png"));
			btnNo4.setBounds(1153, 330, 24, 23);
			panelRecomendaciones.add(btnNo4);
			tablaDias.getTableHeader().setReorderingAllowed(false);
		
	
	// Tabla Materia aprobadas
			JPanel panelAprobadas = new JPanel();
			panelAprobadas.setBorder
			(
				new LineBorder
				(
					new Color(0, 0, 0)
				)
			);
			panelAprobadas.setLayout(null);
			
			tabOpciones.addTab("Materias aprobadas ",new ImageIcon (""), panelAprobadas, null);
				
			JScrollPane spAprobadas = new JScrollPane();
			spAprobadas.setBounds(10, 11, 558, 447);
			panelAprobadas.add(spAprobadas);
			
			tablaAprobadas = new JTable();
			tablaAprobadas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spAprobadas.setViewportView(tablaAprobadas);
			tablaAprobadas.setModel(new DefaultTableModel(
				new Object[][] {
					{"Lectoescritura", "9"},
					{"Taller de utilitarios", "10"},
				},
				new String[] {
					"Materia", "Nota"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
				public void itemStateChanged(ItemEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			tablaAprobadas.getColumnModel().getColumn(0).setPreferredWidth(40);
			tablaAprobadas.getColumnModel().getColumn(1).setResizable(false);
			tablaAprobadas.getColumnModel().getColumn(1).setPreferredWidth(248);
			tablaAprobadas.setRowHeight(25);
			tablaAprobadas.getTableHeader().setReorderingAllowed(false);
			
			mnuPrototipo = new JMenu ("Prototipo  ");
			mnuPrototipo.setMnemonic ((int)'P');
			
			mostrarPrototipo = new JMenuItem ("Ver  ", new ImageIcon ("Imagenes/tabla.png"));
			mostrarPrototipo.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
			mostrarPrototipo.setMnemonic ((int)'V');
			mostrarPrototipo.addActionListener (this);
			
			cerrarAplicacion = new JMenuItem ("Salir del sistema  ", new ImageIcon ("Imagenes/cerrar.png"));
			cerrarAplicacion.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
			cerrarAplicacion.setMnemonic ((int)'Q');	
			cerrarAplicacion.addActionListener (this);
			
			mnuPrototipo.add (mostrarPrototipo);
		
			
			propiedadIntelectual = new JLabel (" " + "PP2 - Godoy y De Napoli.", Label.LEFT);
			propiedadIntelectual.setForeground (Color.black);
			propiedadIntelectual.setToolTipText ("Todos los derechos reservados");
			
			fechaPie = new JLabel ("" + fecha + " ", JLabel.RIGHT);
			
			fechaPie.setForeground (Color.black);
			fechaPie.setToolTipText ("Fecha actual del sistema");
			
			barraDeEstado.setLayout (new BorderLayout());
			barraDeEstado.add (propiedadIntelectual, BorderLayout.WEST);
			barraDeEstado.add (fechaPie, BorderLayout.EAST);

			escritorio.putClientProperty ("JDesktopPane.dragMode", "outline");

			getContentPane().add (escritorio, BorderLayout.NORTH);
			getContentPane().add (barraDeEstado, BorderLayout.SOUTH);
			
			setVisible (true);
		}

	private void salirDelPrograma() 
	{
		try 
		{
		    int reply = JOptionPane.showConfirmDialog 
		    (
		    	this,
		    	"¿Está seguro que desea cerrar\nesta aplicación?",
		    	fecha, JOptionPane.YES_NO_OPTION, 
		    	JOptionPane.WARNING_MESSAGE
		    );

			if (reply == JOptionPane.YES_OPTION) 
			{
				setVisible (false);
				dispose();
				System.exit (0);
			}
			else if (reply == JOptionPane.NO_OPTION) 
			{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		} 
		catch (Exception e) 
		{
			
		}
	}
	
	public void itemStateChanged(ItemEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
}
