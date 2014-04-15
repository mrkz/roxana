package com.vcities.ui.entidad.mob;

import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;

public class Dummy extends Mob
{

	public Dummy(int x, int y)
	{
		// multiplicando por 16 la posicion 
		// traduciendo de pixeles a coordenadas en el mapa
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.dummy_centro;
	}
	
	
	@Override
	public void actualizar() 
	{
		int xa = 0;
		int ya = 0;
		
		if(xa != 0 || ya != 0)
		{
			mover(xa, ya);
			
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
	}

	@Override
	public void renderizar(Render render) {
		render.renderizarMob(x, y, sprite);
		
	}

}
