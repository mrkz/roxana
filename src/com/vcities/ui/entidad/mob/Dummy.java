package com.vcities.ui.entidad.mob;

import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;
import com.vcities.ui.input.Teclado;

public class Dummy  extends Mob{
	
	private Teclado input;
	private final int velocidad = 4;
	
	public Dummy(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public void actualizar()
	{
		int xa = 0;
		int ya = 0;
		
		
		if(xa != 0 || ya != 0)
		{
			mover(xa, ya);
			enMovimiento = true;
		}
		else
		{
			enMovimiento = false;
		}
	}
	
	@Override
	public void renderizar(Render pantalla)
	{
		if(enMovimiento)
		{
			switch (direccion) 
			{
				case ARRIBA:
					sprite = Sprite.dummy_arriba;
					break;
				case ABAJO:
					sprite = Sprite.dummy_abajo;
					break;
				case ABAJO_DERECHA:
					sprite = Sprite.dummy_abajo_derecha;
					break;
				case ABAJO_IZQUIERDA:
					sprite = Sprite.dummy_abajo_izquierda;
					break;
				case ARRIBA_IZQUIERDA:
					sprite = Sprite.dummy_arriba_izquierda;
					break;
				case ARRIBA_DERECHA:
					sprite = Sprite.dummy_arriba_derecha;
					break;
				case DERECHA:
					sprite = Sprite.dummy_centro_derecha;
					break;
				case IZQUIERDA:
					sprite = Sprite.dummy_centro_izquierda;
					break;
				case NULA:
					sprite = Sprite.dummy_centro;
					break;
			}
		}
		else
		{
			sprite = Sprite.dummy_centro;
		}
		
		int tamanio = sprite.getTamanio();
		pantalla.renderizarPuntero(x - tamanio, y - tamanio, sprite);
	}
}
