package ejercicios;

import java.util.Arrays;

/*
 * Realiza un programa que cree dos tablas, la primera con los 6 números
 * de una apuesta de la primitiva generados aleatoriamente entre 1 y 49
 * y, la segunda (ordenada) con los 6 números de la combinación ganadora.
 * La función devolverá el número de aciertos.
 */

public class Ejercicio07 {
	public static void main(String[] args) {
		// tabla con numeros aleatorios
		int arr1[] = new int[6];
		// combinacion ganadora
		int arr2[] = { 5, 22, 37, 19, 48, 3 };
		// contador aciertos
		int contador = 0;

		// rellenar arr1 con numeros aleatorios
		for (int i = 0; i < arr1.length; i++)
			arr1[i] = (int) (1 + Math.random() * 49);

		// ordenar combinacion ganadora
		Arrays.sort(arr2);

		// Mirar si son igales
		if (Arrays.equals(arr1, arr2))
			System.out.printf("Has ganado!!!\n");
		else {
			// contar haciertos
			for (int num : arr1)
				if (Arrays.binarySearch(arr2, num) >= 0)
					contador++;

			System.out.println("Combinacion ganadora: " + Arrays.toString(arr2));
			System.out.println("Combinacion generada: " + Arrays.toString(arr1));
			System.out.printf("Numero de aciertos: %d", contador);
		}

	}
}
