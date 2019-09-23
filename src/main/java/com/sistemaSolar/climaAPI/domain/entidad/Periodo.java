package com.sistemaSolar.climaAPI.domain.entidad;

/**Se usa en el controller para devolver el periodo y la cantidad */
public class Periodo {
	
	public String periodo;
	public Long cantidad;
	
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
}
