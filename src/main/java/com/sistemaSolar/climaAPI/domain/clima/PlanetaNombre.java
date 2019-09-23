package com.sistemaSolar.climaAPI.domain.clima;

public enum PlanetaNombre {
	
	BETASOIDE("BETASOIDE"),
    FERENGI("FERENGI"),
    VULCANOO("VULCANOO"),
    SOL("SOL");

    private final String valor;

    private PlanetaNombre(String valor) {
        this.valor = valor;
    }

    public String getValue() {
        return valor;
    }

}
