package com.algoritmia.utileria;


public class Nodo 
{
	public Vector2i posicion;
	public Nodo padre;
	public double gCosto; //costo entre nodos
	public double hCosto; //heuristico estimado
	public double fCosto; //combinacion
	
	public Nodo(Vector2i posicion, Nodo padre, double gCosto, double hCosto)
	{
		this.posicion = posicion;
		this.padre = padre;
		this.gCosto = gCosto;
		this.hCosto = hCosto;
		this.fCosto = gCosto + hCosto;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Nodo)
		{
			return this.posicion.equals(((Nodo)o).posicion);
		}
		
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return posicion.hashCode();
	}
}
