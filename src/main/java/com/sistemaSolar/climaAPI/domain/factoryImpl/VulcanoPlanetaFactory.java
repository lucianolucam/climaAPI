package com.sistemaSolar.climaAPI.domain.factoryImpl;

import com.sistemaSolar.climaAPI.domain.clima.PlanetaNombre;
import com.sistemaSolar.climaAPI.domain.entidad.Planeta;
import com.sistemaSolar.climaAPI.domain.factory.PlanetaFactory;

public class VulcanoPlanetaFactory implements PlanetaFactory {
	
	public static final int VULCANOO_VELOCIDAD_ANGULAR = 5;
    public static final Double VULCANOO_POSICION = 1000.0;

	@Override
	public Planeta ConstruirPlaneta() {
		return new Planeta(PlanetaNombre.VULCANOO.getValue(),VULCANOO_VELOCIDAD_ANGULAR, VULCANOO_POSICION);
	}

	@Override
	public Planeta ConstruirPlaneta(String nombre,
			int velocidadAngular, double distanciaDesdeSol) {
		return new Planeta(nombre, velocidadAngular, distanciaDesdeSol);
	}

}
