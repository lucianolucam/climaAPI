package com.sistemaSolar.climaAPI.domain.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sistemaSolar.climaAPI.domain.clima.PlanetaNombre;
import com.sistemaSolar.climaAPI.domain.entidad.Planeta;
import com.sistemaSolar.climaAPI.domain.factoryImpl.BetasoidePlanetaFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.FerengiPlanetaFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.SolFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.VulcanoPlanetaFactory;





public interface PlanetaFactoryTest {
	
	final static Logger logger = Logger.getLogger(PlanetaFactoryTest.class);
	
	@Test
    public default void ConstruirPlaneta() {
		crearPlanetaPorDefault(new BetasoidePlanetaFactory());
		crearPlanetaPorDefault(new FerengiPlanetaFactory());
		crearPlanetaPorDefault(new VulcanoPlanetaFactory());
		crearPlanetaPorDefault(new SolFactory());
		
	}
	
    public static void crearPlanetaPorDefault(PlanetaFactory factory) {
        Planeta planeta = Planeta.crearPlaneta(factory);
        assertNotNull(planeta);
        logger.debug("El planeta " + planeta + " fue creado");
    }
    
    @Test
    public default  void ConstruirPlanetaCustom(){
    	crearPlaneta(new BetasoidePlanetaFactory(), PlanetaNombre.BETASOIDE.getValue());
    	crearPlaneta(new FerengiPlanetaFactory(), PlanetaNombre.FERENGI.getValue());
    	crearPlaneta(new VulcanoPlanetaFactory(), PlanetaNombre.VULCANOO.getValue());
    	crearPlaneta(new SolFactory(), PlanetaNombre.SOL.getValue());
    }
    
    public static void crearPlaneta(PlanetaFactory factory, String planetaNombre) {
    	if (planetaNombre.equalsIgnoreCase(PlanetaNombre.BETASOIDE.getValue())){
    		Planeta betasoide = factory.ConstruirPlaneta(planetaNombre, 1, 149.6);
    		assertNotNull(betasoide);
    		assertEquals(PlanetaNombre.BETASOIDE.getValue(), ((Planeta) betasoide).getNombre());
    		logger.debug("El planeta" + betasoide + " fue creado");
    	} else if (planetaNombre.equalsIgnoreCase(PlanetaNombre.FERENGI.getValue())){
    		Planeta ferengi = factory.ConstruirPlaneta(planetaNombre, 3, 227.9);
    		assertNotNull(ferengi);
    		assertEquals(PlanetaNombre.FERENGI.getValue(), ((Planeta) ferengi).getNombre());
    		logger.debug("El planeta" + ferengi + " fue creado");
    	} else if (planetaNombre.equalsIgnoreCase(PlanetaNombre.VULCANOO.getValue())){
    		Planeta vulcano = factory.ConstruirPlaneta(planetaNombre, 7, 778.5);
    		assertNotNull(vulcano);
    		assertEquals(PlanetaNombre.VULCANOO.getValue(), ((Planeta) vulcano).getNombre());
    		logger.debug("El planeta" + vulcano + " fue creado");
    	} else {
    		Planeta sol = factory.ConstruirPlaneta(planetaNombre, 0, 0.0);
    		assertNotNull(sol);
    		assertEquals(PlanetaNombre.SOL.getValue(), ((Planeta) sol).getNombre());
    		logger.debug("El planeta" + sol + " fue creado");
    	}
    }
    
}
