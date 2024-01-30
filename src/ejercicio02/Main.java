package ejercicio02;

import java.util.Scanner;
import helper.Helper;

/*
 * Juego de las parejas. Se inicia un vector de n casillas (siendo n un número par) y se colocan al azar parejas de números.
 * Ese panel se oculta al jugador al que se le mostrará un panel vacío del que irá destapando de 2 en 2.
 * Si los números destapados coinciden se quedan visibles si no se muestran un segundo y luego se ocultan.
 * El jugador tratará de recordar qué números eran para encontrar a su pareja.
 */

public class Main {

	public static void displayStringForOneSecond(String message) {
		System.out.println(message);

		try {
			Thread.sleep(1000); // Pausa el hilo durante 1000 milisegundos (1 segundo)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.print("\n".repeat(20));
	}

	public static void main(String[] args) {
		// Array de parejas
		Parejas par = new Parejas(10);
		// Scanner
		Scanner sc = new Scanner(System.in);
		// Indices para comprobar
		int index1, index2;

		// Enseñar array de parejas por un segundo
		displayStringForOneSecond(par.printPartners());

		do {
			// Enseñar lo que lleva acertado
			System.out.printf("Aciertos: \n");
			par.printBoard();

			// Preguntar que indices quiere destapar
			System.out.println("Introduce los indices: ");
			index1 = Helper.pedirInt(sc, " > ");
			index2 = Helper.pedirInt(sc, " > ");

			// Si no se ha acertado
			if (!par.checkPair(index1, index2))
				// Enseñar el array completo por un segundo
				displayStringForOneSecond(par.printPartners());

			// Mientras no se gane
		} while (!par.win());

		// Si se gana, enseñar el tablero ya completado y decirle al usuario que ha
		// ganado
		System.out.println();
		par.printBoard();
		System.out.printf("Has Ganado !!");

		// Cerrar el scanner
		sc.close();
	}
}
