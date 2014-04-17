package com.vcities.ui.graficos;

import com.vcities.ui.ciudad.mosaico.Mosaico;

/**
 * 
 * @author seguame
 *
 */

public class Render {
	
	
	private int xOffset;
	private int yOffset;
	
	
	private int anchura;
	private int altura;
	private int[] pixeles;
	
	public Render(int anchura, int altura, int[] pixeles)
	{
		this.anchura = anchura;
		this.altura = altura;
		this.pixeles = pixeles;
	}
	
	
	public void renderizarSprite(int xp, int yp, Sprite sprite, boolean fijo)
	{
		if(fijo)
		{
			xp -= xOffset;
			yp -= yOffset;
		}
		
		int spAltura = sprite.getAltura();
		int spAnchura = sprite.getAnchura();
		
		for(int y = 0; y < spAltura; ++y)
		{
			int ya = y + yp;
			
			if(ya < 0 || ya >= altura) 
				continue;
			
			for(int x = 0; x < spAnchura; ++x)
			{
				int xa = x + xp;
				
				if(xa < 0 || xa >= anchura)
					continue;
				
				pixeles[xa + ya * anchura] = sprite.pixeles[x + y * spAnchura];
			}
		}
	}
	
	public void renderizarMosaico(int xp, int yp, Mosaico mosaico)
	{
		renderizarSprite(xp, yp, mosaico.sprite, true);
	}
	
	public void renderizarMob(int xp, int yp, Sprite sprite)
	{
		final int tamanio = sprite.getTamanio();
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tamanio; y++)
		{
			int ya = y + yp;
			
			if(ya < 0 || ya >= altura)
				break;
			
			for(int x = 0; x < tamanio; x++)
			{
				int xa = x + xp;
				
				if(xa < 0 || xa >= anchura)
					break;
				
				int color = sprite.pixeles[x + y * tamanio];
				if(color != 0xFFFF00FF) 
					pixeles[xa + ya * anchura] = color;
			}
		}
	}
	
	public void setOffsets(int xOffset, int yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public int getxOffset() {
		return xOffset;
	}

	public int getyOffset() {
		return yOffset;
	}

	public int getAnchura() {
		return anchura;
	}

	public int getAltura() {
		return altura;
	}

	public int[] getPixeles() {
		return pixeles;
	}

}
