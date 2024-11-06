/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

/**
 *
 * @author albed
 */
public class tabulacion {


    // Método para generar y mostrar la tabla de combinaciones
    public static void combinacionTabla(int n) {
        // Validar que n sea un número no negativo
        if (n < 0) {
            throw new IllegalArgumentException("El valor de n debe ser mayor o igual a 0.");
        }

        // Crear la tabla bidimensional
        int[][] tabla = new int[n + 1][n + 1];

        // Llenar la tabla utilizando las condiciones de borde y la relación de recurrencia
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                // Asignar 4 en los bordes de la tabla
                if (j == 0 || j == i) {
                    tabla[i][j] = 4;
                } else {
                    // Usar la relación de recurrencia para valores internos
                    tabla[i][j] = tabla[i][j - 1] + tabla[i - 1][j];
                }
            }
        }

        // Imprimir la tabla de combinaciones
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("%5d", tabla[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Tamaño de la tabla (n)
        int n = 5;

        // Llamar al método para generar y mostrar la tabla
        combinacionTabla(n);
    }
}

  