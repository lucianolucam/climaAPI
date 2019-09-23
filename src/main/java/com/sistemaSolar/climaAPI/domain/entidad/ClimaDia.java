package com.sistemaSolar.climaAPI.domain.entidad;

public class ClimaDia {
	
	public int dia;
	public String clima;
	
	/**Se usa en el controller para devolver un objeto que solo tenga los valores del día y el tipo de clima */
	public ClimaDia (int dia, String descripcion){
		super();
		this.dia = dia;
		this.clima = descripcion;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

}
