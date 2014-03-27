package com.laboratorio.vista;

import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.AbstractListModel;
import java.awt.ComponentOrientation;

@SuppressWarnings("serial")
public class CopyOfPrototipo extends JInternalFrame 
{
	private JTable tablaAprobadas;
	private Integer tabSeleccionado;
	
	public CopyOfPrototipo() 
	{
		super ("Recomendaciones de cursada", false, true, true, true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		getContentPane().setLayout(null);
		
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
		panelRecomendaciones.setLayout(null);
		tabOpciones.addTab("Recomendaciones ",new ImageIcon (""), panelRecomendaciones, null);
			
		JScrollPane spRecomendaciones = new JScrollPane();
		spRecomendaciones.setEnabled(false);
		spRecomendaciones.setBounds(7, 181, 561, 277);
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBox.setBounds(123, 11, 40, 20);
		panelRecomendaciones.add(comboBox);
		
		JLabel lblCantidadDeMaterias = new JLabel("Cantidad de materias:");
		lblCantidadDeMaterias.setBounds(10, 14, 111, 14);
		panelRecomendaciones.add(lblCantidadDeMaterias);
		
		JLabel lblHorarios = new JLabel("Horarios:");
		lblHorarios.setBounds(10, 39, 46, 14);
		panelRecomendaciones.add(lblHorarios);
		
		JLabel lblMaana = new JLabel("Ma\u00F1ana");
		lblMaana.setBounds(66, 39, 46, 14);
		panelRecomendaciones.add(lblMaana);
		
		JLabel lblTarde = new JLabel("Tarde");
		lblTarde.setBounds(153, 39, 40, 14);
		panelRecomendaciones.add(lblTarde);
		
		JLabel lblNoche = new JLabel("Noche");
		lblNoche.setBounds(224, 39, 46, 14);
		panelRecomendaciones.add(lblNoche);
		
		JCheckBox cbManana = new JCheckBox("");
		cbManana.setBounds(108, 35, 21, 23);
		panelRecomendaciones.add(cbManana);
		
		JCheckBox cbTarde = new JCheckBox("");
		cbTarde.setBounds(182, 35, 21, 23);
		panelRecomendaciones.add(cbTarde);
		
		JCheckBox cbNoche = new JCheckBox("");
		cbNoche.setBounds(257, 35, 21, 23);
		panelRecomendaciones.add(cbNoche);
		
		JLabel lblMaterias = new JLabel("Materias:");
		lblMaterias.setBounds(10, 64, 46, 14);
		panelRecomendaciones.add(lblMaterias);
		
		
		JButton btnGenerar = new JButton("Generar");
		
		btnGenerar.setBounds(10, 147, 89, 23);
		panelRecomendaciones.add(btnGenerar);
		
		JScrollPane spMateriasAElegir = new JScrollPane();
		spMateriasAElegir.setBounds(66, 71, 502, 65);
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
			});
			tablaAprobadas.getColumnModel().getColumn(0).setPreferredWidth(40);
			tablaAprobadas.getColumnModel().getColumn(1).setResizable(false);
			tablaAprobadas.getColumnModel().getColumn(1).setPreferredWidth(248);
			tablaAprobadas.setRowHeight(25);
			tablaAprobadas.getTableHeader().setReorderingAllowed(false);
		}
}
