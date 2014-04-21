package com.vcities.ui.ciudad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.algoritmia.utileria.Nodo;
import com.algoritmia.utileria.Vector2i;
import com.vcities.ui.ciudad.mosaico.Mosaico;
import com.vcities.ui.entidad.Entidad;
import com.vcities.ui.entidad.mob.Puntero;
import com.vcities.ui.graficos.Render;

/**
 * 
 * @author seguame
 *
 */

public abstract class Ciudad 
{
	
	protected static Random random;
	protected int anchura;
	protected int altura;
	protected Mosaico[] mosaicos;
	protected int[] pixelesCiudad;
	protected List<Entidad> entidades;
	protected Puntero puntero;
	
	static
	{
		random = new Random(System.currentTimeMillis());
	}
	
	private Comparator<Nodo> comparadorNodo = new Comparator<Nodo>()
	{
		@Override
		public int compare(Nodo n0, Nodo n1) 
		{
			if(n1.fCosto < n0.fCosto)
				return 1;
			if(n1.fCosto > n0.fCosto)
				return -1;
			
			return 0;
		}
	};
	
	public Ciudad(int anchura, int altura)
	{
		this.altura = altura;
		this.anchura = anchura;
		pixelesCiudad = new int[anchura * altura];
		entidades = new ArrayList<Entidad>();
		generarCiudad();
	}
	
	public Ciudad(String ruta)
	{
		entidades = new ArrayList<Entidad>();
		cargarCiudad(ruta);
	}
	
	public void actualizar()
	{
		for(Entidad e : entidades)
		{
			e.actualizar();
		}
	}
	
	private void tiempo()
	{
		
	}
	
	public void renderizar(int desplazamientoX, int desplazamientoY, Render pantalla)
	{
		pantalla.setOffsets(desplazamientoX, desplazamientoY);
		
		int x0 = desplazamientoX >> 4; //la izquierda
		int x1 = (desplazamientoX + pantalla.getAnchura() + 16) >> 4; //la derecha
		int y0 = desplazamientoY >> 4; //el tope de la pantalla
		int y1 = (desplazamientoY + pantalla.getAltura() + 16) >> 4; //el fondo de la pantalla
		
		
		
		for(int y = y0; y < y1; y++)
		{
			for(int x = x0; x < x1; x++)
			{
				if(x < 0 || y < 0 || x >= anchura || y >= altura) 
					Mosaico.vacio.renderizar(x, y, pantalla);
				else	
				{
					//para mapas random
					//getMosaico(x, y).renderizar(x, y, pantalla);
					
					//para mapas definidos
					mosaicos[x + y * anchura].renderizar(x, y, pantalla);
				}
				
			}
		}
		
		for(Entidad e : entidades)
		{
			e.renderizar(pantalla);
		}
	}
	
	
	public List<Nodo> encontrarCamino(Vector2i inicio, Vector2i destino)
	{
		List<Nodo> considerados = new ArrayList<Nodo>();
		List<Nodo> camino = new ArrayList<Nodo>();
		
		Nodo actual = new Nodo(inicio, null, 0, Vector2i.getDistancia(inicio, destino));
		
		considerados.add(actual);
		
		while(considerados.size() > 0)
		{
			Collections.sort(considerados, comparadorNodo);
			actual = considerados.get(0);
			
			if(actual.posicion.equals(destino))
			{
				List<Nodo> caminoInvertido = new ArrayList<Nodo>();
				while(actual.padre != null)
				{
					caminoInvertido.add(actual);
					actual = actual.padre;
				}
				
				camino.clear();
				considerados.clear();
				
				return caminoInvertido;
			}
			
			considerados.remove(actual);
			camino.add(actual);
			
			for(int i = 0; i < 9 ; ++i)
			{
				if(i == 4) // nodo central que seria el nodo actual
					continue; 
				int x = actual.posicion.getX();
				int y = actual.posicion.getY();
				int xi = (i % 3) - 1;
				int yi = (i / 3) - 1;
				
				Mosaico en = getMosaico(x + xi,y + yi);
				
				if(en == null || !en.esTransitable()) //fuera de limites o no es transitable
					continue;
				
				Vector2i a = new Vector2i(x + xi,  y + yi);
				double gCosto = actual.gCosto + Vector2i.getDistancia(actual.posicion, a);
				double hCosto = Vector2i.getDistancia(a, destino);
				Nodo nodo = new Nodo(a, actual, gCosto, hCosto);
				
				if(considerados.contains(nodo) && gCosto >= actual.gCosto)
					continue;
				
				if(!camino.contains(nodo) || gCosto < actual.gCosto)
					camino.add(nodo);
			}
		}
		
		camino.clear();
		return null;
	}
	
	
	public List<Entidad> getEntidades(Entidad e, int radio)
	{
		List<Entidad> resultado = new ArrayList<Entidad>();
		int ex = e.getX();
		int ey = e.getY();
		
		
		for(Entidad entidad : entidades)
		{
			int dx = Math.abs(entidad.getX() - ex);
			int dy = Math.abs(entidad.getY() - ey);
			double distancia = Math.sqrt((dx * dx) + (dy * dy));
			
			if(distancia <= radio)
			{
				resultado.add(entidad);
			}
		}
		
		return resultado;
	}
	
	
	public Mosaico getMosaico(int x, int y)
	{
		if(x < 0 || y < 0 || x >= anchura || y >= altura) 
			return Mosaico.vacio;
		
		int mosaico = pixelesCiudad[x + y * anchura];
		
		switch(mosaico)
		{
			case 0:
				return Mosaico.pasto;
			case 1:
				return Mosaico.flor;
			case 2:
				return Mosaico.roca;
			default:
				return Mosaico.vacio;
		}
	}
	
	public Puntero getPuntero()
	{
		return puntero;
	}
	
	public void agregarEntidad(Entidad e)
	{
		if(e instanceof Puntero)
		{
			puntero = (Puntero)e;
		}
		else
		{
			entidades.add(e);
		}
	}
	
	
	protected void cargarCiudad(String ruta){}
	protected abstract void generarCiudad();
	
}
