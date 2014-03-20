package com.algoritmia;

import java.util.ArrayList;
import java.util.Stack;

import com.algoritmia.Algoritmos;
import com.algoritmia.utileria.Punto;

public class GrahamAlgorithm {
	
	public GrahamAlgorithm() {

	}
	
	public static Stack<Punto> GrahamScan(ArrayList<Punto> listaPuntos){
		Stack<Punto> S = null;
		ArrayList<Punto> Q = new ArrayList<Punto>(listaPuntos);
		Punto p0 = Algoritmos.damePuntoMasBajo(Q);
		Q.remove(p0);
		/*
		 * TODO: - check order in Q {must be: sorted by polar angle 
		 *         counterclockwise order around p0}
		 * */
		return S;
	}
}
