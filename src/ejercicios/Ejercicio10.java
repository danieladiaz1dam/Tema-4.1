package ejercicios;

import java.util.Scanner;

/*
 * Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores enteros
 * aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N y mostrará
 * en qué posiciones del array aparece N. 
 */

public class Ejercicio10 {
	public static void main(String[] args) {
		// Crear tabla
		int[] numeros = new int[100];
		int n = 0;
		Scanner sc = new Scanner(System.in);

		// Rellenar tabla
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 10 + 1);
		}

		// Pedir numero a buscar
		do {
			System.out.printf("Que valor quieres buscar?: ");
			n = sc.nextInt();
		} while (n < 1 || n > 10);

		// Imprimir indices encontrados
		for (int i = 0; i < numeros.length; i++) {
			if (n == numeros[i])
				System.out.printf("Encontrado en la pos: %d\n", i);
		}

		sc.close();
	}
}
