package com.vcities.ui.ciudad.mosaico;

import com.vcities.ui.ciudad.mosaico.terreno.MosaicoFlor;
import com.vcities.ui.ciudad.mosaico.terreno.MosaicoPasto;
import com.vcities.ui.ciudad.mosaico.terreno.MosaicoRoca;
import com.vcities.ui.ciudad.mosaico.terreno.MosaicoVacio;
import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;

public class Mosaico 
{
	public Sprite sprite;
	protected boolean transitable;
	protected int ajuste;
	
	public Mosaico(Sprite sprite, boolean transitable)
	{
		this.sprite = sprite;
		this.transitable  = transitable;
		
		ajuste = (int) (Math.log(this.sprite.TAMANIO) / Math.log(2));
	}
	
	public void renderizar(int x, int y, Render destino)
	{
		//se retorna el tamanio del mosaico a su valor 16*16
		destino.renderizarMosaico(x << ajuste, y << ajuste, this);
	}
	
	public boolean esTransitable()
	{
		return transitable;
	}
	
	
	public static final Mosaico pasto = new MosaicoPasto();
	public static final Mosaico flor = new MosaicoFlor();
	public static final Mosaico roca = new MosaicoRoca();
	public static final Mosaico vacio = new MosaicoVacio();
}
