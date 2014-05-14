package com.algoritmia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.algoritmia.utileria.ComparaPuntoPorAngulo;
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
	
	/*
	 * TODO:
	 * - Demostrar que al momento de ordenar, p0 no se mueve del indice 0 	
	 * 
	 */
	public static void ordenaPorAnguloRespectoP0(ArrayList<Punto> listaPuntos){
		Punto p0 = damePuntoMasBajo(listaPuntos);
		Collections.sort(listaPuntos, new ComparaPuntoPorAngulo(p0));
		System.out.println("Lista después de ser ordenada: ");
		mostrarListaDePuntos(listaPuntos);
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
	
	/**
	 * Usado para saber direccion de p1 a p2 con respecto a p0.
	 * @param p0 punto origen
	 * @param p1 punto
	 * @param p2
	 * @return entero negativo si es sentido anti-horario,
	 *         entero positivo si es sentido horario y
	 *         0 si los puntos son colineales.
	 */
	public static int productoCruz(Punto p0, Punto p1, Punto p2){
		int y0 = p0.getY(),
			y1 = p1.getY(),
			y2 = p2.getY(),
			x0 = p0.getX(),
			x1 = p1.getX(),
			x2 = p2.getX();
		return (y2 - y0)*(x1 - x0) - (y1 - y0)*(x2 - x0);
	}

	/* metodo temporal para mostrar puntos */
	private static void mostrarListaDePuntos(ArrayList<Punto> listaPuntos){
		System.out.println(listaPuntos.size());
		for(int i = 0; i < listaPuntos.size(); i++){
			System.out.println(listaPuntos.get(i));
		}
	}

	/* metodo temporal para probar con puntos pre-establecidos*/
	public static ArrayList<Punto> damePuntos(){
		ArrayList<Punto> lista = new ArrayList<Punto>();
		lista.add(new Punto(3, 10));
		lista.add(new Punto(8, 10));
		lista.add(new Punto(5, 7));
		lista.add(new Punto(7, 7));
		lista.add(new Punto(11, 7));
		lista.add(new Punto(1, 5));
		lista.add(new Punto(3, 4));
		lista.add(new Punto(6, 3));
		lista.add(new Punto(8, 3));
		lista.add(new Punto(5, 2));
		return lista;
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
	    	int aox = a.getOrigen().getX();
	    	int aoy = a.getOrigen().getY();
	    	int adx = a.getDestino().getX();
	    	int ady = a.getDestino().getY();
	    	int box = b.getOrigen().getX();
	    	int boy = b.getOrigen().getX();
	    	int bdx = b.getDestino().getX();
	    	int bdy = b.getDestino().getY();
	    	
		    pendiente1 = (aox == adx) ?
		                  (Double.POSITIVE_INFINITY) :
		                  ((ady - aoy) / (adx - aox));
	
		    pendiente2 = (box == bdx) ?
		    	         (Double.POSITIVE_INFINITY) :
		    	         ((bdy - boy) / (bdx - box));
	
	
		    if( Double.compare(pendiente1, pendiente2) == 0 )
		    {
		        //Pendientes iguales, hay de 2 sopas
		        //o son paralelas o son la misma linea
		        if( aoy - (pendiente1 * aox) == boy - (pendiente2 * box) )
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
		    	
		        x = (pendiente1 * aox - aoy -
		             pendiente2 * box + boy /
		             (pendiente1 - pendiente2));
	
		        if( aox == adx)
		        {
		            x = aox;
		        }
	
		        if( box == bdx)
		        {
		            x = box;
		        }
	
		        y = pendiente1 * (x - aox) + aoy;
	
		        if( aox == adx )
		        {
		            y = pendiente2 * (x - box) + boy;
		        }
		        
		        puntosResultantes.add(new Punto((int)x, (int)y));
		    }
	    }
	    
	    return puntosResultantes;
	}
}