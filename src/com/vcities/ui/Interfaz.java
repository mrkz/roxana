package com.vcities.ui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.vcities.ui.ciudad.Ciudad;
import com.vcities.ui.ciudad.CiudadPrueba;
import com.vcities.ui.ciudad.mosaico.CoordenadaMosaico;
import com.vcities.ui.entidad.mob.Puntero;
import com.vcities.ui.graficos.Render;
import com.vcities.ui.graficos.Sprite;
import com.vcities.ui.input.Teclado;

/**
 * 
 * @author seguame
 *
 */

public class Interfaz 
extends Canvas 
implements Runnable
{

	private static final long serialVersionUID = 1L;
	
	public static int anchura 	= 400;
	public static int altura 	= anchura / 5 * 4; //para la relacion de aspecto
	public static float escala	= 2f;
	
	private Thread hiloGrafico;
	private boolean ejecutandose;
	
	//TODO: quitar esto, nomas lo tengo para el el titulo poner la cantidad de CPS
	private JFrame padre;
	
	private BufferedImage imagen;
	private int[] pixeles;
	
	private Render pantalla;
	
	private Teclado teclado; 
	//private Raton raton;
	
	private Ciudad ciudad;
	private Puntero puntero;
	
	private Random random = new Random(System.currentTimeMillis());
	
	public Interfaz()
	{
		Dimension tamanio = new Dimension((int)(anchura * escala),(int)( altura * escala));
		this.setPreferredSize( tamanio );
		
		imagen = new BufferedImage(anchura, altura, BufferedImage.TYPE_INT_RGB);
		pixeles = ((DataBufferInt)imagen.getRaster().getDataBuffer()).getData();
		
		pantalla = new Render(anchura, altura, pixeles);
		
		teclado = new Teclado();
		this.addKeyListener(teclado);
		
		
		//ciudad = new CiudadAleatoria(64, 64);
		ciudad = new CiudadPrueba("/ciudades/ciudadtests.png");
		
		CoordenadaMosaico origenPuntero = new CoordenadaMosaico(10, 10);
		puntero = new Puntero(origenPuntero.getX(), origenPuntero.getY(), teclado);
	}
	
	
	public synchronized void iniciar()
	{
		padre = (JFrame)this.getParent().getParent().getParent().getParent();
		ejecutandose = true;
		hiloGrafico = new Thread(this, "Graficos");
		hiloGrafico.start();
	}
	
	public synchronized void detener()
	{
		ejecutandose = false;
		
		try {
			hiloGrafico.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() 
	{
		long ultimaActualizacion = System.nanoTime();
		final double nanosegundos =  1_000_000_000.0 / 60.0; //60 CPs para 1 segundo
		double delta = 0;
		int cuadros = 0;
		int actualizaciones = 0;
		long timer = System.currentTimeMillis();
		
		this.requestFocus();
		
		while(ejecutandose)
		{
			long ahora = System.nanoTime();
			delta += (ahora - ultimaActualizacion) / nanosegundos;
			ultimaActualizacion = ahora;
			while(delta >= 1)
			{
				actualizar();
				
				delta--;
				actualizaciones++;
				
				//FIXME
				//Actualmente no se realiza ningun calculo "pesado", asiq ue sobra 
				//fuerza de CPU y lo mando a dormir, despues que se tenga otros hilo
				//haciendo calculos pesados podemos dejar que la pantalla no duerma, esperando
				//que se terminen los calculos
				try {
					Thread.sleep(1);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			renderizar();
			cuadros++;
			
			
			if(System.currentTimeMillis() - timer > 1_000)
			{
				timer += 1_000; //a??adirle un segundo
				padre.setTitle("Testing | " + actualizaciones + " ups, " + cuadros + " fps");
				actualizaciones = 0;
				cuadros = 0;
			}
		}
		
		detener();
	}
	
	private void actualizar()
	{
		puntero.actualizar();
	}
	
	private void renderizar()
	{
		BufferStrategy buffer 	= this.getBufferStrategy();
		if(buffer == null)
		{
			this.createBufferStrategy( 3 );
			return;
		}
		int xOffset = puntero.getX() - (pantalla.getAnchura() >> 1);
		int yOffset = puntero.getY() - (pantalla.getAltura() >> 1);
		//pantalla.limpiar();
		ciudad.renderizar(xOffset, yOffset, pantalla);
		puntero.renderizar(pantalla);
		
		dibujarContaminacion();
		
		Graphics graficos = buffer.getDrawGraphics();
		
		graficos.drawImage(imagen, 0,  0, getWidth(), getHeight(), null);
		graficos.dispose();
		buffer.show();
	}
	
	
	
	private void dibujarContaminacion()
	{
		Sprite polucion = new Sprite(2,2, 0xFFFFFF);
		
		for( int i = 0; i < 50; ++i)
		{
			pantalla.renderizarSprite(100 + random.nextInt(30), 100 + random.nextInt(30), polucion, true);
		}
	}
}
