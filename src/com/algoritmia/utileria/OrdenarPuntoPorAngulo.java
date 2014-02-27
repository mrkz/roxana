package com.algoritmia.utileria;

import java.util.Comparator;

public class OrdenarPuntoPorAngulo implements Comparator<Punto> {
	private Punto p0;
	
	public OrdenarPuntoPorAngulo(Punto p){
		p0 = p;
	}

	/**
	 * compara angulos de p1 y p2 respecto a p0
	 * regresa:
	 *  -1 si angulo p1 < p2
	 *  0  si p1 = p2
	 *  1  si p1 > p2 
	 */
	@Override
	public int compare(Punto p1, Punto p2) {
		double p1Cot, p2Cot;
		int deltaX, deltaY;
		
		deltaX = p1.getX() - p0.getX();
		deltaY = p1.getY() - p0.getY();
		p1Cot  = Math.atan2(deltaY, deltaX);
		deltaX = p2.getX() - p0.getX();
		deltaY = p2.getY() - p0.getY();
		p2Cot  = Math.atan2(deltaY, deltaX);
		if(p1Cot < p2Cot) return -1;
		else if(p1Cot > p2Cot) return 1;
		return 0;
	}

}