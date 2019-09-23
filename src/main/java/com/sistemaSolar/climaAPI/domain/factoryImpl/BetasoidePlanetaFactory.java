package com.sistemaSolar.climaAPI.domain.factoryImpl;

import com.sistemaSolar.climaAPI.domain.clima.PlanetaNombre;
import com.sistemaSolar.climaAPI.domain.entidad.Planeta;
import com.sistemaSolar.climaAPI.domain.factory.PlanetaFactory;

public class BetasoidePlanetaFactory implements PlanetaFactory {
	
    public static final int BETASOIDE_VELOCIDAD_ANGULAR = -3;
    public static final Double BETASOIDE_POSICION = 2000.0;

	@Override
	public Planeta ConstruirPlaneta() {
		return new Planeta(PlanetaNombre.BETASOIDE.getValue(), BETASOIDE_VELOCIDAD_ANGULAR, BETASOIDE_POSICION);
	}

	@Override
	public Planeta ConstruirPlaneta(String nombre,
			int velocidadAngular, double distanciaDesdeSol) {
		return new Planeta(nombre,velocidadAngular, distanciaDesdeSol);
	}

}
