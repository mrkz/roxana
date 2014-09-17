package com.vcities.ui.entidad.representacion;

import com.vcities.ui.entidad.Entidad;
import com.vcities.ui.entidad.representacion.utileria.Direccion;
import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;

/**
 * 
 * @author seguame
 *
 */
public abstract class RepresentacionEntidad extends Entidad
{
	protected Sprite sprite;
	protected Direccion direccion;
	protected boolean enMovimiento;
	protected int cuadroAnimacion;
	
	protected RepresentacionEntidad(int x, int y)
	{
		this();
		
		// multiplicando por 16 la posicion 
		// traduciendo de pixeles a coordenadas en el mapa
		this.x = x << 4;
		this.y = y << 4;
	}
	
	protected RepresentacionEntidad()
	{
		super();
		direccion = Direccion.NULA;
		cuadroAnimacion = 0;
	}
	
	public void mover(int xa, int ya)
	{
		
		if(xa > 0 && ya == 0) direccion = Direccion.DERECHA;
		if(xa > 0 && ya > 0) direccion = Direccion.ABAJO_DERECHA;
		if(xa > 0 && ya < 0) direccion = Direccion.ARRIBA_DERECHA;
		if(xa < 0 && ya == 0) direccion = Direccion.IZQUIERDA;
		if(xa < 0 && ya > 0) direccion = Direccion.ABAJO_IZQUIERDA;
		if(xa < 0 && ya < 0) direccion = Direccion.ARRIBA_IZQUIERDA;
		if(ya > 0 && xa == 0) direccion = Direccion.ABAJO;
		if(ya < 0 && xa == 0) direccion = Direccion.ARRIBA;
		
		
		if(!colision())
		{
			x += xa;
			y += ya;
		}
	}
	
	private boolean colision()
	{
		return false;
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
	
	public abstract void actualizar();
	public abstract void renderizar(Render render);
}
