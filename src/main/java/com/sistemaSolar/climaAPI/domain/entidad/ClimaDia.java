package com.sistemaSolar.climaAPI.domain.entidad;

public class ClimaDia {
	
	public int dia;
	public String descripcion;
	
	/**Se usa en el controller para devolver un objeto que solo tenga los valores del día y el tipo de clima */
	public ClimaDia (int dia, String descripcion){
		super();
		this.dia = dia;
		this.descripcion = descripcion;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
