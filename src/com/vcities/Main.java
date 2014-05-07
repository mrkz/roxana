package com.vcities;

import javax.swing.JFrame;
import com.vcities.ui.Interfaz;
import java.util.ArrayList;
import java.util.Stack;
import com.algoritmia.Algoritmos;
import com.algoritmia.utileria.Punto;
import com.algoritmia.GrahamAlgorithm;

/**
 * 
 * @author seguame
 *
 */

public class Main {
	
	public static void testGraham(){
		Stack<Punto> convexHull;
		final int baseX = 100,  baseY = 100,
				   baseSegmentoX = 10,
				   baseSegmentoY = 10;
		ArrayList<Punto> listaPuntos;
		listaPuntos = Algoritmos.generaPuntosAleatorios(baseX, baseY, baseSegmentoX, baseSegmentoY);
		//listaPuntos = Algoritmos.damePuntos();
		Algoritmos.ordenaPorAnguloRespectoP0(listaPuntos);
		convexHull = GrahamAlgorithm.GrahamScan(listaPuntos);
		//System.out.println("Salida del ConvexHull:");
		for(int i = 0; i < convexHull.size(); i++){
			if(i != convexHull.size()-1 )
				System.out.println(convexHull.get(i));
			else
				System.out.print(convexHull.get(i));
		}
	}
	
	public static void main(String[] args) 
	{
		Interfaz interfaz = new Interfaz();
		boolean test = true;
		
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
