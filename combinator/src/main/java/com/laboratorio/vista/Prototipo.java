package com.laboratorio.vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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

	private JLabel firma;
	private JLabel materia;
	private JTable tablaAprobadas;
	@SuppressWarnings("unused")
	private Integer tabSeleccionado;
	
	public Prototipo() 
	{
		super ("Recomendaciones de materias a cursar");
		
		escritorio.setBackground(new Color(83, 130, 161));
		UIManager.addPropertyChangeListener (new UISwitchListener ((JComponent)getRootPane()));
		barra = new JMenuBar ();
		setIconImage (getToolkit().getImage ("Imagenes/tabla.png"));
		setSize(new Dimension(740, 508));
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
			
			JScrollPane spRecomendacion = new JScrollPane();
			spRecomendacion.setEnabled(false);
			spRecomendacion.setBounds(10, 240, 533, 179);
			panelRecomendaciones.add(spRecomendacion);
			final JTable tablaDias = new JTable(modelo);
			tablaDias.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			spRecomendacion.setViewportView(tablaDias);
			tablaDias.setModel(new DefaultTableModel(
				new Object[][] {
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
			
			JLabel lblHorarios = new JLabel("Horarios:");
			lblHorarios.setBounds(10, 11, 74, 14);
			panelRecomendaciones.add(lblHorarios);
			
			JLabel lblManiana = new JLabel("Ma\u00F1ana");
			lblManiana.setBounds(85, 11, 57, 14);
			panelRecomendaciones.add(lblManiana);
			
			JCheckBox cbManana = new JCheckBox("");
			cbManana.setBounds(131, 7, 21, 23);
			panelRecomendaciones.add(cbManana);
			
			JLabel lblRecomendaciones = new JLabel("Recomendaciones:");
			lblRecomendaciones.setBounds(10, 217, 112, 14);
			panelRecomendaciones.add(lblRecomendaciones);
			
			JLabel lblTarde = new JLabel("Tarde");
			lblTarde.setBounds(172, 11, 49, 14);
			panelRecomendaciones.add(lblTarde);
			
			JCheckBox checkBox = new JCheckBox("");
			checkBox.setBounds(208, 7, 21, 23);
			panelRecomendaciones.add(checkBox);
			
			JLabel lblNoche = new JLabel("Noche");
			lblNoche.setBounds(253, 11, 49, 14);
			panelRecomendaciones.add(lblNoche);
			
			JCheckBox checkBox_1 = new JCheckBox("");
			checkBox_1.setBounds(293, 7, 21, 23);
			panelRecomendaciones.add(checkBox_1);
			
			JButton btnOk2 = new JButton(new ImageIcon ("Imagenes/ok.png"));
			btnOk2.setBounds(553, 243, 24, 23);
			panelRecomendaciones.add(btnOk2);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 37, 533, 169);
			panelRecomendaciones.add(scrollPane);
			
			final JList<String> listaRecomendaciones = new JList<String>();
			listaRecomendaciones.setModel(new AbstractListModel() {
				String[] values = new String[] {"1", "2"};
				public int getSize() {
					return values.length;
				}
				public Object getElementAt(int index) {
					return values[index];
				}
			});
			listaRecomendaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(listaRecomendaciones);
			listaRecomendaciones.addListSelectionListener(new ListSelectionListener()
			  {
			    public void valueChanged(ListSelectionEvent e)
			    {
			      if (e.getValueIsAdjusting() == false)
			      {
			    	 /*Prueba para mostrar la recomendacion elegida en la tabla
			    	  *  String value = listaRecomendaciones.getSelectedValue();
			        System.out.println(value);
			        DefaultTableModel tablaTemp = (DefaultTableModel) tablaDias.getModel();
					tablaTemp.setValueAt(value, 0, 0);
					tablaTemp.setValueAt("", 0, 1);
					tablaTemp.setValueAt("", 0, 2);
					tablaTemp.setValueAt("", 0, 3);
					tablaTemp.setValueAt("", 0, 4);
					tablaTemp.setValueAt("", 0, 5);*/
			      }
			    }
			  });
	
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
			spAprobadas.setBounds(10, 11, 558, 407);
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
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] {
					String.class, String.class
				};
				public Class<?> getColumnClass(int columnIndex) {
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
		
			
			materia = new JLabel (" " + "Proyecto Profesional II", Label.LEFT);
			materia.setForeground (Color.black);
			
			firma = new JLabel ("" + "GRC - Godoy y De Napoli." + " ", JLabel.RIGHT);
			firma.setForeground (Color.black);
			
			barraDeEstado.setLayout (new BorderLayout());
			barraDeEstado.add (materia, BorderLayout.WEST);
			barraDeEstado.add (firma, BorderLayout.EAST);

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
		    	"¿Está seguro que desea cerrar la aplicación?",
		    	"Cerrando GRC", JOptionPane.YES_NO_OPTION, 
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
