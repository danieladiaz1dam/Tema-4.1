package ejercicios;

import java.util.Scanner;

/*
 * Realiza un programa que pida 8 números enteros y los almacene en una tabla.
 * A continuación, en un bucle distinto, recorrerá esa tabla y mostrará esos
 * números junto con la palabra “par” o “impar” según proceda.
 */

public class Ejercicio06 {
	/**
	 * Mira si un numero es par
	 * 
	 * @param n el numero
	 * @return "par" o "impar"
	 */
	public static String parImpar(int n) {
		if (n % 2 == 0)
			return "par";
		else
			return "impar";
	}
	
	public static void main(String[] args) {
		// Crear tabla
		int[] numeros = new int[8];
		Scanner sc = new Scanner(System.in);
		
		// Rellenar la tabla
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("Numero #%d: ", i + 1);
			numeros[i] = sc.nextInt();
		}
		
		// Imprimir si el numero es par
		for (int i : numeros) {
			System.out.printf("%d es %s\n", i, parImpar(i));
		}
		
		sc.close();
	}
}
