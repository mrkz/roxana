package com.vcities.ui.ciudad.mosaico.terreno;

import com.vcities.ui.ciudad.mosaico.Mosaico;
import com.vcities.ui.graficos.Sprite;

public class MosaicoVacio extends Mosaico {

	public MosaicoVacio() {
		super(Sprite.agua, false);
	}
	
	public String toString()
	{
		return "agua";
	}
}
