package com.sistemaSolar.climaAPI.domain.entidad;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

import org.apache.log4j.Logger;



public class SistemaSolar implements Iterable<Planeta> {
	
	final static Logger logger = Logger.getLogger(SistemaSolar.class);
	
	static SistemaSolar sistemaSolar;
	
	private List<Planeta> planetas;
	
	 /** 
	  * La instancia SistemaSolar se crea sólo cuando se llama por primera vez. 
	  * */
	 public synchronized static SistemaSolar getSistemaSolar() {
	        if (sistemaSolar == null) {
	            sistemaSolar = new SistemaSolar();
	        }
	        return sistemaSolar;
	    }
	 
	 public SistemaSolar() {
	        planetas = new LinkedList<>();
	    }
	 
	 public void addPlanets(Planeta planeta) {
	     if (planeta != null && !planetas.contains(planeta)) {
	         planetas.add(planeta);
	     }
	 }
	 
	 public boolean isContains(Planeta planeta) {
	        return planetas.contains(planeta);
	    }

	@Override
	public Iterator<Planeta> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
    @Override
    public void forEach(Consumer<? super Planeta> action) {

    }

    @Override
    public Spliterator<Planeta> spliterator() {
        return null;
    }

	public static void setSistemaSolar(SistemaSolar sistemaSolar) {
		SistemaSolar.sistemaSolar = sistemaSolar;
	}

	public List<Planeta> getPlanetas() {
		return planetas;
	}

	public void setPlanetas(List<Planeta> planetas) {
		this.planetas = planetas;
	}

}
