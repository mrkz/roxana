package com.vcities.ui.ciudad.mosaico.terreno;

import com.vcities.ui.ciudad.mosaico.Mosaico;
import com.vcities.ui.graficos.Sprite;

/**
 * 
 * @author seguame
 *
 */

public class MosaicoFlor extends Mosaico {

	public MosaicoFlor() 
	{
		super(Sprite.flor, true);
	}
	
	public String toString()
	{
		return "flor";
	}

}
