package ejercicio02;

import java.util.Arrays;

public class Parejas {
	// Colores
	final String BLUE = "\u001b[36m";
	final String RED = "\u001b[31m";
	final String RESET = "\u001b[0m";

	// Array de parejas
	int partners[];
	// Array para enseñar
	boolean guessedPartners[];
	// Parejas acertadas
	int guesses;

	/**
	 * Constructor vacío
	 */
	public Parejas() {
	}

	/**
	 * Constructor
	 * 
	 * @param size Tamaño, debe de ser par
	 */
	public Parejas(int size) {
		// Es necesario que el tamaño sea par
		if (size % 2 != 0) {
			System.out.printf("%sEl tamaño debe ser par, se ajustara automaticamente.\n%s", RED, RESET);
			size++;
		}

		// Generar parejas
		partners = fillPartner(size);

		// Inicializar parejas acertadas
		guessedPartners = new boolean[partners.length];
	}

	/**
	 * Rellena un array con parejas
	 * 
	 * @param size tamaño del array
	 * @return Array con parejas
	 */
	int[] fillPartner(int size) {
		int arr[];

		// Si el tamaño es par
		if (size % 2 == 0) {
			// Array para rellenar
			arr = new int[size];
			// Ultimo numero usado
			int lastNum = 0;
			// Posicion random
			int pos;
			// Contador de vuelta
			int i = 0;

			// -1 significa vacío :)
			Arrays.fill(arr, -1);

			// Si mide 10, generar 5 numeros
			while (lastNum < arr.length / 2) {
				// Guardar el numero generado en dos posiciones vacías
				while (i < 2) {
					// Generar posicion random
					pos = (int) (Math.random() * arr.length);

					// Si esa posicion esta vacía
					if (arr[pos] == -1) {
						// Guardar numero
						arr[pos] = lastNum;
						i++;
					}
				}
				lastNum++;
				i = 0;
			}
		} else
			arr = new int[0];

		return arr;
	}

	/**
	 * Mira si las parejas son correctas
	 * 
	 * @param index1 Casilla 1
	 * @param index2 Casilla 2
	 * @return true si la pareja es correcta, false en caso contrario
	 */
	public boolean checkPair(int index1, int index2) {
		if (index1 < 0 || index2 < 0 || index1 >= partners.length || index2 >= partners.length)
			return false;
		
		if (!(partners[index1] == partners[index2]))
			return false;

		guessedPartners[index1] = true;
		guessedPartners[index2] = true;

		guesses++;

		return true;
	}

	/**
	 * Imprime las parejas o casillas vacias si aun no se han descubierto
	 */
	public void printBoard() {
		for (int i = 0; i < partners.length; i++) {
			if (guessedPartners[i])
				System.out.printf("[%d]", partners[i]);
			else
				System.out.printf("[ ]");
		}
		System.out.println();
	}

	public String printPartners() {
		return Arrays.toString(partners);
	}

	public boolean win() {
		return guesses == partners.length / 2;
	}
}
