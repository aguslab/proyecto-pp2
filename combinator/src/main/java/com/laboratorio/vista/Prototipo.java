package com.laboratorio.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Label;
import java.awt.Toolkit;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.text.*;

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
	
	@SuppressWarnings("deprecation")
	public Prototipo() 
	{
		super ("Recomendaciones de materias a cursar");
		
		escritorio.setBackground(new Color(83, 130, 161));
		UIManager.addPropertyChangeListener (new UISwitchListener ((JComponent)getRootPane()));
		barra = new JMenuBar ();
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
		
			
		JScrollPane spRecomendaciones = new JScrollPane();
		spRecomendaciones.setBounds(10, 295, 633, 276);
		spRecomendaciones.setEnabled(false);
		panelRecomendaciones.add(spRecomendaciones);
		
		DefaultTableModel modelo = new DefaultTableModel();
		JTable tablaDias = new JTable(modelo);
		tablaDias.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spRecomendaciones.setViewportView(tablaDias);
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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(144, 11, 49, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		panelRecomendaciones.add(comboBox);
		
		JLabel lblCantidadDeMaterias = new JLabel("Cantidad de materias:");
		lblCantidadDeMaterias.setBounds(10, 14, 133, 14);
		panelRecomendaciones.add(lblCantidadDeMaterias);
		
		JLabel lblHorarios = new JLabel("Horarios:");
		lblHorarios.setBounds(10, 39, 74, 14);
		panelRecomendaciones.add(lblHorarios);
		
		JLabel lblMaana = new JLabel("Ma\u00F1ana");
		lblMaana.setBounds(86, 39, 57, 14);
		panelRecomendaciones.add(lblMaana);
		
		JCheckBox cbManana = new JCheckBox("");
		cbManana.setBounds(132, 35, 21, 23);
		panelRecomendaciones.add(cbManana);
		
		JLabel lblMaterias = new JLabel("Materias:");
		lblMaterias.setBounds(10, 64, 74, 14);
		panelRecomendaciones.add(lblMaterias);
		
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(13, 260, 89, 23);
		panelRecomendaciones.add(btnGenerar);
		
		JScrollPane spMateriasAElegir = new JScrollPane();
		spMateriasAElegir.setBounds(86, 67, 557, 182);
		panelRecomendaciones.add(spMateriasAElegir);
		
		JList listMateriasAElegir = new JList();
		listMateriasAElegir.setModel(new AbstractListModel() {
			String[] values = new String[] {"Introducci\u00F3n a la programaci\u00F3n", "Matem\u00E1tica discreta", "Introducci\u00F3n al razonamiento matem\u00E1tico", "L\u00F3gica y teor\u00EDa de n\u00FAmeros", "\u00C1lgebra lineal", "Organizaci\u00F3n del computador"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		spMateriasAElegir.setViewportView(listMateriasAElegir);
		
		JLabel lblTarde = new JLabel("Tarde");
		lblTarde.setBounds(173, 39, 49, 14);
		panelRecomendaciones.add(lblTarde);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(209, 35, 21, 23);
		panelRecomendaciones.add(checkBox);
		
		JLabel lblNoche = new JLabel("Noche");
		lblNoche.setBounds(254, 39, 49, 14);
		panelRecomendaciones.add(lblNoche);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(294, 35, 21, 23);
		panelRecomendaciones.add(checkBox_1);
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
			
			mostrarPrototipo = new JMenuItem ("Ver  ", new ImageIcon ("Imagenes/calendario2.png"));
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
