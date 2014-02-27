package com.vcities.ui.entidad;

import java.util.Random;

import com.vcities.ui.ciudad.Ciudad;
import com.vcities.ui.graficos.Render;

/**
 * @author seguame
 * Un elemento que no necesariamente requiere una representacion en
 * pantalla, puede ser un contador, fisica...
 */
public abstract class Entidad {
	
	protected int x, y;
	protected boolean visible;
	protected Ciudad nivel;
	protected final Random random;
	
	protected Entidad()
	{
		visible = true;
		random = new Random(System.currentTimeMillis());
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void actualizar()
	{}
	
	public void renderizar(Render pantalla)
	{
		
	}
	
	public void borrar()
	{
		visible = false;
	}
	
	public boolean isVisible()
	{
		return visible;
	}
	
}
