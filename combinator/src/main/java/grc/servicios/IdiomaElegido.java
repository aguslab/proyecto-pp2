package grc.servicios;

import java.util.Locale;
import java.util.ResourceBundle;

public class IdiomaElegido
{
	private ResourceBundle idiomaMsjs;
	private String idiomaActual;
	private static final String ESPAÑOL = "es";
	private static final String INGLES = "en";

	public IdiomaElegido()
	{
		this.idiomaMsjs = ResourceBundle.getBundle("MensajesINFO");
		this.idiomaActual = ESPAÑOL;
	}

	public ResourceBundle getIdiomaMsjs()
	{
		return idiomaMsjs;
	}

	public void cambiarIdiomaMsjs()
	{
		if(this.idiomaActual.equals(ESPAÑOL)){
			this.idiomaMsjs = ResourceBundle.getBundle("MensajesINFO", Locale.ENGLISH);
			this.idiomaActual = INGLES;
		}else if(this.idiomaActual.equals(INGLES)){
			this.idiomaMsjs = ResourceBundle.getBundle("MensajesINFO");
			this.idiomaActual = ESPAÑOL;
		}
			
	}
}
