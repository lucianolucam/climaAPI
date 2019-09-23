package com.sistemaSolar.climaAPI.domain.clima;

public enum TipoClima {
	
    SEQUIA("SEQUIA"),
    LLUVIA("LLUVIA"),
    SINDEFINIR("SINDEFINIR"),
    CONDICIONES_OPTIMAS("CONDICIONES OPTIMAS");

    private final String valor;

    private TipoClima(String value) {
        this.valor = value;
    }

    public String getValue() {
        return valor;
    }

}
