package grc.vista;

import grc.controlador.GRCController;
import grc.modelo.GRCModel;
import grc.servicios.Recomendacion;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class GRCView extends JFrame implements Observer, ActionListener
{
	private final GRCController controller;
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
	
	public  GRCView(GRCController controlador, Set<String> ordenElegido ) throws Exception
	{
		super("Generador de Recomendaciones de Cursadas");
		this.controller = controlador;
		escritorio.setBounds(0, 0, 1317, 1);
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
			},
			new String[] {
			}
		));
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
				String recomendacionElegida = (String) listaRecomendaciones.getSelectedValue();
				controller.ordenarRecomendaciones((String)cbOrdenador.getSelectedItem());
				listaRecomendaciones.setSelectedValue(recomendacionElegida, true);
			}
		});
		cbOrdenador.setModel(new DefaultComboBoxModel(ordenElegido.toArray()));
		
		cbOrdenador.setBounds(253, 214, 125, 20);
		panelRecomendaciones.add(cbOrdenador);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		lblOrdenarPor.setBounds(175, 217, 74, 14);
		panelRecomendaciones.add(lblOrdenarPor);
		listaRecomendaciones.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (e.getValueIsAdjusting() == false)
				{
					DefaultTableModel tablaTempDias = (DefaultTableModel) tablaDias.getModel();
					int posElegida = listaRecomendaciones.getSelectedIndex();
					posElegida = posElegida != -1 ? posElegida : 0;
					controller.seleccionActualRecomendacion(posElegida);
				}
			}
		});
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
	
	public void mensajeNoCompletoReco() throws Exception{
		int reply = JOptionPane.showConfirmDialog(this,
				"Al parecer son muchas recomendaciones! Puede que aún no se hayan generado todas ¿Desea seguir esperando para verlas todas?", "Ha pasado demasiado tiempo",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (reply == JOptionPane.YES_OPTION)
		{
			this.setPuedeEsperar(true);
			controller.puedeEsperar(puedeEsperar());
			controller.filtrarTurnos();
		}
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
	
	private void setPuedeEsperar(boolean b)
	{
		this.cbPuedeEsperar.setSelected(true);
	}
	
	public void update(Observable obs, Object arg)
	{
		if(arg instanceof ArrayList)
		{
			try
			{
				mostrarRecomendaciones(obs);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if (arg instanceof Recomendacion)
		{
			try
			{
				tablaDias.setModel(controller.cambiarTablaDias((Recomendacion)arg));
				tablaDias.getColumnModel().getColumn(0).setPreferredWidth(5);
			} catch (Exception e1)
			{
				e1.printStackTrace();
			}
		}
	}

	public void mostrarRecomendaciones(Observable o) throws Exception
	{
		DefaultListModel modeloList = new DefaultListModel();
		ArrayList<String> recomendaciones = controller.getRecomendaciones();
		for (int i = 0; i < recomendaciones.size(); i++)
		{
			modeloList.addElement(recomendaciones.get(i));
		}
		listaRecomendaciones.setModel(modeloList);
		
		boolean generoTodaslasRecomendaciones = ((GRCModel) o).seCompletoLaGeneracionDeRecomendaciones();
		if(!generoTodaslasRecomendaciones)
		{
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
}
