package com.algoritmia.utileria;

/**
 * @version 1.0
 * @author seguame
 * 
 * Un punto en el mapa, determina la ubicacion de una entidad 
 * en el mapa de mosaicos
 */

//Se podria simplificar por razones de performance usando solo primitivas

public class Punto implements Comparable<Punto>
{
	private int x;
	private int y;
	
	
	/**
	 * El constructor por defecto nos crea el punto en el origen
	 * de las coordenadas
	 */
	public Punto()
	{
		x = 0;
		y = 0;
	}
	
	public Punto(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX() 
	{
		return x;
	}
	public void setX(int x) 
	{
		this.x = x;
	}
	public int getY() 
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}

	@Override
	public int compareTo(Punto otro) {
		if(this.y - otro.y == 0){
			return this.x - otro.x;
		}
		else
			return this.y - otro.y;
	}
	
	@Override
	public String toString()
	{
		return ("("+x+", "+y+")");
	}
}