package com.vcities.ui.ciudad.mosaico.terreno;

import com.vcities.ui.ciudad.mosaico.Mosaico;
import com.vcities.ui.graficos.Sprite;

/**
 * 
 * @author seguame
 *
 */
public class MosaicoRoca extends Mosaico {

	public MosaicoRoca() {
		super(Sprite.roca, false);
	}
	
	public String toString()
	{
		return "roca";
	}
}
