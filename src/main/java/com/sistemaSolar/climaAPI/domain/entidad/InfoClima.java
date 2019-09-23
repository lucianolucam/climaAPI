package com.sistemaSolar.climaAPI.domain.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sistemaSolar.climaAPI.domain.clima.TipoClima;

@Entity
@Table(name = "info_clima")
public class InfoClima {
	
    @Id
    @Column(name = "dia")
    private Integer dia;

    @Column(name = "tipo_clima")
    @Enumerated(EnumType.STRING)
    private TipoClima tipoClima;

    @Column(name = "precipitacion", precision = 10, scale = 2, nullable = true)
    private Long precipitacion;
    
    public InfoClima(){}
    
    public InfoClima(Integer dia){
    	this.dia = dia;
    	this.tipoClima = null;
    	this.precipitacion = new Long(0);
    }
    
    public InfoClima(Integer dia, TipoClima tipoClima, Long perimetro){
    	this.dia = dia;
    	this.tipoClima = tipoClima;
    	this.precipitacion = perimetro;
    }

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public TipoClima getTipoClima() {
		return tipoClima;
	}

	public void setTipoClima(TipoClima tipoClima) {
		this.tipoClima = tipoClima;
	}

	public Long getPrecipitacion() {
		return precipitacion;
	}

	public void setPrecipitacion(Long precipitacion) {
		this.precipitacion = precipitacion;
	}


}
