package com.sistemaSolar.climaAPI.domain.factories.factoryImpl;

import com.sistemaSolar.climaAPI.domain.clima.PlanetaNombre;
import com.sistemaSolar.climaAPI.domain.entidad.Planeta;
import com.sistemaSolar.climaAPI.domain.factories.factory.PlanetaFactory;

public class SolFactory implements PlanetaFactory {
	
    public static final int SOL_VELOCIDAD_ANGULAR = 0;
    public static final Double SOL_POSICION = 0.0;

	@Override
	public Planeta ConstruirPlaneta() {
		return new Planeta(PlanetaNombre.SOL.getValue(), SOL_VELOCIDAD_ANGULAR, SOL_POSICION);
	}

	@Override
	public Planeta ConstruirPlaneta(String nombre,
			int velocidadAngular, double distanciaDesdeSol) {
		return new Planeta(nombre, velocidadAngular, distanciaDesdeSol);
	}

}
