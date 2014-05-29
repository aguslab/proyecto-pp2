package grc.vista;

import grc.controlador.GRCController;
import grc.modelo.GRCModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class GRCView extends JFrame implements Observer, ActionListener
{
	private GRCModel model;
	private GRCController controller;
	private JDesktopPane escritorio = new JDesktopPane();
	private JMenuBar barra;
	private JMenu mnuPrototipo;

	private JMenuItem mostrarPrototipo;

	private JMenuItem cerrarAplicacion;

	private JPanel barraDeEstado = new JPanel();

	public JCheckBox cbManiana;
	private JCheckBox cbTarde;
	private JCheckBox cbNoche;
	private JCheckBox cbPuedeEsperar;
	private JComboBox cbOrdenador;
	private JLabel firma;
	private JLabel materia;
	DefaultListModel modelListaRecomendaciones;
	JList listaRecomendaciones;
	DefaultTableModel modeloTablaDias;
	JTable tablaDias;

	public GRCView(GRCModel model, final GRCController controller) throws Exception
	{
		super("Recomendaciones de materias a cursar");
		this.model = model;
		this.controller = controller;
		escritorio.setBounds(0, 0, 1317, 1);
//		controller.setVista(this);

		escritorio.setBackground(new Color(83, 130, 161));
		UIManager.addPropertyChangeListener(new UISwitchListener((JComponent) getRootPane()));
		barra = new JMenuBar();
		setIconImage(getToolkit().getImage("Imagenes/tabla.png"));
		setSize(new Dimension(1333, 650));
		setJMenuBar(barra);

		for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels())
		{
			if ("Nimbus".equals(laf.getName()))
				try
				{
					UIManager.setLookAndFeel(laf.getClassName());
				} catch (Exception ex)
				{

				}
		}
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				salirDelPrograma();
			}
		});

		setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2, (Toolkit
				.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
		getContentPane().setLayout(null);

		modeloTablaDias = new DefaultTableModel();

		modelListaRecomendaciones = new DefaultListModel();

		mnuPrototipo = new JMenu("Prototipo  ");
		mnuPrototipo.setMnemonic((int) 'P');

		mostrarPrototipo = new JMenuItem("Ver  ", new ImageIcon("Imagenes/tabla.png"));
		mostrarPrototipo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK));
		mostrarPrototipo.setMnemonic((int) 'V');
		mostrarPrototipo.addActionListener(this);

		cerrarAplicacion = new JMenuItem("Salir del sistema  ");
		cerrarAplicacion.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Event.CTRL_MASK));
		cerrarAplicacion.setMnemonic((int) 'Q');
		cerrarAplicacion.addActionListener(this);

		mnuPrototipo.add(mostrarPrototipo);

		materia = new JLabel(" " + "Proyecto Profesional II", Label.LEFT);
		materia.setForeground(Color.black);

		firma = new JLabel("" + "GRC - Godoy - De Napoli." + " ", JLabel.RIGHT);
		firma.setForeground(Color.black);
		barraDeEstado.setBounds(0, 577, 1317, 14);

		barraDeEstado.setLayout(new BorderLayout());
		barraDeEstado.add(materia, BorderLayout.WEST);
		barraDeEstado.add(firma, BorderLayout.EAST);

		escritorio.putClientProperty("JDesktopPane.dragMode", "outline");

		getContentPane().add(escritorio);
		getContentPane().add(barraDeEstado);
		
		// Tabla Recomendaciones
		JPanel panelRecomendaciones = new JPanel();
		panelRecomendaciones.setBounds(0, 0, 1317, 571);
		getContentPane().add(panelRecomendaciones);
		panelRecomendaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelRecomendaciones.setLayout(null);
				
		JScrollPane spRecomendacion = new JScrollPane();
		spRecomendacion.setEnabled(false);
		spRecomendacion.setBounds(10, 241, 1297, 319);
		panelRecomendaciones.add(spRecomendacion);
		tablaDias = new JTable(modeloTablaDias);
		tablaDias.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaDias.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spRecomendacion.setViewportView(tablaDias);
		tablaDias.setModel(new DefaultTableModel(
			new Object[][] {
				{"8 a 9", null, null, null, null, null, null},
				{"9 a 10", null, null, null, null, null, null},
				{"10 a 11", null, null, null, null, null, null},
				{"11 a 12", null, null, null, null, null, null},
				{"12 a 13", null, null, null, null, null, null},
				{"13 a 14", null, null, null, null, null, null},
				{"14 a 15", null, null, null, null, null, null},
				{"15 a 16", null, null, null, null, null, null},
				{"16 a 17", null, null, null, null, null, null},
				{"17 a 18", null, null, null, null, null, null},
				{"18 a 19", null, null, null, null, null, null},
				{"19 a 20", null, null, null, null, null, null},
				{"20 a 21", null, null, null, null, null, null},
				{"21 a 22", null, null, null, null, null, null},
			},
			new String[] {
				"", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
			}
		));
		tablaDias.getColumnModel().getColumn(0).setPreferredWidth(15);
		tablaDias.setRowHeight(25);
		tablaDias.getTableHeader().setReorderingAllowed(false);
		tablaDias.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JLabel lblHorarios = new JLabel("Horarios:");
		lblHorarios.setBounds(10, 11, 74, 14);
		panelRecomendaciones.add(lblHorarios);
		
		JLabel lblManiana = new JLabel("Ma\u00F1ana");
		lblManiana.setBounds(85, 11, 57, 14);
		panelRecomendaciones.add(lblManiana);
		cbManiana = new JCheckBox("");
		cbManiana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.filtrarManiana(getCbManiana());
			}
		});
		cbManiana.setBounds(131, 7, 21, 23);
		//		cbManiana.setSelected(true);
		panelRecomendaciones.add(cbManiana);
				
		JLabel lblRecomendaciones = new JLabel("Recomendaciones:");
		lblRecomendaciones.setBounds(10, 217, 112, 14);
		panelRecomendaciones.add(lblRecomendaciones);
							
		JLabel lblTarde = new JLabel("Tarde");
		lblTarde.setBounds(172, 11, 49, 14);
		panelRecomendaciones.add(lblTarde);
		
		cbTarde = new JCheckBox("");
		cbTarde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("filtro tardeeeeee");
				controller.filtrarTarde(getCbTarde());
			}
		});
		cbTarde.setBounds(208, 7, 21, 23);
//		cbTarde.setSelected(true);
		panelRecomendaciones.add(cbTarde);
		
		JLabel lblNoche = new JLabel("Noche");
		lblNoche.setBounds(253, 11, 49, 14);
		panelRecomendaciones.add(lblNoche);
										
		cbNoche = new JCheckBox("");
		cbNoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.filtrarNoche(getCbNoche());
			}
		});
		cbNoche.setBounds(293, 7, 21, 23);
		//		cbNoche.setSelected(true);
				panelRecomendaciones.add(cbNoche);
						
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 1297, 169);
		panelRecomendaciones.add(scrollPane);
		listaRecomendaciones = new JList(modelListaRecomendaciones);
		listaRecomendaciones.setModel(new AbstractListModel()
		{
			String[] values = new String[]{};
			public int getSize()
			{
				return values.length;
			}
			public Object getElementAt(int index)
			{
				return values[index];
			}
		});
		listaRecomendaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaRecomendaciones);
		
		cbPuedeEsperar = new JCheckBox();
		cbPuedeEsperar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.puedeEsperar(puedeEsperar());
			}
		});
		cbPuedeEsperar.setBounds(490, 7, 21, 23);
		panelRecomendaciones.add(cbPuedeEsperar);
		
		JLabel label = new JLabel("Puedo Esperar :)");
		label.setBounds(380, 11, 111, 14);
		panelRecomendaciones.add(label);
		
		JButton btnVerRecomendaciones = new JButton("Ver Recomendaciones");
		btnVerRecomendaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.generarRecomendaciones();
			}
		});
		btnVerRecomendaciones.setBounds(584, 7, 167, 23);
		panelRecomendaciones.add(btnVerRecomendaciones);
		
		cbOrdenador = new JComboBox();
		cbOrdenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				controller.ordenarRecomendaciones(cbOrdenador.getSelectedIndex());
			}
		});
		cbOrdenador.setModel(new DefaultComboBoxModel(new String[] {"Materias", "Poscorrelativas", "Ambos"}));
		cbOrdenador.setBounds(124, 214, 125, 20);
		panelRecomendaciones.add(cbOrdenador);
		listaRecomendaciones.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (e.getValueIsAdjusting() == false)
				{
					DefaultTableModel tablaTempDias = (DefaultTableModel) tablaDias.getModel();
					tablaTempDias.setRowCount(0);
					int posElegida = listaRecomendaciones.getSelectedIndex();
					posElegida = posElegida != -1 ? posElegida : 0;
					borrarValores(tablaTempDias);
					try
					{
						cambioSeleccionActual(posElegida);
						controller.seleccionActualRecomendacion(posElegida);
					} catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			}																										});
	}

	protected void cambioSeleccionActual(int posElegida)
	{
		
		
	}

	public void showVista()
	{
		setVisible(true);
	}

	private void salirDelPrograma()
	{
		try
		{
			int reply = JOptionPane.showConfirmDialog(this,
					"¿Está seguro que desea cerrar la aplicación?", "Cerrando GRC",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

			if (reply == JOptionPane.YES_OPTION)
			{
				setVisible(false);
				dispose();
				System.exit(0);
			} else if (reply == JOptionPane.NO_OPTION)
			{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		} catch (Exception e)
		{

		}
	}
	
	public void mensajeNoCompletoReco(){
		JOptionPane.showMessageDialog(this, "Ocurrió un problema. Puede que no se hayan generado todas las recomendaciones");
	}

	@SuppressWarnings("unchecked")
	public void setLista(String recomendacion)
	{
		modelListaRecomendaciones.addElement(recomendacion);
	}

	public boolean getCbManiana()
	{
		return cbManiana.isSelected();
	}

	public boolean getCbTarde()
	{
		return cbTarde.isSelected();
	}

	public boolean getCbNoche()
	{
		return cbNoche.isSelected();
	}
	
	public boolean puedeEsperar()
	{
		return cbPuedeEsperar.isSelected();
	}
	
	public void update(Observable o, Object arg)
	{
		try
		{
			mostrarRecos();
		} catch (Exception e)
		{
			System.out.println("ERROR AL MOSTRAR LAS RECO GENERADAS!!!");
			e.printStackTrace();
		}
	}

	public GRCModel getModelo()
	{
		return this.model;
	}

	public void mostrarRecos() throws Exception
	{
		DefaultListModel modeloList = new DefaultListModel();
		ArrayList<String> recomendaciones = controller.getRecomendaciones();
		for (int i = 0; i < recomendaciones.size(); i++)
		{
			modeloList.addElement(recomendaciones.get(i));
		}
		listaRecomendaciones.setModel(modeloList);
		
		if(!this.model.isFinishRecomendacionOK()){
			mensajeNoCompletoReco();
		}
	}
	
	public DefaultTableModel getTablaDias()
	{
		return (DefaultTableModel) tablaDias.getModel();
	}

	public void actionPerformed(ActionEvent e)
	{
	}
	
	public void borrarValores(DefaultTableModel tablaDias)
	{

		/*for (int i = 0; i < tablaDias.getRowCount(); i++)
		{
		      for(int j = 1; j < tablaDias.getColumnCount(); j++) 
		      {
		    	  tablaDias.setValueAt("", i, j);
		      }
		}*/
		   
		
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
	}
}
