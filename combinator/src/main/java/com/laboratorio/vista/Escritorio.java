package com.laboratorio.vista;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;



@SuppressWarnings("serial")
public class Escritorio extends JWindow
{

	private Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Escritorio()
	{

		JLabel lbImage    = new JLabel ();
		JLabel lblVersion = new JLabel ("Versión");
		Color cl = new Color (0, 0, 0);
		lbImage.setBorder (new LineBorder (cl, 0));
		lblVersion.setFont(new Font("Arial", Font.PLAIN, 24));
		lblVersion.setBounds(350, 10, 150, 60);

	    getContentPane().add(lblVersion);
		getContentPane().add (lbImage, BorderLayout.CENTER);
		pack();

		setSize (getSize().width, getSize().height);
		setLocation (pantalla.width / 2 - getWidth() / 2, pantalla.height / 2 - getHeight() / 2);

		this.setVisible(true);
		new Prototipo();

		toFront();
		dispose ();
		setVisible (false);

	}

	public static void main (String args[]) 
	{
		new Escritorio ();
	}
    
}
