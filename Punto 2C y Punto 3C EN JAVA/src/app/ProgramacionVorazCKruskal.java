package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProgramacionVorazCKruskal {

	
	
	public int [][] crearGrafoPrueba (){
		
		// Valores en millónes de pesos (COP)
		
		
		int [][] matriz =  {{ 0,  120,  300,   0 },  // Conexiones desde el municipio 0
							{ 120,  0,  180, 400},  // Conexiones desde el municipio 1
							{ 300,180,  0,   200},  // Conexiones desde el municipio 2
							{ 0,  400,  200,   0  }   };  // Conexiones desde el municipio 3
					
		
		return matriz;
		
	}
	
	public ArrayList<Arista> encontrarArbolMinimo (int [][] grafo){
		
		
		
		ArrayList<Arista> aristas = new ArrayList<Arista>();
		 ArrayList<Arista> respuesta = new ArrayList<>();
		 
		for (int i = 0; i < grafo.length; i++) {
			
			for (int j = i+1; j < grafo.length; j++) {
				
				
				if (j!=i && grafo [i][j] != 0){
					
					aristas.add(new Arista (i,j , grafo[i][j]));
				}
			}	
		}
		// Se ordenan las aristas de menor a mayor
		Collections.sort(aristas, Comparator.comparingInt(a -> a.peso));
		
		 // Estructuras para el algoritmo de Kruskal: union-find
	    int[] padre = new int[grafo.length];
	    int[] rango = new int[grafo.length];
	    
	    //  estructura de conjuntos disjuntos
	    for (int i = 0; i < grafo.length; i++) {
	        padre[i] = i;
	        rango[i] = 0;
	    }



	    // algoritmo de Kruskal
	    for (Arista arista : aristas) {
	        int origen = arista.origen;
	        int destino = arista.destino;
	        
	 
	        if (hallarNodoPadre(origen, padre) != hallarNodoPadre(destino, padre)) {
	        	respuesta.add(arista); // Agregar la arista al ARM
	            unir(origen, destino, padre, rango); // Unir los conjuntos
	        }

	        // Si hemos agregado n-1 aristas, ya tenemos el ARM completo
	        if (respuesta.size() == grafo.length - 1) {
	            break;
	        }
	    }

		
		return respuesta;
	}

	
	
	// Método para encontrar el representante (raíz) del conjunto al que pertenece 'nodo'
	public int hallarNodoPadre(int nodo, int[] padre) {
	    
	    int nodoOriginal = nodo;
	    
	    // Repetimos el bucle hasta encontrar la raíz
	    while (padre[nodo] != nodo) {
	        nodo = padre[nodo];  // Subimos un nivel en el árbol
	    }
	    
	    // Ahora 'nodo' es la raíz del conjunto
	    int raiz = nodo;

	    // Compresión de caminos: hacemos que todos los nodos intermedios apunten a la raíz
	    nodo = nodoOriginal;
	    while (padre[nodo] != nodo) {
	        int siguiente = padre[nodo];  // Guardamos el padre actual antes de modificarlo
	        padre[nodo] = raiz;  // Hacemos que el nodo apunte directamente a la raíz
	        nodo = siguiente;  // Subimos un nivel en el árbol
	    }

	    return raiz;
	}

	// Método para unir dos conjuntos (por rango)
	void unir(int nodo1, int nodo2, int[] padre, int[] rango) {
	    // Encontramos las raíces de ambos conjuntos
	    int raiz1 = hallarNodoPadre(nodo1, padre);
	    int raiz2 = hallarNodoPadre(nodo2, padre);

	    // Si las raíces son diferentes, unimos los conjuntos, para evitar ciclos
	    if (raiz1 != raiz2) {
	        // Unimos el conjunto con menor rango al conjunto con mayor rango
	        if (rango[raiz1] < rango[raiz2]) {
	            padre[raiz1] = raiz2;  // La raíz de nodo1 ahora pertenece al conjunto de nodo2
	        } else if (rango[raiz1] > rango[raiz2]) {
	            padre[raiz2] = raiz1;  // La raíz de nodo2 ahora pertenece al conjunto de nodo1
	        } else {
	            // Si ambos tienen el mismo rango, unimos uno al otro y aumentamos el rango de la nueva raíz
	            padre[raiz2] = raiz1;
	            rango[raiz1]++;
	        }
	    }
	}
	
	
	
	// [0,1,120] se mete la lista de aristas com respuesta
	//{0,0,2,3}
	//{1,0,0,0}
	
	// [1,2,180] se introduce la arista a la lista solucion 
	// {0,0,0,3}
	//{1,0,0,0}
	
	// [2,3,200] se mete la lista de aristas com respuesta
	// {0,0,0,0}
	// {1,0,0,0}
	
}
