package com.vcities.ui.graficos;

import com.vcities.ui.ciudad.mosaico.Mosaico;
import com.vcities.ui.entidad.representacion.Perseguidor;
import com.vcities.ui.entidad.representacion.RepresentacionEntidad;

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
	
	
	public void renderizarEntidad(int xp, int yp, RepresentacionEntidad rep)
	{
		Sprite sprite = rep.getSprite();
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
				
				
				//Solo si el sprite está visible en pantalla [validado con los 
				//2 if anteriores, se pondrá su pixel en la pantalla
				//en caso contrario no se pondrá nada, ahorrando
				//tiempo de procesamiento.
				int color = sprite.pixeles[x + y * tamanio];
				
				if(rep instanceof Perseguidor && color == 0xFFED1C24) 
					color = 0xFF0000FF;
				
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
