package com.algoritmia.utileria;

/**
 * @version 1.0
 * @author seguame
 *
 * Las rectas delimitan el espacio entre secciones 
 */

public class Recta 
{
	private Punto origen;
	private Punto destino;
	
	public Recta(Punto origen, Punto destino)
	{
		this.origen = origen;
		this.destino = destino;
	}
	
	public Punto obtenerPuntoMedio()
	{
		int mediaX;
		int mediaY;
		
		mediaX = destino.getX() - origen.getX();
		mediaY = destino.getY() - origen.getY();
		
		return new Punto(mediaX, mediaY);
	}
	
	public Punto getOrigen() 
	{
		return origen;
	}
	
	public void setOrigen(Punto origen) 
	{
		this.origen = origen;
	}
	
	public Punto getDestino() 
	{
		return destino;
	}
	
	public void setDestino(Punto destino) 
	{
		this.destino = destino;
	}
	
	/**
	 * Generar una recta respecto
	 * a otra y un punto cualquiera en el espacio
	 * @param recta 
	 * La recta de la cual parte el origen
	 * @param punto 
	 * Punto al cual se dirige la recta
	 * @return una recta con nuevas coordenadas
	 */
	public static Recta generarRecta(Recta recta, Punto punto)
	{
		return new Recta(recta.obtenerPuntoMedio(), punto);
	}
	
}
