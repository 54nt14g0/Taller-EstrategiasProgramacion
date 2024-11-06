/*
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt para cambiar esta licencia
 * Haz clic en nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java para editar esta plantilla
 */
package prueba;
import java.util.*;

class Objeto {
    double peso;
    double valor;

    public Objeto(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    // Calcular la relación valor/peso
    public double valorPorPeso() {
        return valor / peso;
    }

    @Override
    public String toString() {
        return "Peso: " + peso + ", Valor: " + valor;
    }
}

class EmpaqueContenedor {
    double pesoMaximo; // Peso máximo que soporta el contenedor
    List<Objeto> objetos = new ArrayList<>();

    public EmpaqueContenedor(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public void agregarObjeto(double peso, double valor) {
        objetos.add(new Objeto(peso, valor));
    }

    // Maximizar el valor total
    public void maximizarValor() {
        // Ordenar por valor en orden descendente
        objetos.sort((a, b) -> Double.compare(b.valor, a.valor));

        double pesoTotal = 0;
        double valorTotal = 0;
        System.out.println("Maximización del Valor:");

        for (Objeto objeto : objetos) {
            if (pesoTotal + objeto.peso <= pesoMaximo) {
                pesoTotal += objeto.peso;
                valorTotal += objeto.valor;
                System.out.println(objeto);
            } else {
                // Fraccionar el objeto si el contenedor no soporta más peso
                double pesoRestante = pesoMaximo - pesoTotal;
                valorTotal += objeto.valor * (pesoRestante / objeto.peso);
                System.out.println("Fracción de: " + objeto + ", Peso fraccionado: " + pesoRestante);
                break;
            }
        }

        System.out.println("Valor total: " + valorTotal + ", Peso total: " + pesoTotal);
    }

    // Minimizar el peso total
    public void minimizarPeso() {
        // Ordenar por peso en orden ascendente
        objetos.sort(Comparator.comparingDouble(a -> a.peso));

        double pesoTotal = 0;
        double valorTotal = 0;
        System.out.println("\nMinimización del Peso:");

        for (Objeto objeto : objetos) {
            if (pesoTotal + objeto.peso <= pesoMaximo) {
                pesoTotal += objeto.peso;
                valorTotal += objeto.valor;
                System.out.println(objeto);
            } else {
                // Fraccionar el objeto si el contenedor no soporta más peso
                double pesoRestante = pesoMaximo - pesoTotal;
                valorTotal += objeto.valor * (pesoRestante / objeto.peso);
                System.out.println("Fracción de: " + objeto + ", Peso fraccionado: " + pesoRestante);
                break;
            }
        }

        System.out.println("Valor total: " + valorTotal + ", Peso total: " + pesoTotal);
    }

    // Maximizar el valor por unidad de peso (v/w)
    public void maximizarValorPorPeso() {
        // Ordenar por relación valor/peso (v/w) en orden descendente
        objetos.sort((a, b) -> Double.compare(b.valorPorPeso(), a.valorPorPeso()));

        double pesoTotal = 0;
        double valorTotal = 0;
        System.out.println("\nMaximización del Valor por Unidad de Peso:");

        for (Objeto objeto : objetos) {
            if (pesoTotal + objeto.peso <= pesoMaximo) {
                pesoTotal += objeto.peso;
                valorTotal += objeto.valor;
                System.out.println(objeto);
            } else {
                // Fraccionar el objeto si el contenedor no soporta más peso
                double pesoRestante = pesoMaximo - pesoTotal;
                valorTotal += objeto.valor * (pesoRestante / objeto.peso);
                pesoTotal += pesoRestante;
                System.out.println("Fracción de: " + objeto + ", Peso fraccionado: " + pesoRestante);
                break;
            }
        }

        System.out.println("Valor total: " + valorTotal + ", Peso total: " + pesoTotal);
    }
}

public class voraz {
    public static void main(String[] args) {
        EmpaqueContenedor contenedor = new EmpaqueContenedor(100);

        // Agregar los objetos (peso y valor)
        contenedor.agregarObjeto(10, 10);
        contenedor.agregarObjeto(20, 60);
        contenedor.agregarObjeto(30, 66);
        contenedor.agregarObjeto(40, 30);
        contenedor.agregarObjeto(50, 50);

        // Ejecutar las tres heurísticas
        contenedor.maximizarValor();
        contenedor.minimizarPeso();
        contenedor.maximizarValorPorPeso();
    }
}
