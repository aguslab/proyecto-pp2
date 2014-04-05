package com.laboratorio.controlador;

import javax.swing.table.DefaultTableModel;

public class Receptor 
{
	public Receptor()
	{
		
	}
	
	public void cambiarTablaDias(DefaultTableModel tablaDias)
	{
		tablaDias.setValueAt("", 0, 0);
		tablaDias.setValueAt("", 0, 1);
		tablaDias.setValueAt("", 0, 2);
		tablaDias.setValueAt("", 0, 3);
		tablaDias.setValueAt("", 0, 4);
		tablaDias.setValueAt("", 0, 5);
	}
}
