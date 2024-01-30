package ejercicio05;

import java.util.Scanner;

import helper.Helper;

/*
 * Realizaremos el juego del buscaminas con un vector. 
 * El juego consiste en destapar todas las casillas de un vector menos las minas;
 * si pisamos una mina el juego acaba y hemos perdido.  El juego nos proporcionará pistas, de
 * forma que si destapamos una casilla y no hay una mina, esta casilla nos indicará cuantas
 * minas hay adyacentes a esa posición.
 * 
 * Por lo tanto, el ordenador debe preparar un panel de 20 casillas para nosotros en
 * el que colocará 6 minas y las pistas correspondientes.
 * 
 * Ejemplo: {0,1,*,1,1,*,*,2,*,1,0,0,0}
 */

public class Main {
	public static void main(String[] args) {
		// Campo de minas
		Minas mineField = new Minas();
		// Scanner
		Scanner sc = new Scanner(System.in);
		// Posicion para destapar
		int pos;

		// Jugar
		do {
			// Imprimir numeros del tablero
			System.out.printf("|");
			for (int i = 0; i < 20; i++) {
				System.out.printf("%2d |", i);
			}
			System.out.println("");
			
			// Imprimir tablero
			mineField.printKnownMineField();

			// Preguntar al usuario que posicion quiere destapar
			pos = Helper.pedirInt(sc, "Que posicion quieres mirar?: ", 0, 19);

			System.out.println();
			
			// Mientras que no se destape una mina
		} while (mineField.checkPos(pos) != -1 && mineField.getScore() <= 14);

		// Imprimir si el usuario ha ganado o perdido
		if (mineField.getScore() < 14) {
			System.out.printf("Has perdido mi niñe!\n");
			System.out.printf("Puntuacio: %d/14\n", mineField.getScore());
			mineField.printWholeMineField();
			
		} else {
			System.out.printf("Has ganade!\nselebration\n");
			System.out.printf("Puntuacio: %d/14\n", mineField.getScore());
			mineField.printWholeMineField();
		}
	}
}
