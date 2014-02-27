package com.algoritmia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.algoritmia.utileria.Punto;
import com.algoritmia.utileria.Recta;

/**
 * 
 * @author seguame
 *
 */

public class Algoritmos
{
	/**
	 * baseX = Base total del mapa en el eje X
	 * baseY = Base total del mapa en el eje Y
	 * baseSegmentoX = Tamaño de la colonia en el eje X
	 * baseSegmentoY = Tamaño de la colonia en el eje Y 
	 **/
	public static ArrayList<Punto> generaPuntosAleatorios(int baseX, int baseY,
									   				int baseSegmentoX, int baseSegmentoY){
		ArrayList<Punto> listaPuntos = new ArrayList<Punto>();
		
		if(baseSegmentoX > baseX) 	baseSegmentoX = baseX;
		if(baseSegmentoY > baseY)	baseSegmentoY = baseY;
		
		int x, y,
			numSegmentosX = baseX / baseSegmentoX,
			numSegmentosY = baseY / baseSegmentoY,
			numPuntos     = numSegmentosX * numSegmentosY;
			System.out.println("se generarán: "+numPuntos+" puntos...");
		
		for(int i = 0; i < numSegmentosX; i++){
			for(int j = 0; j < numSegmentosY; j++){
				x = (baseSegmentoX * i) + (int)(Math.random() * baseSegmentoX);
				y = (baseSegmentoY * j) + (int)(Math.random() * baseSegmentoY);
				listaPuntos.add(new Punto(x, y));
			}
		}
		return listaPuntos;
	}
	
	/**
	 * compara angulos de p1 y p2 respecto a p0
	 * regresa:
	 *  -1 si angulo p1 < p2
	 *  0  si p1 = p2
	 *  1  si p1 > p2 
	 */
	public static int puntoMenorRespectoP0(Punto p0, Punto p1, Punto p2){
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
	
	public static Punto damePuntoMasBajo(ArrayList<Punto> listaPuntos){
		Punto p0, puntoN;
		Iterator<Punto> iter = listaPuntos.iterator();
		p0 = iter.next();
		while(iter.hasNext()){
			puntoN = iter.next();
			if(p0.compareTo(puntoN) > 0){
				p0 = puntoN;
			}
		}
		return p0;
	}

	public static ArrayList<Punto> interseccion(List<Recta> aa, List<Recta> bb)
	{
		double pendiente1;
	    double pendiente2;
	    
	    double x, y;
	    
	    int tamanioListas = aa.size();
	    
	    ArrayList<Punto> puntosResultantes = new ArrayList<Punto>(tamanioListas); 
	    
	    Recta a,b;
	    
	    /*
	     * TODO: a discutir lo siguiente.
	     * Se supone que los casos en que la pendiente sea infinita 
	     * o que las rectas sean paralelas lo tendremos controlado
	     * quizá convenga quitar las comprobaciones para ahorrar tiempo
	     * de procesador
	     */
	    for(int i = 0; i < tamanioListas; i++)
	    {
	    	a = aa.get(i);
	    	b = bb.get(i);
	    	
		    pendiente1 = (a.getOrigen().getX() == a.getDestino().getX()) ?
		                  (Double.POSITIVE_INFINITY) :
		                  ((a.getDestino().getY() - a.getOrigen().getY()) / (a.getDestino().getX() - a.getOrigen().getX()));
	
		    pendiente2 = (b.getOrigen().getX() == b.getDestino().getX()) ?
		    	         (Double.POSITIVE_INFINITY) :
		    	         ((b.getDestino().getY() - b.getOrigen().getY()) / (b.getDestino().getX() - b.getOrigen().getX()));
	
	
		    if( Double.compare(pendiente1, pendiente2) == 0 )
		    {
		        //Pendientes iguales, hay de 2 sopas
		        //o son paralelas o son la misma linea
		        if( a.getOrigen().getY() - (pendiente1 * a.getOrigen().getX()) == b.getOrigen().getY() - (pendiente2 * b.getOrigen().getX()) )
		        {
		            System.err.println("intersectan en muchos puntos");
		        }
		        else
		        {
		        	System.err.println("son paralelas y nunca se tocan");
		        }
		        
		        //No añadirlo a la lista de puntos resultantes
		        //TODO: lanzar una Exception?
		        //return null;
		    }
		    else
		    {
		        //Lineas que se llegan a tocar
		    	
		    	//FIXME:
		    	//Es un ciclo for que cada instante está obteniendo las referencias
		    	//cada vuelta, simpliciarlo para que no acceda mas de lo requerido
		    	//a otros cammpos
		        x = (pendiente1 * a.getOrigen().getX() - a.getOrigen().getY() -
		             pendiente2 * b.getOrigen().getX() + b.getOrigen().getY() /
		             (pendiente1 - pendiente2));
	
		        if( a.getOrigen().getX() == a.getDestino().getX())
		        {
		            x = a.getOrigen().getX();
		        }
	
		        if( b.getOrigen().getX() == b.getDestino().getX())
		        {
		            x = b.getOrigen().getX();
		        }
	
		        y = pendiente1 * (x - a.getOrigen().getX()) + a.getOrigen().getY();
	
		        if( a.getOrigen().getX() == a.getDestino().getX() )
		        {
		            y = pendiente2 * (x - b.getOrigen().getX()) + b.getOrigen().getY();
		        }
		        
		        puntosResultantes.add(new Punto((int)x, (int)y));
		    }
	    }
	    
	    return puntosResultantes;
	}
}