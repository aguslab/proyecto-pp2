package grc.vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class CeldaPersonalizada extends DefaultTableCellRenderer
{
	private static final long serialVersionUID = 1L;

public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column)
   {
      super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
      if ( !value.toString().equals("")) //Si hay texto en alguna celda, pongo un color
      {
          this.setOpaque(true);
          //TODAS LAS COLUMNAS CON COLORES DISTINTOS
           if (column == 1)
    	         this.setBackground(Color.ORANGE);
    	  else if (column == 2)
    		  this.setBackground(Color.CYAN);
    	  else if (column == 3)
    		  this.setBackground(Color.GREEN);
    	  else if (column == 4)
    		  this.setBackground(Color.PINK);
    	  else if (column == 5)
    		  this.setBackground(Color.LIGHT_GRAY);
    	  else if (column == 6)
    		  this.setBackground(Color.MAGENTA);
    	  else
    		  this.setBackground(table.getBackground()); //Columna con horas queda con fondo original
          
          this.setForeground(Color.BLACK); //para evitar que, al hacer click, la fuente se vuelva blanca
      } 
      else 
    	  this.setBackground(table.getBackground()); //Si no hay texto en las celdas dejo el fondo original.
      return this;
   }
}