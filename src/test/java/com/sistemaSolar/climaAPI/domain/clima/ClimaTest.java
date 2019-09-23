package com.sistemaSolar.climaAPI.domain.clima;

import org.junit.Test;

import com.sistemaSolar.climaAPI.rest.service.Pronostico;
import static org.junit.Assert.assertNotNull;

public class ClimaTest {
	
	int anos = 10;
	
	@Test
    public void SimulacionSistemaSolar(){
		
		Pronostico pronostico = new Pronostico();
		assertNotNull(pronostico);
		pronostico.SimulacionSistemaSolar(anos);
	}
}
