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
	public void actualizar() {
		
	}

	@Override
	public void renderizar(Render render) {
		render.renderizarMob(x, y, sprite);
		
	}

}
