package com.sistemaSolar.climaAPI.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sistemaSolar.climaAPI.domain.entidad.ClimaDia;
import com.sistemaSolar.climaAPI.domain.entidad.InfoClima;
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
    public Long periodosDeSequia() {
		Long periodosSequia = pronosticoRepositorio.periodosDeSequia();
        return periodosSequia;
    }

    @GetMapping("/periodos-lluvia")
    @ResponseBody
    public Long periodosDeLluvia() {
    	Long periodosLluvia = pronosticoRepositorio.periodosDeLluvia();
        return periodosLluvia;
    }

    @GetMapping("/periodos-optimas-condiciones")
    @ResponseBody
    public Long periodosDeCondicionesOptimas() {
        Long periodosOptimos = pronosticoRepositorio.periodosDeCondicionesOptimas();
    	return periodosOptimos;
    }


    @GetMapping("/maxima-intensidad-lluvia")
    @ResponseBody
    public List<Integer> periodosDeLluviaIntensa() {
    	List<Integer> diasMasLluviosos = pronosticoRepositorio.periodosMasLluviosos();
        return diasMasLluviosos;
    }

}
