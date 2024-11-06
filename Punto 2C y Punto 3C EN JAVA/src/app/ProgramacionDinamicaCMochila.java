package app;

public class ProgramacionDinamicaCMochila {
	
	// Funci�n que resuelve el problema de la mochila
    public int algoritmoMochila(int[] pesos, int[] valores, int capacidad) {
        int n = valores.length;
        // Crear una tabla para almacenar los valores m�ximos
        int[][] matriz = new int[n + 1][capacidad + 1];

        // Llenar la tabla de forma bottom-up
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (i == 0 || j == 0) {
                    matriz[i][j] = 0; // caso base
                } else if (pesos[i - 1] <= j) {      
                	//Ac� se maximiza el valor
              
                	// Valor del objeto actual
                	int valorActual = valores[i - 1];

                	// Peso del objeto actual
                	int pesoActual = pesos[i - 1];

                	// Valor m�ximo si incluimos el objeto actual
                	int valorConObjeto = valorActual + matriz[i - 1][j - pesoActual];

                	// Valor m�ximo si no incluimos el objeto actual
                	int valorSinObjeto = matriz[i - 1][j];

                	// se calcula el m�ximo entre incluir y no incluir el objeto
                	matriz[i][j] = Math.max(valorConObjeto, valorSinObjeto);
                	
                	} else {
                    matriz[i][j] = matriz[i - 1][j]; // Excluye el item
                }
            }
        }
        return matriz[n][capacidad]; // El valor m�ximo que se puede obtener
    }


}
