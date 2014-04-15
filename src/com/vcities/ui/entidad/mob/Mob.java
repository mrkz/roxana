package com.vcities.ui.entidad.mob;

import com.vcities.ui.entidad.Entidad;
import com.vcities.ui.entidad.mob.utileria.Direccion;
import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;

/**
 * 
 * @author seguame
 *
 */
public abstract class Mob extends Entidad
{
	protected Sprite sprite;
	protected Direccion direccion;
	protected boolean enMovimiento;
	protected int cuadroAnimacion;
	
	protected Mob()
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
	
	public abstract void actualizar();
	public abstract void renderizar(Render render);
}
