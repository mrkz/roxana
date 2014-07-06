package com.vcities.ui.entidad.mob;

import com.vcities.ui.ciudad.mosaico.CoordenadaMosaico;
import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;
import com.vcities.ui.input.Teclado;

/**
 * 
 * @author seguame
 *
 */

public class Puntero extends Mob{
	
	private Teclado input;
	private final int velocidad = 5;
	
	public Puntero(CoordenadaMosaico cm, Teclado input)
	{
		this(cm.getX(), cm.getY(), input);
	}
	
	public Puntero(int x, int y, Teclado input)
	{
		this(input);
		this.x = x;
		this.y = y;
	}
	
	public Puntero(Teclado input)
	{
		super();
		this.input = input;
		sprite = Sprite.puntero_centro;
	}
	
	@Override
	public void actualizar()
	{
		int xa = 0;
		int ya = 0;
		if(input.arriba()) ya -= velocidad;
		if(input.abajo()) ya += velocidad;
		if(input.derecha()) xa += velocidad;
		if(input.izquierda()) xa -= velocidad;
		
		if(xa != 0 || ya != 0)
		{
			mover(xa, ya);
			switch (direccion) 
			{
				case ARRIBA:
					sprite = Sprite.puntero_arriba;
					break;
				case ABAJO:
					sprite = Sprite.puntero_abajo;
					break;
				case ABAJO_DERECHA:
					sprite = Sprite.puntero_abajo_derecha;
					break;
				case ABAJO_IZQUIERDA:
					sprite = Sprite.puntero_abajo_izquierda;
					break;
				case ARRIBA_IZQUIERDA:
					sprite = Sprite.puntero_arriba_izquierda;
					break;
				case ARRIBA_DERECHA:
					sprite = Sprite.puntero_arriba_derecha;
					break;
				case DERECHA:
					sprite = Sprite.puntero_centro_derecha;
					break;
				case IZQUIERDA:
					sprite = Sprite.puntero_centro_izquierda;
					break;
				case NULA:
					sprite = Sprite.puntero_centro;
					break;
			}
		}
		else
		{
			sprite = Sprite.puntero_centro;
		}
	}
	
	@Override
	public void renderizar(Render pantalla)
	{	
		int tamanio = sprite.getTamanio();
		pantalla.renderizarMob(x - tamanio, y - tamanio, this);
	}
}
