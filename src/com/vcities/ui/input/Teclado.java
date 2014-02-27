package com.vcities.ui.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author seguame
 *
 */

public class Teclado implements KeyListener{
	
	private final int CANTIDAD_TECLAS = 120;
	private boolean[] teclas;
	
	
	
	public Teclado()
	{
		teclas = new boolean[CANTIDAD_TECLAS];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	
	public boolean arriba()
	{
		return teclas[KeyEvent.VK_UP] || teclas[KeyEvent.VK_W];
	}
	
	public boolean abajo()
	{
		return teclas[KeyEvent.VK_DOWN] || teclas[KeyEvent.VK_S];
	}
	
	public boolean derecha()
	{
		return teclas[KeyEvent.VK_RIGHT] || teclas[KeyEvent.VK_D];
	}
	
	public boolean izquierda()
	{
		return teclas[KeyEvent.VK_LEFT] || teclas[KeyEvent.VK_A];
	}

}
