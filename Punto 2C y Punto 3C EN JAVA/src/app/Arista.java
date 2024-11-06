package app;

import java.util.Comparator;

public class Arista {

	
	public int peso;
	
	public int origen;
	
	public int destino;
	
	
	
	public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}
	
	
	 public static Comparator<Arista> comparadorPorPeso = new Comparator<Arista>() {
	        public int compare(Arista a1, Arista a2) {
	            return a1.peso - a2.peso; // Orden ascendente por peso
	        }
	    };
	
	
	
}
