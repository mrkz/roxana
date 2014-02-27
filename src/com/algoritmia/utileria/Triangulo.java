package com.algoritmia.utileria;

/**
 * @version 1.0
 * @author seguame
 *
 *Los triangulos pueden separar por secciones  el mapa, creando sectores que
 *despues puedan ser tratados por los fractales, dando variedad a la organizacion
 *de la ciudad 
 */


public class Triangulo 
{
	private Punto verticeA;
	private Punto verticeB;
	private Punto verticeC;
	
	private Recta ladoA;
	private Recta ladoB;
	private Recta ladoC;
	
	public Triangulo(Punto verticeA, Punto verticeB, Punto verticeC)
	{
		this.verticeA = verticeA;
		this.verticeB = verticeB;
		this.verticeC = verticeC;
		
		generarRectas();
	}
	
	private void generarRectas()
	{
		ladoA = new Recta(verticeB, verticeC);
		ladoB = new Recta(verticeA, verticeC);
		ladoC = new Recta(verticeA, verticeB);
	}

	public Punto getVerticeA() 
	{
		return verticeA;
	}

	public Punto getVerticeB() 
	{
		return verticeB;
	}

	public Punto getVerticeC() 
	{
		return verticeC;
	}

	public Recta getLadoA() 
	{
		return ladoA;
	}

	public Recta getLadoB() 
	{
		return ladoB;
	}

	public Recta getLadoC() 
	{
		return ladoC;
	}
}