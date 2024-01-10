package ejercicios;

import java.util.Scanner;

/*
 * Escribe un programa que lea 10 números por teclado y que luego los muestre en orden inverso,
 * es decir, el primero que se introduce es el último en mostrarse.
 */

public class Ejercicio07 {
	public static void main(String[] args) {
		// Crear tabla
		int[] numeros = new int[10];
		Scanner sc = new Scanner(System.in);

		// Rellenar la tabla
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("Numero #%d: ", i + 1);
			numeros[i] = sc.nextInt();
		}

		// Imprimir la tabla al reves
		for (int i = numeros.length - 1; i >= 0; i--) {
			System.out.printf("%d ", numeros[i]);
		}

		sc.close();
	}

}
