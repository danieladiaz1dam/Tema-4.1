package ejercicio04;

import java.util.Scanner;

import helper.Helper;

/*
 * Realiza el juego de los barquitos pero con un vector. Sólo se pondrán submarinos (barcos de una casilla).
 * El juego consiste en lo siguiente:
 * 
 * a. Los paneles serán de 20 posiciones.
 * 
 * b. Se pondrán 4 barcos: el ordenador coloca los suyos al azar y el jugador humano es preguntado.
 * Los barcos no pueden estar colocados de forma adyacente.
 * 
 * c. Después, por turnos, tira cada uno de los jugadores. El ordenador al azar y el humano es preguntado.
 * 
 * d. El juego termina cuando uno de los dos acaba con la flota del otro. 
 */

public class Main {
	public static void main(String[] args) {
		// Panel del jugador
		Flota player = new Flota();
		// Panel del ordenador
		Flota computer = new Flota();
		// Scanner
		Scanner sc = new Scanner(System.in);

		// posiciones de usuario
		int playerPanel[];
		int pos, i;

		// Preguntar al usuario donde quiere sus submarinos
		do {
			playerPanel = new int[20];
			i = 0;
			// Rellenar posiciones
			System.out.println(
					"Introduce los indices donde colocar tus submarinos:\nRecuerda que no pueden estar en casillas adyacentes!");

			while (i < 4) {
				pos = Helper.pedirInt(sc, "Submarino #%d: ".formatted(i + 1), 0, playerPanel.length - 1);

				if (playerPanel[pos] == 0) {
					playerPanel[pos] = 1;
					i++;
				}
			}
			System.out.println();

			// Comprobar si el panel es valido
		} while (!Flota.checkPanel(playerPanel));

		// Cuando el panel sea valido, inicializar el panel del jugador
		player = new Flota(playerPanel);

		/*
		 * // info para tests System.out.println("Panel del jugador: ");
		 * player.printWholePanel();
		 * 
		 * System.out.println("Panel del ordenador"); computer.printWholePanel();
		 * System.out.println("\n");
		 */

		// Jugar
		do {
			// Mostrar numero de las casillas
			System.out.printf("|");
			for (int j = 0; j < 20; j++) {
				System.out.printf("%2d|", j);
			}
			// Mostrar paneles
			System.out.println("\nPanel que conoce el jugador");
			player.printKnownPanel();
			System.out.println("\nPanel que conoce el ordenador");
			computer.printKnownPanel();

			// Turno del jugador
			pos = Helper.pedirInt(sc, "Donde quieres disparar?: ", 0, playerPanel.length - 1);

			// Comrpobar que hay en la posicion
			if (computer.checkPos(pos)) {
				// Guardar submarino hundido
				System.out.printf("%s\n[Player] Submarino alcanzado!\n%s", Helper.YELLOW, Helper.RESET);
				player.addToKnown(pos, true);

			} else {
				// Guardar agua
				player.addToKnown(pos, false);
			}

			// Turno del ordenador
			pos = computer.generatePos();

			// Comprobar que hay en la posicion
			if (player.checkPos(pos)) {
				// Guardar sibmarino hundido
				System.out.printf("%s\n[Computer] Submarino alcanzado!\n%s", Helper.YELLOW, Helper.RESET);
				computer.addToKnown(pos, true);
			} else {
				// Guardar agua
				computer.addToKnown(pos, false);
			}

			System.out.println();

		} while (!player.loose() && !computer.loose());

		// Si hay empate
		if (computer.loose() && player.loose()) {
			System.out.println("Panel del jugador: ");
			player.printWholePanel();

			System.out.println("\nPanel del ordenador: ");
			computer.printWholePanel();

			System.out.printf("%s\n\nEmpate!\n%s", Helper.YELLOW, Helper.RESET);
		}

		// Si gana el jugador
		else if (computer.loose()) {
			System.out.println("Panel del jugador: ");
			player.printKnownPanel();

			System.out.println("\nPanel del ordenador: ");
			computer.printWholePanel();

			System.out.printf("%s\n\nEl jugador gana!\n%s", Helper.YELLOW, Helper.RESET);
		}

		// Si gana el ordenador
		else {
			System.out.println("Panel del ordenador: ");
			computer.printKnownPanel();

			System.out.println("\nPanel del jugador: ");
			player.printWholePanel();

			System.out.printf("%s\n\nEl ordenador gana!\n%s", Helper.YELLOW, Helper.RESET);
		}
	}
}
