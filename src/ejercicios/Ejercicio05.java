package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Necesitamos crear un programa para mostrar el ranking de puntuaciones de un
 * torneo de ajedrez con 8 jugadores. Se le pedirá al usuario que introduzca las
 * puntuaciones de todos los jugadores (habitualmente valores entre 1000 y 2800, de tipo entero)
 * y luego muestre las puntuaciones en orden descendente (de la más alta a la más baja).
 */

public class Ejercicio05 {
	public static void main(String[] args) {
		// Crear array
		int puntuaciones[] = new int[8];
		// Scanner
		Scanner sc = new Scanner(System.in);
		
		// Pedir puntuaciones
		for (int i = 0; i < puntuaciones.length; i++) {
			puntuaciones[i] = Helper.pedirInt(sc, String.format("Introduce la puntuacion del jugador #%d", i+1), 1000, 2800);
		}
		
		// Ordenadr puntuaciones
		Arrays.sort(puntuaciones);
		
		// Imprimir
		System.out.println("Puntuaciones Ordenadas:\n" + Arrays.toString(puntuaciones));
		
		sc.close();
	}
}
