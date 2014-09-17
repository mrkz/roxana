package com.vcities.ui.entidad.representacion.utileria;

/**
 * 
 * @author seguame
 *
 */
public enum Direccion {
	
	ARRIBA("Arriba"),
	ARRIBA_DERECHA("Arriba_Derecha"),
	ARRIBA_IZQUIERDA("Arriba_Izquierda"),
	ABAJO("Abajo"),
	ABAJO_DERECHA("Abajo_Derecha"),
	ABAJO_IZQUIERDA("Abajo_Izquierda"),
	IZQUIERDA("Izquierda"),
	DERECHA("Derecha"),
	NULA("Nula");
	
	
	private String direccion;
	
	private Direccion(String direccion)
	{
		this.direccion = direccion;
	}
	
	@Override
	public String toString()
	{
		return direccion;
	}
}
