package com.sistemaSolar.climaAPI.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistemaSolar.climaAPI.domain.clima.TipoClima;
import com.sistemaSolar.climaAPI.domain.entidad.ClimaDia;
import com.sistemaSolar.climaAPI.domain.entidad.DiasLluviosos;
import com.sistemaSolar.climaAPI.domain.entidad.InfoClima;
import com.sistemaSolar.climaAPI.domain.entidad.Periodo;
import com.sistemaSolar.climaAPI.rest.repositorio.PronosticoRepositorio;

@Controller
@RequestMapping("/api")
public class PronosticoController {
	
	private PronosticoRepositorio pronosticoRepositorio;
	
	@Autowired
	public PronosticoController (PronosticoRepositorio pronosticoRepositorio){
		this.pronosticoRepositorio = pronosticoRepositorio;
	}
	
	@GetMapping("/clima")
    @ResponseBody
    public ClimaDia infoClimaPorDia(@RequestParam(name = "dia", required = true, defaultValue = "0") int dia) {
        Optional<InfoClima> InfoClima = pronosticoRepositorio.findById(dia);
        String descripcion = "desconocido";
        if (InfoClima.isPresent()) {
        	descripcion = InfoClima.get().getTipoClima().getValue();
        } else {
        	descripcion = "día impredecible";
        }
        return new ClimaDia(dia, descripcion);
    }
	
	@GetMapping("/periodos-sequia")
    @ResponseBody
    public Periodo periodosDeSequia() {
		Periodo periodo = new Periodo();
		periodo.setCantidad(pronosticoRepositorio.periodosDeSequia()); 
		periodo.setPeriodo(TipoClima.SEQUIA.getValue());
        return periodo;
    }

    @GetMapping("/periodos-lluvia")
    @ResponseBody
    public Periodo periodosDeLluvia() {
    	Periodo periodo = new Periodo();
    	periodo.setCantidad(pronosticoRepositorio.periodosDeLluvia());
    	periodo.setPeriodo(TipoClima.LLUVIA.getValue());
        return periodo;
    }

    @GetMapping("/periodos-optimas-condiciones")
    @ResponseBody
    public Periodo periodosDeCondicionesOptimas() {
    	Periodo periodo = new Periodo();
    	periodo.setCantidad(pronosticoRepositorio.periodosDeCondicionesOptimas());
    	periodo.setPeriodo(TipoClima.CONDICIONES_OPTIMAS.getValue());
    	return periodo;
    }


    @GetMapping("/maxima-intensidad-lluvia")
    @ResponseBody
    public DiasLluviosos periodosDeLluviaIntensa() {
    	DiasLluviosos diasMasLluviosos = new DiasLluviosos();
    	diasMasLluviosos.setDescripcion("Los diás más lluviosos fueron");
    	diasMasLluviosos.setDias(pronosticoRepositorio.periodosMasLluviosos()); 
        return diasMasLluviosos;
    }

}
