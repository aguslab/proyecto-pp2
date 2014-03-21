package com.laboratorio.combinator;

public class Turno {
	
	private int horaInicio;
	private int horaFin;
	
	public Turno(String turno){
		 if(turno.equals("M")){
			 this.horaInicio = 8;
			 this.horaFin = 13;
		 }else if(turno.equals("T")){
			 this.horaInicio = 13;
			 this.horaFin = 18;
		 }else{
			 this.horaInicio = 18;
			 this.horaFin = 22;
		 }
		 
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	
	
}
