package com.sistemaSolar.climaAPI.rest.service;

import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.sistemaSolar.climaAPI.domain.clima.PlanetaNombre;
import com.sistemaSolar.climaAPI.domain.clima.TipoClima;
import com.sistemaSolar.climaAPI.domain.entidad.InfoClima;
import com.sistemaSolar.climaAPI.domain.entidad.Planeta;
import com.sistemaSolar.climaAPI.domain.entidad.SistemaSolar;
import com.sistemaSolar.climaAPI.domain.factoryImpl.BetasoidePlanetaFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.FerengiPlanetaFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.SolFactory;
import com.sistemaSolar.climaAPI.domain.factoryImpl.VulcanoPlanetaFactory;
import com.sistemaSolar.climaAPI.rest.repositorio.PronosticoRepositorio;

@Component
public class Pronostico implements ApplicationRunner {
	
	public PronosticoRepositorio pronosticoRepositorio;
	public SistemaSolar sistemaSolar;
	private List<Planeta> planetas;
	
	 final static Logger logger = Logger.getLogger(Pronostico.class);
	 public static final String PRONOSTICO_NOTIFICACION = "El sistema solar experimenta un periodo de ";
	 public static final String ALINEACION_SOLAR = "Planetas alineados con el sol en el día: ";
	 public static final String ALINEACION_PLANETARIA = "Planetas alineados entre si en el día: ";
	 public static final String SOL_ENCERRADO = "El sol es encerrado por los planetas en el día: ";
	 public static final String MAX_LLUVIA = "Lluvia máxima: ";
	 public static final int DIAS_DEL_ANO = 360;
	
    @Autowired
	public Pronostico (PronosticoRepositorio pronosticoRepositorio){
		this.pronosticoRepositorio = pronosticoRepositorio;
		logger.debug("Inicializar Predicción del tiempo");
		inicializarPlanetas();
		inicializarSistemaSolar();
		logger.debug("Predicción del tiempo inicializada");
	}
    
    public Pronostico(){
    	logger.debug("Inicializar Predicción del tiempo");
		inicializarPlanetas();
		inicializarSistemaSolar();
		logger.debug("Predicción del tiempo inicializada");
    }
    
    private void inicializarPlanetas(){
    	logger.debug("inicializando Planetas");
    	planetas = new LinkedList<>();
    	
    	Planeta betasoide = Planeta.crearPlaneta(new BetasoidePlanetaFactory());
    	Planeta ferengi = Planeta.crearPlaneta(new FerengiPlanetaFactory());
    	Planeta vulcano = Planeta.crearPlaneta(new VulcanoPlanetaFactory());
    	Planeta sol = Planeta.crearPlaneta(new SolFactory());
    	
    	planetas.add(betasoide);
    	planetas.add(ferengi);
    	planetas.add(vulcano);
    	planetas.add(sol);
    	logger.debug("Planetas inicializados");
    }
    
    private void inicializarSistemaSolar(){
    	logger.debug("inicializando Sistema Solar");
    	sistemaSolar = SistemaSolar.getSistemaSolar();
    	Validate.notNull(planetas, "Los planetas no pueden ser nulos");
    	sistemaSolar.setPlanetas(planetas);
    	logger.debug("Sistema Solar inicializado");
    }
    
    /**Calcula el clima para un día y lo guarda en la DB */
    private void CalcularClima(Point2D betasoidePosicion, Point2D ferengiPosicion,
            Point2D vulcanoPosicion, Point2D solPosicion, int dia) {
    	InfoClima infoClima = new InfoClima(dia);
    	if (estanAlineados(betasoidePosicion, ferengiPosicion, vulcanoPosicion)) {
    		if (estanAlineados(betasoidePosicion, ferengiPosicion, solPosicion)) {
    			infoClima.setTipoClima(TipoClima.SEQUIA);
    			logger.debug(ALINEACION_SOLAR + dia);
    			logger.debug(PRONOSTICO_NOTIFICACION + TipoClima.SEQUIA.getValue());
    		} else {
    			infoClima.setTipoClima(TipoClima.CONDICIONES_OPTIMAS);
    			logger.debug(ALINEACION_PLANETARIA + dia);
    			logger.debug(TipoClima.CONDICIONES_OPTIMAS.getValue());
    		}
    	} else if (solDentroDeTriangulo(betasoidePosicion, ferengiPosicion, vulcanoPosicion, solPosicion)) {
    		infoClima.setTipoClima(TipoClima.LLUVIA) ;
    		infoClima.setPrecipitacion(calcularPerimetro(betasoidePosicion, ferengiPosicion, vulcanoPosicion));
    		logger.debug(SOL_ENCERRADO + dia);
    		logger.debug(PRONOSTICO_NOTIFICACION + TipoClima.LLUVIA.getValue());
    	} else {
    		infoClima.setTipoClima(TipoClima.SINDEFINIR);
    		logger.debug(dia + " " + TipoClima.SINDEFINIR.getValue());
    	}
    	pronosticoRepositorio.save(infoClima);
    }
    
    /**Metodo que simula el paso de los años del sistema */
    public void SimulacionSistemaSolar (int anos){
    	logger.debug("iniciando simulacion sistema solar");
    	Validate.notNull(sistemaSolar, "El sistema solar no puede ser nulo");
    	List<Planeta> planetasPosicion = sistemaSolar.getPlanetas();
    	Point2D betasoidePosicion = null;
        Point2D ferengiPosicion = null;
        Point2D vulcanoPosicion = null;
        Point2D solPosicion = null;
        int dia = 1;
        for (dia = 1; dia <= (anos * DIAS_DEL_ANO); dia++){
        	for (Planeta planeta : planetasPosicion){
        		if (planeta.getNombre().equalsIgnoreCase(PlanetaNombre.BETASOIDE.getValue())){
        			betasoidePosicion = planeta.calcularPosicion(dia);
        		} else if (planeta.getNombre().equalsIgnoreCase(PlanetaNombre.FERENGI.getValue())){
        			ferengiPosicion = planeta.calcularPosicion(dia);
        		} else if (planeta.getNombre().equalsIgnoreCase(PlanetaNombre.VULCANOO.getValue())){
        			vulcanoPosicion = planeta.calcularPosicion(dia);
        		} else {
        			solPosicion = planeta.calcularPosicion(dia);
        		}
        	}
        	CalcularClima(betasoidePosicion, ferengiPosicion, vulcanoPosicion, solPosicion, dia);
        }
        logger.debug("fin sumalacion sistema solar");
    }
    
    /**Comprueba si 3 puntos están alineados de manera vertical, horizontal o en diagonal */
    public boolean estanAlineados(Point2D planeta1Posicion, Point2D planeta2Posicion, Point2D planeta3Posicion) {
        if ((planeta1Posicion.getX() == planeta2Posicion.getX() && planeta2Posicion.getX() == planeta3Posicion.getX()) ) {
            return true;
        } else if ((planeta1Posicion.getY() == planeta2Posicion.getY() && planeta2Posicion.getY() == planeta3Posicion.getY())) {
            return true;
        } else if ( calcularPendiente(planeta1Posicion,planeta2Posicion) == calcularPendiente(planeta2Posicion,planeta3Posicion) &&
        		calcularPendiente(planeta2Posicion,planeta3Posicion) == calcularPendiente(planeta1Posicion,planeta3Posicion)) {
        	return true;
        } else {
        	return false;	
        }
    }
    
    /** comprueba que el sol esté dentro del triángulo
     */
    private boolean solDentroDeTriangulo(Point2D planetaA, Point2D planetaB, Point2D planetaC, Point2D planetaD) {
 
    	 double posOriginal = ( (planetaA.getX()-planetaC.getX()) * (planetaB.getY()-planetaC.getY() ) - ( (planetaB.getX()-planetaC.getX()) * (planetaA.getY()-planetaC.getY()) ) );
    	 double posACD = ( ( planetaA.getX()-planetaC.getX() ) * ( planetaD.getY()-planetaC.getY() ) ) - ( ( planetaA.getY()-planetaC.getY()) * (planetaD.getY()-planetaC.getY() ) );
    	 double posBAD = ( ( planetaB.getX()-planetaA.getX() ) * ( planetaD.getY()-planetaA.getY() ) ) - ( ( planetaB.getY()-planetaA.getY()) * (planetaD.getY()-planetaA.getY() ) );
    	 double posCBD = ( ( planetaC.getX()-planetaB.getX() ) * ( planetaD.getY()-planetaB.getY() ) ) - ( ( planetaC.getY()-planetaB.getY()) * (planetaD.getY()-planetaB.getY() ) );
    	 
    	 return posOriginal * posACD > 0 && posOriginal * posBAD > 0 && posOriginal * posCBD > 0;
    }
    
    /** Calcula la pendiente entre 2 puntos*/
    private double calcularPendiente (Point2D planetaA, Point2D planetaB){
    	return Math.round( (planetaB.getY()-planetaA.getY()) / (planetaB.getX()-planetaA.getX()) );
    }
    
    /**Calcula el perimetro de un triangulo */
    private Long calcularPerimetro (Point2D planetaA, Point2D planetaB, Point2D planetaC){
    	double distanciaPlanetaAB = distancia(planetaA, planetaB);
    	double distanciaPlanetaBC = distancia(planetaB, planetaC);
    	double distanciaPlanetaCA = distancia(planetaC, planetaA);
    	
    	return Math.round(distanciaPlanetaAB + distanciaPlanetaBC + distanciaPlanetaCA);
    }
    
    /**Calcula la distancia entre 2 puntos (lado de un triangulo) */
    private double distancia(Point2D posicionA, Point2D posiciontB){
    	return Math.sqrt(Math.pow(posiciontB.getX() - posicionA.getX(), 2) +
                Math.pow(posiciontB.getY() - posicionA.getY(), 2));
    }
    
  

	@Override
	public void run(ApplicationArguments args) throws Exception {
		SimulacionSistemaSolar(10);
	}

}
