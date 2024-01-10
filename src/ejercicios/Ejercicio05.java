package ejercicios;

import java.util.Scanner;

/*
 * Crea un programa que pida diez números reales por teclado,
 * los almacene en un array, y luego lo recorra para averiguar
 * el máximo y mínimo y mostrarlos por pantalla.
 */

public class Ejercicio05 {
	/**
	 * Encontrar el numero mas grande en un array
	 * 
	 * @param arr Array
	 * @return Numero mayor
	 */
	public static int max(int[] arr) {
		if (arr.length == 0) {
			// throw exception
			return 0;
		}

		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}

		return max;
	}

	/**
	 * Encontrar el numero mas pequeño en un array
	 * 
	 * @param arr Array
	 * @return Numero menor
	 */
	public static int min(int[] arr) {
		if (arr.length == 0) {
			// throw exception
			return 0;
		}

		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i])
				min = arr[i];
		}

		return min;
	}

	public static void main(String[] args) {
		// Crear tabla
		int[] numeros = new int[10];
		Scanner sc = new Scanner(System.in);

		// Pedir datos al usuario y guardarlos en la tabla
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("Numero #%d: ", i + 1);
			numeros[i] = sc.nextInt();
		}
		
		System.out.printf("Numero mas grande: %d\n", max(numeros));
		System.out.printf("Numero mas pequeño: %d\n", min(numeros));
		
		sc.close();
	}
}
