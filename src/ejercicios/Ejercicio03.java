package ejercicios;

import java.util.Arrays;

/*
 * Escribir la función int[] rellenaPares(int longitud, int fin), que crea y devuelve una
 * tabla ordenada de la longitud especificada, que se encuentra rellena con números
 * pares aleatorios comprendidos entre 2 hasta fin inclusive.
 */

public class Ejercicio03 {
	/**
	 * Rellena un array con numeros pares
	 * 
	 * @param longitud Tamaño del array
	 * @param fin      Numero mas alto que generar
	 * @return
	 */
	public static int[] rellenaPares(int longitud, int fin) {
		int numeroRandom;
		int arr[] = new int[longitud];
		int pos = 0;

		// Mientras que no hayamos llegado a la longitud especificada
		while (pos < longitud) {
			// Generar un numero random entre 2 y fin
			numeroRandom = (int) (2 + Math.random() * (fin + 1));

			// Si es par
			if (numeroRandom % 2 == 0) {
				// Guardarlo en el array
				arr[pos] = numeroRandom;
				// Sumar una posicion
				pos++;
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int arr[] = rellenaPares(20, 100);

		System.out.println(Arrays.toString(arr));
	}
}
