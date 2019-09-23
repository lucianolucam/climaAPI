package com.sistemaSolar.climaAPI.domain.sistemaSolarTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.sistemaSolar.climaAPI.domain.clima.PlanetaNombre;
import com.sistemaSolar.climaAPI.domain.entidad.Planeta;
import com.sistemaSolar.climaAPI.domain.entidad.SistemaSolar;
import com.sistemaSolar.climaAPI.domain.factoryImpl.BetasoidePlanetaFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.FerengiPlanetaFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.SolFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.VulcanoPlanetaFactory;



public class SistemaSolarTest {
	
	final static Logger logger = Logger.getLogger(SistemaSolarTest.class);
	
	@Test
    public void addPlanets() {
		 	Planeta solPlaneta = Planeta.crearPlaneta(new SolFactory());
	        assertNotNull(solPlaneta);
	        assertEquals(PlanetaNombre.SOL.getValue(), ((Planeta) solPlaneta).getNombre());

	        Planeta betasoidePlaneta = Planeta.crearPlaneta(new BetasoidePlanetaFactory());
	        assertNotNull(betasoidePlaneta);
	        assertEquals(PlanetaNombre.BETASOIDE.getValue(), ((Planeta) betasoidePlaneta).getNombre());

	        Planeta ferengiPlaneta = Planeta.crearPlaneta(new FerengiPlanetaFactory());
	        assertNotNull(ferengiPlaneta);
	        assertEquals(PlanetaNombre.FERENGI.getValue(), ((Planeta) ferengiPlaneta).getNombre());

	        Planeta vulcanoPlaneta = Planeta.crearPlaneta(new VulcanoPlanetaFactory());
	        assertNotNull(vulcanoPlaneta);
	        assertEquals(PlanetaNombre.VULCANOO.getValue(), ((Planeta) vulcanoPlaneta).getNombre());

	        SistemaSolar sistemaSolar = SistemaSolar.getSistemaSolar();
	        assertNotNull(vulcanoPlaneta);

	        sistemaSolar.addPlanets((Planeta) betasoidePlaneta);
	        sistemaSolar.addPlanets((Planeta) ferengiPlaneta);
	        sistemaSolar.addPlanets((Planeta) vulcanoPlaneta);
	        sistemaSolar.addPlanets((Planeta) solPlaneta);


	        Iterator<Planeta> iterator =
	        		sistemaSolar.getPlanetas().iterator();

	        while (iterator.hasNext()) {
	            logger.debug("iterator " + iterator.next());
	        }
	}

}
