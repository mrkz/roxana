package com.algoritmia;

import java.util.ArrayList;
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
	public static ArrayList<Punto> generaPuntos(double baseTotal, double alturaTotal,
												double baseDeSegmento, double alturaDeSegmento) {
		double puntosEnY, puntosEnX;
		double x, y; // temporales para crear puntos
		ArrayList<Punto> listaDePuntos = new ArrayList<Punto>();
		puntosEnY = (int)(baseTotal   / baseDeSegmento);
		puntosEnX = (int)(alturaTotal / alturaDeSegmento);
		//System.out.println("Habrán "+puntosEnX+" Puntos en X y "+puntosEnY+" Puntos en Y");
		for (int i = 0; i < baseTotal ; i+=baseDeSegmento) {
			for (int j = 0; j < alturaTotal; j+=alturaDeSegmento) {
				x = ((int)(Math.random() * baseDeSegmento+i));
				y = ((int)(Math.random() * alturaDeSegmento+j));
				listaDePuntos.add(new Punto((int)x,(int)y));
				//System.out.println(((int)(Math.random() * baseDeSegmento+i))+", "+((int)(Math.random() * alturaDeSegmento+j)));
			}
		}
		return listaDePuntos;
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