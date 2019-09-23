package com.sistemaSolar.climaAPI.domain.entidad;

import java.awt.geom.Point2D;

import org.apache.commons.lang3.Validate;
import org.apache.commons.math3.util.Precision;

import com.sistemaSolar.climaAPI.domain.factories.factory.PlanetaFactory;


public class Planeta {
	
    private String nombre;
    private int velocidadAngular; // velocidad angular
    private double velocidadAngularRad; // velocidad angular en radianes
    private Point2D posicion;
    private double distanciaDesdeSol;// radianes
    
    public Planeta(final String nombre, final int velocidadAngular, final double distanciaDesdeSol) {
        Validate.notNull(nombre);
        Validate.notNull(velocidadAngular);
        Validate.notNull(distanciaDesdeSol);

        this.nombre = nombre;
        this.velocidadAngular = velocidadAngular;
        this.velocidadAngularRad = Math.toRadians(velocidadAngular);
        this.distanciaDesdeSol = distanciaDesdeSol;
        this.posicion = new Point2D.Double(distanciaDesdeSol, 0.0);
    }
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVelocidadAngular() {
		return velocidadAngular;
	}
	public void setVelocidadAngular(int velocidadAngular) {
		this.velocidadAngular = velocidadAngular;
	}
	public double getVelocidadAngularRad() {
		return velocidadAngularRad;
	}
	public void setVelocidadAngularRad(double velocidadAngularRad) {
		this.velocidadAngularRad = velocidadAngularRad;
	}
	public Point2D getPosicion() {
		return posicion;
	}
	public void setPosicion(Point2D posicion) {
		this.posicion = posicion;
	}
	public double getDistanciaDesdeSol() {
		return distanciaDesdeSol;
	}
	public void setDistanciaDesdeSol(double distanciaDesdeSol) {
		this.distanciaDesdeSol = distanciaDesdeSol;
	}
	
    public double getX() {
        return this.posicion.getX();
    }

    public double getY() {
        return this.posicion.getY();
    }
    
  
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planeta planeta = (Planeta) o;

        if (velocidadAngular != planeta.velocidadAngular) return false;
        if (Double.compare(planeta.distanciaDesdeSol, distanciaDesdeSol) != 0) return false;
        if (nombre != null ? !nombre.equals(planeta.nombre) : planeta.nombre != null) return false;
        return posicion != null ? posicion.equals(planeta.posicion) : planeta.posicion == null;
    }
    
    @Override
    public int hashCode() {
        int resultado;
        long temp;
        resultado = nombre != null ? nombre.hashCode() : 0;
        resultado = 31 * resultado + velocidadAngular;
        resultado = 31 * resultado + (posicion != null ? posicion.hashCode() : 0);
        temp = Double.doubleToLongBits(distanciaDesdeSol);
        resultado = 31 * resultado + (int) (temp ^ (temp >>> 32));
        return resultado;
    }
    
    @Override
    public String toString() {
        return "PlanetaNombre{" +
                "nombre='" + nombre + '\'' +
                ", velocidadAngular=" + velocidadAngular +
                ", posicion=" + posicion +
                ", distanciaDesdeSol=" + distanciaDesdeSol +
                '}';
    }
    
    /**Calcula la posicion(x,y) de un planeta para un dia dado  */
    public Point2D calcularPosicion(int dia) {
        Validate.notNull(dia > 0);
        Validate.isTrue(dia > 0);

        double theta = this.velocidadAngular * dia;
        double radios = this.getDistanciaDesdeSol();
        double xAxis = Precision.round(radios * Math.cos(theta), 12);
        double yAxis = Precision.round(radios * Math.sin(theta), 12);
        return new Point2D.Double(xAxis, yAxis);
    }
    
    public static Planeta crearPlaneta(PlanetaFactory factory) {
        Validate.notNull(factory);
        return factory.ConstruirPlaneta();
    }

}
