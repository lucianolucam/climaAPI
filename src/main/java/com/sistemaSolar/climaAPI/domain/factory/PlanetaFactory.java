package com.sistemaSolar.climaAPI.domain.factory;

import com.sistemaSolar.climaAPI.domain.entidad.Planeta;


public interface PlanetaFactory {
	
	public abstract Planeta ConstruirPlaneta();
	
	public abstract Planeta ConstruirPlaneta(String nombre, int velocidadAngular, double distanciaDesdeSol);

}
