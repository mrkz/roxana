package com.vcities.ui.ciudad;

/**
 * 
 * @author seguame
 *
 */

public class CiudadAleatoria extends Ciudad {
	
	

	public CiudadAleatoria(int anchura, int altura) {
		super(anchura, altura);
	}
	
	@Override
	protected void generarCiudad()
	{
		for(int y = 0; y < altura; y++)
		{
			for(int x = 0; x < anchura; x++)
			{
				pixelesNivel[x + y * anchura] = Ciudad.random.nextInt(4);
			}
		}
	}


}
