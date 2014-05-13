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
		
		int crossProd;
		Punto nextToTop, top, pn;
		Stack<Punto> S = null;
		ArrayList<Punto> Q = new ArrayList<Punto>(listaPuntos);
		Punto p0 = Q.get(0);
		Q.remove(0);      /* Q = {p1, p2, ... , pn}*/
		S = new Stack<Punto>();
		S.push(p0);		  /* p0 */
		S.push(Q.get(0)); /* p1 */
		S.push(Q.get(1)); /* p2 */
		for(int i = 2; i < Q.size(); i++){
			while( true ){ /* while nonleft turn */
				nextToTop = S.elementAt(S.size()-2);
				top       = S.peek();
				pn        = Q.get(i);
				crossProd = Algoritmos.productoCruz(nextToTop,top,pn);
				if (crossProd >= 0){ /* left turn */
					break;
				}
				S.pop();
			}
			S.push(pn);
		}
		return S;
	}
}
