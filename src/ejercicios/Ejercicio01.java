package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Crea un programa que pida al usuario dos valores N y M y luego cree
 * un array de tamaño N que contenga M en todas sus posiciones.
 * Luego muestra el array por pantalla.
 */

/*
 * Prubas de entrada
 * 
 * Tamaño del array (min: 0): > f
 * Dato inválido.
 * Tamaño del array (min: 0): > -5
 * Tamaño del array (min: 0): > 3
 * Numero para rellenar: > f
 * Dato inválido.
 * Numero para rellenar: > 3
 * [3, 3, 3]
 *  
 */
public class Ejercicio01 {
	public static void main(String[] args) {
		// Tamaño y numero para el array
		int n, m;
		int[] tabla;
		Scanner sc = new Scanner(System.in);

		// Pedir tamaño y numero para rellenar
		n = Helper.pedirInt(sc, "Tamaño del array", 0);

		m = Helper.pedirInt(sc, "Numero para rellenar");

		// Crea un nuevo array de tamaño N
		tabla = new int[n];

		// Rellenar tabla
		Arrays.fill(tabla, m);

		// Imprimir tabla
		System.out.printf("%s\n", Arrays.toString(tabla));

		// Close scanner
		sc.close();
	}
}
