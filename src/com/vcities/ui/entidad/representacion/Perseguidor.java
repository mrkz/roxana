package com.vcities.ui.entidad.representacion;

import java.util.List;

import com.algoritmia.utileria.Nodo;
import com.algoritmia.utileria.Vector2i;
import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;

public class Perseguidor extends RepresentacionEntidad{

	private int xa;
	private int ya;
	private List<Nodo> camino;
	private int tiempo = 0;
	
	public Perseguidor(int x, int y)
	{
		super(x,y);
		xa = 0;
		ya = 0;
		sprite = Sprite.dummy_centro;
		camino = null;
	}
	
	private void mover()
	{
		xa = 0;
		ya = 0;
		
		
		Puntero p = ciudad.getPuntero();
		int px = p.getX();
		int py = p.getY();
		
		/***
		 * Modo simple del perseguidor, siempre va 
		 * en direccion del puntero sin importar
		 * obstaculos
		 */
		/*
		if(x < px) xa = 1;
		if(x > px) xa = -1;
		if(y < py) ya = 1;
		if(y > py) ya = -1;*/
		
		//Verificar si hace falta actualizar el camino cada medio segundo
		if(tiempo % 30 == 0)
		{
			Vector2i inicio = new Vector2i(getX() >> 4, getY() >> 4);
			Vector2i destino = new Vector2i(px >> 4, py >> 4);
			camino = ciudad.encontrarCamino(inicio, destino);
		}
		
		if(camino != null)
		{
			if(camino.size() > 0)
			{
				//Se obtiene la ultima posición [origen del perseguidor]
				//porque la 1ra es el destino que se busca.
				Vector2i vec = camino.get(camino.size() - 1).posicion;
				
				//Como el vector tiene precision de mosaico
				//y la entidad de pixel, multiplico por 16 
				if(x < (vec.getX() << 4)) xa = 1;
				if(x > (vec.getX() << 4)) xa = -1;
				if(y < (vec.getY() << 4)) ya = 1;
				if(y > (vec.getY() << 4)) ya = -1;
			}
		}
	}
	
	@Override
	public void actualizar() 
	{
		
		mover();
		
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
		
		++tiempo;
	}

	@Override
	public void renderizar(Render render) {
		render.renderizarEntidad(x, y, this);
	}
}
