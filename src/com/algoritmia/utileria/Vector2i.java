package com.algoritmia.utileria;

public class Vector2i
{
	private int x, y;
	public Vector2i(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static double getDistancia(Vector2i inicio, Vector2i destino)
	{
		double dx = inicio.getX() - destino.getX();
		double dy = inicio.getY() - destino.getY();
		
		return Math.sqrt((dx * dx) + (dy * dy));
	}
	
	
	public Vector2i sumar(Vector2i vector)
	{
		this.x += vector.getX();
		this.y += vector.getY();
		return this;
	}
	
	public Vector2i restar(Vector2i vector)
	{
		this.x -= vector.getX();
		this.y -= vector.getY();
		return this;
	}
	
	public int getX() {
		return x;
	}
	public Vector2i setX(int x) {
		this.x = x;
		return this;
	}
	public int getY() {
		return y;
	}
	public Vector2i setY(int y) {
		this.y = y;
		return this;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Vector2i)
		{
			return this.x == ((Vector2i)o).x && this.y == ((Vector2i)o).y;
		}
		
		return false;
	}
	
	@Override
	public int hashCode()
	{
		int algo = new Integer(x).hashCode();
		int algoMas = new Integer(y).hashCode();
		Double algoMenos = (double)algo / (double)algoMas;
		return algoMenos.hashCode();
	}
}
