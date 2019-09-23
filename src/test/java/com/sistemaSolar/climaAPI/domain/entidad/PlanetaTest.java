package com.sistemaSolar.climaAPI.domain.entidad;

import org.junit.Test;



public class PlanetaTest {
	
	@Test(expected = NullPointerException.class)
    public void testPlanetTestInvalidCreation() {
		new Planeta(null,0,0.0);
	}
	
}
