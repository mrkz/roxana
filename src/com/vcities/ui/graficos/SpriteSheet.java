package com.vcities.ui.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author seguame
 *
 */

public class SpriteSheet {
	
	private String ruta;
	private final int TAMANIO;
	private int[] pixeles;
	
	public SpriteSheet(String ruta, int tamanio)
	{
		this.ruta = ruta;
		this.TAMANIO = tamanio;
		this.pixeles = new int[TAMANIO * TAMANIO];
		cargarSpriteSheet();
	}
	
	private void cargarSpriteSheet()
	{
		try {
			BufferedImage imagen = ImageIO.read(SpriteSheet.class.getResource(ruta));
			int anchura = imagen.getWidth();
			int altura = imagen.getHeight();
			
			imagen.getRGB(0, 0, anchura, altura, pixeles, 0, anchura);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Regresar?? el sprite que este en la coordenada x, y dada
	public int[] obtenerSprite(int xOffset, int yOffset, int tamanioSprite, int[] destino)
	{
		for(int y = 0; y < tamanioSprite; y++)
		{
			for(int x = 0; x < tamanioSprite; x++)
			{
				destino[x + y * tamanioSprite] = pixeles[(x + xOffset) + (y + yOffset) * TAMANIO];
			}
		}
		
		return destino;
	}
	
	
	
	
	public static final SpriteSheet mosaicosTerreno = new SpriteSheet("/GFX/terreno.png", 256);
	public static final SpriteSheet mosaicosPuntero = new SpriteSheet("/GFX/puntero.png", 96);
}
