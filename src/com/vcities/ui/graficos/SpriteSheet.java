package com.vcities.ui.graficos;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author seguame
 *
 */

public class SpriteSheet 
{
	private int anchura;
	private int altura;
	private int[] pixeles;
	
	public SpriteSheet(String ruta)
	{
		cargarSpriteSheet(ruta);
	}
	
	private void cargarSpriteSheet(String ruta)
	{
		try {
			BufferedImage imagen = ImageIO.read(SpriteSheet.class.getResource(ruta));
			anchura = imagen.getWidth();
			altura = imagen.getHeight();
			this.pixeles = new int[anchura * altura];
			
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
				destino[x + y * tamanioSprite] = pixeles[(x + xOffset) + (y + yOffset) * anchura];
			}
		}
		
		return destino;
	}
	
	public static final SpriteSheet mosaicosTerreno = new SpriteSheet("/GFX/terreno.png");
	public static final SpriteSheet mosaicosPuntero = new SpriteSheet("/GFX/puntero.png");
}
