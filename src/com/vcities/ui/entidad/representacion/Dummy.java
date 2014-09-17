package com.vcities.ui.entidad.representacion;

import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;
import com.vcities.ui.ciudad.mosaico.CoordenadaMosaico;
import com.vcities.ui.entidad.representacion.utileria.Direccion;

public class Dummy extends RepresentacionEntidad
{

	private int xa;
	private int ya;
	private int tick;
	private int r;
	
	public Dummy(int x, int y)
	{
		super(x,y);
		tick = 0;
		xa = 0;
		ya = 0;
		r = random.nextInt(50);
		sprite = Sprite.dummy_centro;
	}
	
	
	@Override
	public void actualizar() 
	{
		if(++tick % (r + 30) == 0)
		{
			r = random.nextInt(50);
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			
			if(random.nextInt(4) == 0)
			{
				xa = 0;
				ya = 0;
			}
		}
		
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
		render.renderizarMob(x, y, this);
	}

}
