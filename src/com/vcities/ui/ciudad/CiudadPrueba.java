package com.vcities.ui.ciudad;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.vcities.ui.ciudad.mosaico.Mosaico;
import com.vcities.ui.entidad.representacion.Dummy;
import com.vcities.ui.entidad.representacion.Perseguidor;

/**
 * 
 * @author seguame
 *
 */
public class CiudadPrueba extends Ciudad{

	public CiudadPrueba(String ruta) {
		super(ruta);
		this.generarCiudad();
	}
	
	@Override
	protected void cargarCiudad(String ruta)
	{
		try
		{
			BufferedImage imagen = ImageIO.read(CiudadPrueba.class.getResource(ruta));
			anchura = imagen.getWidth();
			altura = imagen.getHeight();
			mosaicos = new Mosaico[anchura * altura];
			pixelesCiudad = new int[anchura * altura];
			imagen.getRGB(0, 0, anchura, altura, pixelesCiudad, 0, anchura);
		}
		catch(IOException e)
		{
			e.printStackTrace();System.out.println("No logre cargar el nivel");
		}
		
		
		agregarEntidad(new Perseguidor(21, 11));
		
		for(int i = 1; i <= 5000; ++i)
		{
			agregarEntidad(new Dummy(random.nextInt(anchura), random.nextInt(altura)));
		}
	}
	
	@Override
	protected void generarCiudad()
	{
		int tamanio = pixelesCiudad.length;
		for(int i = 0; i < tamanio; i++)
		{
			if(pixelesCiudad[i] == 0xFF00FF00)
				mosaicos[i] = Mosaico.pasto;
			else if(pixelesCiudad[i] == 0xFFFFFF00)
				mosaicos[i] = Mosaico.flor;
			else if(pixelesCiudad[i] == 0xFF7F7F00)
				mosaicos[i] = Mosaico.roca;
			else
				mosaicos[i] = Mosaico.vacio;
		}
	}

}
