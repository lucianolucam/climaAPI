package com.sistemaSolar.climaAPI.domain.entidad;

import java.util.List;

/**Se usa en controller para mostrar los dias mas lluviosos */
public class DiasLluviosos {
	
	public String descripcion;
	public List<Integer> dias;
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Integer> getDias() {
		return dias;
	}
	public void setDias(List<Integer> dias) {
		this.dias = dias;
	}

}
