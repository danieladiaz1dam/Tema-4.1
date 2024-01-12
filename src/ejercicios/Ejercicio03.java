package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Crea un programa que pida al usuario 20 valores enteros e introduzca los 10
 * primeros en un array y los 10 últimos en otro array.
 * Por último, comparará ambos arrays y le dirá al usuario si son iguales o no.
 */

public class Ejercicio03 {
	public static void main(String[] args) {
		// Crear arrays
		int arr1[] = new int[10];
		int arr2[] = new int[10];
		// Scanner
		Scanner sc = new Scanner(System.in);

		// Rellenar el primer array
		System.out.println("Rellena el primer array");
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = Helper.pedirInt(sc, String.format("Introduce el numero (%d/%d)", i + 1, arr1.length));
		}

		// Rellenar el segundo array
		System.out.println("\n\nRellena el seundo array");
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = Helper.pedirInt(sc, String.format("Introduce el numero (%d/%d)", i + 1, arr2.length));
		}

		// Imprimir si on iguales o distintas
		System.out.println(Arrays.equals(arr1, arr2) ? "Son iguales" : "Son distintas");

		sc.close();
	}
}
