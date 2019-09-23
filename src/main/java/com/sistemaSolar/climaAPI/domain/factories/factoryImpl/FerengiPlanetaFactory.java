package com.sistemaSolar.climaAPI.domain.factories.factoryImpl;

import com.sistemaSolar.climaAPI.domain.clima.PlanetaNombre;
import com.sistemaSolar.climaAPI.domain.entidad.Planeta;
import com.sistemaSolar.climaAPI.domain.factories.factory.PlanetaFactory;

public class FerengiPlanetaFactory implements PlanetaFactory {
	
    public static final int FERENGI_VELOCIDAD_ANGULAR = -1;
    public static final Double FERENGI_POSICION = 500.0;

	@Override
	public Planeta ConstruirPlaneta() {
		return new Planeta(PlanetaNombre.FERENGI.getValue(), FERENGI_VELOCIDAD_ANGULAR, FERENGI_POSICION);
	}

	@Override
	public Planeta ConstruirPlaneta(String nombre,
			int velocidadAngular, double distanciaDesdeSol) {
		return new Planeta(nombre, velocidadAngular, distanciaDesdeSol);
	}

}
