package com.sistemaSolar.climaAPI.domain.factories.factory;

import com.sistemaSolar.climaAPI.domain.entidad.Planeta;


public interface PlanetaFactory {
	
	public abstract Planeta ConstruirPlaneta();
	
	public abstract Planeta ConstruirPlaneta(final String nombre, final int velocidadAngular, final double distanciaDesdeSol);

}
