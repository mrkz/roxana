package com.vcities;

import java.util.ArrayList;
import java.util.Stack;

import com.algoritmia.Algoritmos;
import com.algoritmia.GrahamAlgorithm;
import com.algoritmia.utileria.Punto;
import com.vcities.ui.Interfaz;

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
		for(int i = 0; i < convexHull.size(); i++){
			if(i != convexHull.size()-1 )
				System.out.println(convexHull.get(i));
			else
				System.out.print(convexHull.get(i));
		}
	}
	
	public static void main(String[] args) 
	{
		boolean test = true;
		if(test){
			testGraham();
		}
		
		new Interfaz();
	}

}
