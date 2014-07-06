package com.vcities.ui.graficos;

import java.util.Arrays;

/**
 * 
 * @author seguame
 *
 */

public class Sprite {
	
	public final int TAMANIO;
	private int anchura, altura;
	private int x, y; //coordenadas del sprite en el modelo de sprites
	public int[] pixeles;
	
	public Sprite(int tamanio, int x, int y, SpriteSheet origenSprite)
	{
		this.TAMANIO = tamanio;
		
		this.altura = tamanio;
		this.anchura = tamanio;
		this.x = x * tamanio;
		this.y = y * tamanio;
		pixeles = new int[tamanio * tamanio];
		
		cargarSprite(origenSprite);
	}
	
	public Sprite(int anchura, int altura, int color)
	{
		this.TAMANIO = -1;
		
		this.anchura = anchura;
		this.altura = altura;
		pixeles = new int[anchura * altura];
		
		setColor(color);
	}
	
	public Sprite(int tamanio, int color)
	{
		TAMANIO = tamanio;
		this.altura = tamanio;
		this.anchura = tamanio;
		pixeles = new int[TAMANIO * TAMANIO];
		setColor(color);
	}
	
	private void setColor(int color) 
	{
		Arrays.fill(pixeles, color);
	}
	

	private void cargarSprite(SpriteSheet origenSprite)
	{
		origenSprite.obtenerSprite(x, y, TAMANIO, pixeles);
	}
	
	private static Sprite invertirX(Sprite sprite)
	{
		int tamanio = sprite.TAMANIO;
		Sprite invertido = new Sprite(tamanio, tamanio); 
		
		for(int y = 0; y < tamanio; y++) 
		{ 
			for(int x = 0; x < tamanio; x++) 
			{ 
				invertido.pixeles[x + y * tamanio] = sprite.pixeles[(tamanio - 1 - x) + y * tamanio]; 
			} 
		} 
		
		return invertido;
	}
	
	public int getTamanio()
	{
		return TAMANIO;
	}
	
	public int getAltura()
	{
		return altura;
	}
	
	public int getAnchura()
	{
		return anchura;
	}
	
	
	public static final Sprite pasto 	= new Sprite(16, 0, 1, SpriteSheet.mosaicosTerreno);
	public static final Sprite flor 	= new Sprite(16, 1, 1, SpriteSheet.mosaicosTerreno);
	public static final Sprite roca 	= new Sprite(16, 4, 2, SpriteSheet.mosaicosTerreno);
	public static final Sprite agua 	= new Sprite(16, 5, 2, SpriteSheet.mosaicosTerreno);
	public static final Sprite vacio 	= new Sprite(16, 0x000000);
	
	public static final Sprite camino_abajo_derecha			= new Sprite(16, 0, 6, SpriteSheet.mosaicosTerreno);
	public static final Sprite camino_horizontal			= new Sprite(16, 1, 6, SpriteSheet.mosaicosTerreno);
	public static final Sprite camino_izquierda_abajo		= new Sprite(16, 2, 6, SpriteSheet.mosaicosTerreno);
	public static final Sprite camino_derecha_arriba		= new Sprite(16, 0, 7, SpriteSheet.mosaicosTerreno);
	public static final Sprite camino_vertical				= new Sprite(16, 1, 7, SpriteSheet.mosaicosTerreno);
	public static final Sprite camino_arriba_izquierda		= new Sprite(16, 2, 7, SpriteSheet.mosaicosTerreno);
	
	public static final Sprite puntero_arriba_izquierda 	= new Sprite(16, 0, 0, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_arriba 				= new Sprite(16, 1, 0, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_arriba_derecha 		= new Sprite(16, 2, 0, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_centro_izquierda 	= new Sprite(16, 0, 1, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_centro 				= new Sprite(16, 1, 1, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_centro_derecha		= new Sprite(16, 2, 1, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_abajo_izquierda 		= new Sprite(16, 0, 2, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_abajo 				= new Sprite(16, 1, 2, SpriteSheet.mosaicosPuntero);
	public static final Sprite puntero_abajo_derecha		= new Sprite(16, 2, 2, SpriteSheet.mosaicosPuntero);
	
	public static final Sprite dummy_arriba_izquierda 		= new Sprite(16, 3, 0, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_arriba 				= new Sprite(16, 4, 0, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_arriba_derecha 		= new Sprite(16, 5, 0, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_centro_izquierda 		= new Sprite(16, 3, 1, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_centro 				= new Sprite(16, 4, 1, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_centro_derecha			= new Sprite(16, 5, 1, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_abajo_izquierda 		= new Sprite(16, 3, 2, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_abajo 					= new Sprite(16, 4, 2, SpriteSheet.mosaicosPuntero);
	public static final Sprite dummy_abajo_derecha			= new Sprite(16, 5, 2, SpriteSheet.mosaicosPuntero);
	
}
