package com.algoritmia;

import java.util.ArrayList;
import java.util.Stack;
import com.algoritmia.Algoritmos;
import com.algoritmia.utileria.Punto;

public class GrahamAlgorithm {
	
	public GrahamAlgorithm() {

	}
	
	/**
	 * GrahamScan(listaPuntos) => PilaPuntos en Casco Convexo.
	 *  - listaPuntos debe estar ordenada por angulo polar con
	 *    respecto al punto mas pequeño en Y.
	 *    (y en X si hay 2 o mas puntos Y similares)
	 */
	public static Stack<Punto> GrahamScan(ArrayList<Punto> listaPuntos){
		
		int tmp;
		Punto pp0, pp1, pp2;
		Stack<Punto> S = null;
		ArrayList<Punto> Q = new ArrayList<Punto>(listaPuntos);
		Punto p0 = Algoritmos.damePuntoMasBajo(Q);
		Q.remove(p0);     /* Q = {p1, p2, ... , pn}*/
		/*System.out.println("Puntos Graham - p0: ");
		for(int i = 0 ; i < Q.size(); i++){
			System.out.println(Q.get(i));
		}*/
		S = new Stack<Punto>();
		S.push(p0);		  /* p0 */
		S.push(Q.get(0)); /* p1 */
		S.push(Q.get(1)); /* p2 */
		//System.out.println("\n");
		for(int i = 2; i < Q.size(); i++){
			while( true ){
				pp0 = S.elementAt(S.size()-2);
				pp1 = S.peek();
				pp2 =  Q.get(i);
				tmp = Algoritmos.productoCruz(pp0,pp1,pp2);
				//System.out.println("P0: "+pp0);
				//System.out.println("P1: "+pp1);
				//System.out.println("p2: "+pp2);
				//System.out.println(" Rotación: "+tmp);
				if (tmp >= 0) break;
				S.pop();
				//System.out.println("Sacando "+S.pop());
			}
			S.push(Q.get(i));
		}
		return S;
	}
}
