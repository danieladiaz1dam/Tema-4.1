package ejercicios;

import java.util.Scanner;

/*
 * Diseñar un programa que solicite al usuario 5 números decimales y los almacene en una tabla.
 * Utiliza el mismo bucle tanto para solicitar los 5 números como para almacenarlos en la tabla.
 * A continuación, en un bucle distinto, mostrar por consola los números en el mismo orden en el
 * que se han introducido.
 */

public class Ejercicio03 {
	public static void main(String[] args) {
		// Crear tabla
		int[] numeros = new int[5];
		Scanner sc = new Scanner(System.in);

		// Pedir datos al usuario y rellenar la tabla
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("Introduce el numero #%d: ", i + 1);
			numeros[i] = sc.nextInt();
		}

		// Imprimir la tabla
		System.out.printf("\nHas introducido los siguientes numeros:\n");
		for (int num : numeros) {
			System.out.printf("%d ", num);
		}
		
		sc.close();
	}
}
