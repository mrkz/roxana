package com.vcities;

import javax.swing.JFrame;

import com.vcities.ui.Interfaz;

/**
 * 
 * @author seguame
 *
 */

public class Main {
	
	public static void testGraham(){
		
	}
	
	public static void main(String[] args) 
	{
		Interfaz interfaz = new Interfaz();
		boolean test = false;
		
		//Preparando la ventana donde se dibujara 
		JFrame ventana = new JFrame();
		ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		ventana.setResizable( false );
		ventana.setTitle( "Testing" );
		ventana.add( interfaz );
		ventana.pack();
		ventana.setVisible( true );
		ventana.requestFocus();
		if(test){
			testGraham();
		}
		interfaz.iniciar();
	}

}
