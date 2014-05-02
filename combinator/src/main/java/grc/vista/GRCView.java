package grc.vista;

import grc.controlador.GRCController;
import grc.modelo.Modelo;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class GRCView extends JFrame implements Observer, ActionListener
{
	private Modelo model;
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
	private JLabel firma;
	private JLabel materia;
	private JTable tablaAprobadas;
	DefaultListModel modelListaRecomendaciones;
	JList listaRecomendaciones;
	DefaultTableModel modeloTablaDias;

	public GRCView(Modelo model, final GRCController controller) throws Exception
	{
		super("Recomendaciones de materias a cursar");
		this.model = model;
		this.controller = controller;
		controller.setVista(this);

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
		setVisible(true);
		final JTabbedPane tabOpciones = new JTabbedPane(JTabbedPane.LEFT);
		tabOpciones.setBounds(10, 11, 772, 474);
		getContentPane().add(tabOpciones);

		modeloTablaDias = new DefaultTableModel();

		// Tabla Recomendaciones
		JPanel panelRecomendaciones = new JPanel();
		panelRecomendaciones.setBorder(new LineBorder(new Color(0, 0, 0)));
		tabOpciones.addTab("Recomendaciones ", new ImageIcon(""), panelRecomendaciones, null);
		panelRecomendaciones.setLayout(null);

		JScrollPane spRecomendacion = new JScrollPane();
		spRecomendacion.setEnabled(false);
		spRecomendacion.setBounds(10, 241, 1125, 319);
		panelRecomendaciones.add(spRecomendacion);
		final JTable tablaDias = new JTable(modeloTablaDias);
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
		tablaDias.getColumnModel().getColumn(0).setPreferredWidth(248);
//		tablaDias.setModel(new DefaultTableModel(
//			new Object[][] {
//				{"Lunes", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{"Martes", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{"Miercoles", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{"Jueves", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{"Viernes", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//				{"Sabado", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
//			},
//			new String[] {
//				"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"
//			}
//		));
		tablaDias.setRowHeight(25);
		tablaDias.getTableHeader().setReorderingAllowed(false);
		
		JLabel lblHorarios = new JLabel("Horarios:");
		lblHorarios.setBounds(10, 11, 74, 14);
		panelRecomendaciones.add(lblHorarios);

		JLabel lblManiana = new JLabel("Ma\u00F1ana");
		lblManiana.setBounds(85, 11, 57, 14);
		panelRecomendaciones.add(lblManiana);

		cbManiana = new JCheckBox("");
		cbManiana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("filtro mañanaaaaa");
				controller.cambioFiltros(getCbManiana(), "M");
			}
		});
		cbManiana.setBounds(131, 7, 21, 23);
		cbManiana.setSelected(true);
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
				controller.cambioFiltros(getCbTarde(), "T");
			}
		});
		cbTarde.setBounds(208, 7, 21, 23);
		cbTarde.setSelected(true);
		panelRecomendaciones.add(cbTarde);

		JLabel lblNoche = new JLabel("Noche");
		lblNoche.setBounds(253, 11, 49, 14);
		panelRecomendaciones.add(lblNoche);

		cbNoche = new JCheckBox("");
		cbNoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("filtro nocheeeee");
				controller.cambioFiltros(getCbNoche(), "N");
			}
		});
		cbNoche.setBounds(293, 7, 21, 23);
		cbNoche.setSelected(true);
		panelRecomendaciones.add(cbNoche);

		JButton btnOk = new JButton(new ImageIcon("Imagenes/ok.png"));
		btnOk.setBounds(1145, 241, 24, 23);
		panelRecomendaciones.add(btnOk);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 1125, 169);
		panelRecomendaciones.add(scrollPane);

		modelListaRecomendaciones = new DefaultListModel();
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
					controller.borrarValores(tablaTempDias);
					try
					{
						tablaTempDias = controller.cambiarTablaDias(tablaTempDias, posElegida);
					} catch (Exception e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});

		// Tabla Materia aprobadas
		JPanel panelAprobadas = new JPanel();
		panelAprobadas.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelAprobadas.setLayout(null);

		tabOpciones.addTab("Materias aprobadas ", new ImageIcon(""), panelAprobadas, null);

		JScrollPane spAprobadas = new JScrollPane();
		spAprobadas.setBounds(10, 11, 1175, 549);
		panelAprobadas.add(spAprobadas);

		tablaAprobadas = new JTable();
		tablaAprobadas.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spAprobadas.setViewportView(tablaAprobadas);
		tablaAprobadas.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Materia",
				"Nota"})
		{
			Class[] columnTypes = new Class[]{String.class, String.class};
			public Class getColumnClass(int columnIndex)
			{
				return columnTypes[columnIndex];
			}
		});
		tablaAprobadas.getColumnModel().getColumn(0).setPreferredWidth(248);
		tablaAprobadas.getColumnModel().getColumn(1).setResizable(false);
		tablaAprobadas.getColumnModel().getColumn(1).setPreferredWidth(40);
		tablaAprobadas.setRowHeight(25);
		tablaAprobadas.getTableHeader().setReorderingAllowed(false);
		DefaultTableModel tablaTempAprobadas = (DefaultTableModel) tablaAprobadas.getModel();
		tablaTempAprobadas = controller.getMateriasAprobadas(tablaTempAprobadas);

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

		barraDeEstado.setLayout(new BorderLayout());
		barraDeEstado.add(materia, BorderLayout.WEST);
		barraDeEstado.add(firma, BorderLayout.EAST);

		escritorio.putClientProperty("JDesktopPane.dragMode", "outline");

		getContentPane().add(escritorio, BorderLayout.NORTH);
		getContentPane().add(barraDeEstado, BorderLayout.SOUTH);
		mostrarRecos();
		System.out.println("AAAAAAAAAAAAAAAAAAAA");
	}

	public void initVista() throws Exception
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

	public void update(Observable o, Object arg)
	{
		try
		{
			System.out.println("UPDATE DE LA VIEW");
			mostrarRecos();
		} catch (Exception e)
		{
			System.out.println("ERROR AL MOSTRAR LAS RECO GENERADAS!!!");
			e.printStackTrace();
		}
	}

	public Modelo getModelo()
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

	public void actionPerformed(ActionEvent e)
	{
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
	}
}
