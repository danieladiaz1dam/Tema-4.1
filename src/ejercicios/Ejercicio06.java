package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Crea un programa que cree un array de tamaño 1000 y lo rellene con valores
 * enteros aleatorios entre 0 y 99 (utiliza Math.random()*100).
 * Luego pedirá por teclado un valor N y se mostrará por pantalla
 * si N existe en el array, además de cuantas veces. 
 */

public class Ejercicio06 {
	public static void main(String[] args) {
		// crear array
		int arr[] = new int[1000];
		// numero para buscar
		int num;
		// contador
		int contador = 0;
		// scanner
		Scanner sc = new Scanner(System.in);

		// rellenar array
		for (int i = 0; i < arr.length; i++)
			arr[i] = (int) (Math.random() * 100);

		// ordenar la tabla
		Arrays.sort(arr);

		// Pedir numero a buscar
		num = Helper.pedirInt(sc, "Que numero quieres buscar?", 0, 99);

		// si num esta en la tabla
		if (Arrays.binarySearch(arr, num) > 0) {
			// Buscar cuantas veces esta en la tabla
			for (int n : arr) {
				if (n == num) {
					contador++;
				}
			}
		}

		// mirar si esta y cuantas veces
		if (contador > 0)
			System.out.printf("El numero %d se encuentra %d veces en la tabla.", num, contador);
		else
			System.out.printf("El numero %d no se encuentra en la tabla.", num);

		sc.close();
	}
}
