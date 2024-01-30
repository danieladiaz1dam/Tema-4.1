package ejercicio01;

import java.util.Scanner;

import helper.Helper;

/*
 * ¿Dónde está la mosca? Vamos a intentar cazar una mosca. La mosca será un valor que se
 * introduce en una posición de un vector; el jugador no ve el panel pero sí ve las casillas
 * a las que puede golpear. Si la mosca está en esa posición se acaba el juego, mosca cazada.
 * Si la mosca no está en esa posición pueden ocurrir dos cosas: que la mosca esté en casillas
 * adyacentes, en cuyo caso la mosca revolotea y se sitúa en otra casilla; o que la mosca no
 * esté en casillas adyacentes, en este caso la mosca permanece donde está.
 */

public class Main {
	static final String BLUE = "\u001b[36m";
	static final String RED = "\u001b[31m";
	static final String RESET = "\u001b[0m";

	public static void main(String[] args) {
		// Mosca
		Mosca fly;
		// Scanner
		Scanner sc = new Scanner(System.in);
		// Dificultad
		int difficulty = 1;
		// Posicion del usuario
		Pos newPlayerPos = new Pos();

		// Elegir dificultad
		System.out.printf("-.- El juego de la mosca -.-\n\n");
		System.out.printf("Selecciona una dificultad:\n");
		System.out.printf("0: Facil\n1: Normal\n2: Dificil\n");
		difficulty = Helper.pedirInt(sc, " > ", 0, 2);

		// Inicializar mosca
		fly = new Mosca(difficulty);
		
		System.out.printf("\n\n");

		// Jugar
		do {
			// Imprimir tablero
			fly.printBoard();

			// Preguntar nueva posicion para el usuario
			System.out.printf("Donde quieres golpear?\n");
			newPlayerPos.x = Helper.pedirInt(sc, "X > ");
			newPlayerPos.y = Helper.pedirInt(sc, "Y > ");

			// Mover al jugador
			if (!fly.movePlayer(newPlayerPos))
				System.out.printf("%sPosicion inválida.%\n", RED, RESET);
			else
				if (fly.moveMosca())
					System.out.printf("La mosca ha volado.\n");
			
			System.out.printf("\n\n");
		} while (!fly.win());

		System.out.printf("Has ganado!!\n");
		
		sc.close();
	}
}
