package com.vcities.ui.ciudad.mosaico;

public class CoordenadaMosaico 
{
	
	private int x;
	private int y;
	private static final int TAMANIO_MOSAICO = 16;
	
	public CoordenadaMosaico(int x, int y)
	{
		this.x = x * CoordenadaMosaico.TAMANIO_MOSAICO;
		this.y = y * CoordenadaMosaico.TAMANIO_MOSAICO; 
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
}
