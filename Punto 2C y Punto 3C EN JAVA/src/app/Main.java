package app;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	
		System.out.println("Prueba del algoritmo de kruskal para arbol de recubrimiento mínimo");
		System.out.println();
		// probando KRUSKAL
		ProgramacionVorazCKruskal progra = new ProgramacionVorazCKruskal();
		
		int [][] grafo = progra.crearGrafoPrueba();
		
		
		ArrayList <Arista> resultado = progra.encontrarArbolMinimo(grafo);
		
		for (int i = 0; i < resultado.size(); i++) {
			
			System.out.println(resultado.get(i).origen);
			System.out.println(resultado.get(i).peso);
			System.out.println(resultado.get(i).destino);
			
			System.out.println("***");
			
		}
		
		// probando MOCHILA por DINÁMICA
		
		
		System.out.println("====================================");
		System.out.println("Prueba del algoritmo de la mochila por programación Dinámica");
		System.out.println();
		
		
		ProgramacionDinamicaCMochila mochila =new ProgramacionDinamicaCMochila ();
		
		
		 // Datos proporcionados
        int[] pesos = {1, 3, 4, 5, 7}; // Pesos de los objetos
        int[] valores = {2, 5, 10, 14, 15}; // Valores de los objetos
        int capacidad = 8; // Capacidad de la mochila

        int maxValue = mochila.algoritmoMochila(pesos, valores, capacidad);
        System.out.println("El valor máximo que se puede obtener es: " + maxValue);
		
		
		
		
	}

}
